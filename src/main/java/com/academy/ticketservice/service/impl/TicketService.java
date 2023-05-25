package com.academy.ticketservice.service.impl;

import com.academy.ticketservice.dto.TicketModelDto;
import com.academy.ticketservice.dto.TicketOrderDto;
import com.academy.ticketservice.exception.credential.CredentialsNotFoundException;
import com.academy.ticketservice.exception.event.EventNotFoundException;
import com.academy.ticketservice.exception.location.OutOfLocationSpaceException;
import com.academy.ticketservice.exception.phone.InvalidPhoneNumberException;
import com.academy.ticketservice.exception.ticket.TicketNotFoundException;
import com.academy.ticketservice.exception.user.UserNotFoundException;
import com.academy.ticketservice.model.Credential;
import com.academy.ticketservice.model.Event;
import com.academy.ticketservice.model.User;
import com.academy.ticketservice.repository.CredentialRepository;
import com.academy.ticketservice.repository.EventRepository;
import com.academy.ticketservice.repository.TicketRepository;
import com.academy.ticketservice.repository.UserRepository;
import com.academy.ticketservice.util.mapper.MapperInterface;
import com.academy.ticketservice.model.Ticket;
import com.academy.ticketservice.service.TicketServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService implements TicketServiceInterface {

    @Value("${com.company.qrCode-link}")
    private String qrCodeGeneratorLink;

    @Value("${com.company.validator-Link}")
    private String phoneNumberValidatorLink;

    private final RestTemplate restTemplate;

    private final UserRepository userRepository;

    private final JavaMailSender javaMailSender;

    private final EventRepository eventRepository;

    private final TicketRepository ticketRepository;

    private final CredentialRepository credentialRepository;

    private final MapperInterface<TicketModelDto, Ticket> mapper;

    @Override
    @Transactional
    public TicketModelDto orderAnTicket(TicketOrderDto ticketOrderDto) {

        Credential credential = credentialRepository.findByEmail(ticketOrderDto.getEmail())
                .orElseThrow(() -> new CredentialsNotFoundException("Credentials was not found."));

        User currentUser;

        if (userRepository.existsByCredentialEmail(ticketOrderDto.getEmail())) {
            currentUser = userRepository.getUserByCredential_Email(ticketOrderDto.getEmail())
                    .orElseThrow(() -> new UserNotFoundException("Something went wrong!"));
        } else {
            currentUser = userRepository.save(new User().setCredential(credential));
        }

        if (userRepository.existsByPhoneNumber(ticketOrderDto.getPhoneNumber())) {
            throw new InvalidPhoneNumberException("Phone number is already exists.");
        }

        currentUser.setFirstName(ticketOrderDto.getFirstName());
        currentUser.setSurname(ticketOrderDto.getSurname());
        currentUser.setPhoneNumber(ticketOrderDto.getPhoneNumber());

        Event currentEvent = eventRepository.findById(ticketOrderDto.getEventId())
                .orElseThrow(() -> new EventNotFoundException("Event not found"));

        if (currentEvent.getOccupiedPlace() + 1 > currentEvent.getLocation().getCapacity())
            throw new OutOfLocationSpaceException(currentEvent.getTitle() + " is sold out!");

        currentEvent.setOccupiedPlace((short)(currentEvent.getOccupiedPlace() + 1));

        Ticket currentTicket = new Ticket()
                .setOwner(currentUser)
                .setEventHolding(currentEvent)
                .setOrderDate(Calendar.getInstance().getTime())
                .setQrCode(qrCodeGeneratorLink);

        eventRepository.save(currentEvent);
        ticketRepository.save(currentTicket);

        ticketRepository.save(currentTicket.setQrCode(currentTicket.getQrCode() + currentTicket.getId()));

        sendMessageToCustomer(ticketOrderDto.getEmail(), currentTicket);

        return mapper.mapToDto(currentTicket, TicketModelDto.class);
    }
    @Override
    public TicketModelDto getTicketById(Long id) {
        Ticket currentTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket not found"));

        return mapper.mapToDto(currentTicket, TicketModelDto.class);
    }

    @Override
    public List<TicketModelDto> getAllTicketsByEventId(Long eventId) {
        List<Ticket> ticketList = ticketRepository.getAllByEventHolding_Id(eventId)
                .orElseThrow(() -> new TicketNotFoundException("Tickets not found"));

        return mapper.listToDto(ticketList, TicketModelDto.class);
    }

    @Override
    public List<TicketModelDto> getAllTicketsByUserId(Long userId) {
        List<Ticket> ticketList = ticketRepository.getAllByOwner_Id(userId)
                .orElseThrow(() -> new TicketNotFoundException("Tickets not found"));

        return mapper.listToDto(ticketList, TicketModelDto.class);
    }

    private void sendMessageToCustomer(String customerEmail, Ticket currentTicket) {

        Thread parallelEmailSendingThread = new Thread(() -> {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom("noreply@company.com");
            simpleMailMessage.setTo(customerEmail);

            simpleMailMessage.setSubject("COM.COMPANY: " + currentTicket.getEventHolding().getTitle() + " Ticket Order");
            simpleMailMessage.setText("You are successfully ordered ticket!\n\nYour personal ticket code: "
                    + currentTicket.getId() + "\n\nAnd QR-Code: " + currentTicket.getQrCode());

            javaMailSender.send(simpleMailMessage);
        });

        parallelEmailSendingThread.start();
    }

}
