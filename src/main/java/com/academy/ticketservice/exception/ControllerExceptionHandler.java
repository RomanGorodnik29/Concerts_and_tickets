package com.academy.ticketservice.exception;

import com.academy.ticketservice.dto.ExceptionCaughtDto;
import com.academy.ticketservice.exception.artist.ArtistNicknameMismatchException;
import com.academy.ticketservice.exception.artist.ArtistNotFoundException;
import com.academy.ticketservice.exception.credential.CredentialWithSameDataAlreadyExistsException;
import com.academy.ticketservice.exception.credential.CredentialsNotFoundException;
import com.academy.ticketservice.exception.event.EventNotFoundException;
import com.academy.ticketservice.exception.event.EventTitleDuplicateException;
import com.academy.ticketservice.exception.location.LocationTitleDuplicateException;
import com.academy.ticketservice.exception.location.OutOfLocationSpaceException;
import com.academy.ticketservice.exception.other.CameNullEntityException;
import com.academy.ticketservice.exception.phone.InvalidPhoneNumberException;
import com.academy.ticketservice.exception.role.RoleNotFoundException;
import com.academy.ticketservice.exception.ticket.TicketNotFoundException;
import com.academy.ticketservice.exception.user.UserDataMismatchException;
import com.academy.ticketservice.exception.user.UserNotFoundException;
import org.apache.tomcat.util.http.fileupload.InvalidFileNameException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Calendar;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {
            RoleNotFoundException.class,
            UserNotFoundException.class,
            EventNotFoundException.class,
            ArtistNotFoundException.class,
            TicketNotFoundException.class,
            CredentialsNotFoundException.class
    })
    public String resourceNotFoundException(Model model,
                                            RuntimeException exception) {
        ExceptionCaughtDto exceptionCaughtDto = new ExceptionCaughtDto()
                .setStatusId(HttpStatus.NOT_FOUND.value())
                .setTimespan(Calendar.getInstance().getTime().toString())
                .setMessage(exception.getMessage());

        model.addAttribute("error", exceptionCaughtDto);

        return "error.html";
    }

    @ExceptionHandler(value = {
            UserDataMismatchException.class,
            OutOfLocationSpaceException.class,
            EventTitleDuplicateException.class,
            LocationTitleDuplicateException.class,
            ArtistNicknameMismatchException.class,
            CredentialWithSameDataAlreadyExistsException.class,
            InvalidFileNameException.class,
            InvalidPhoneNumberException.class
    })
    public String dataDuplicationException(Model model,
                                           RuntimeException exception) {
        ExceptionCaughtDto exceptionCaughtDto = new ExceptionCaughtDto()
                .setStatusId(HttpStatus.BAD_REQUEST.value())
                .setTimespan(Calendar.getInstance().getTime().toString())
                .setMessage(exception.getMessage());

        model.addAttribute("error", exceptionCaughtDto);

        return "error.html";
    }

    @ExceptionHandler(value = CameNullEntityException.class)
    public String internalServerErrorException(Model model,
                                               RuntimeException exception) {
        ExceptionCaughtDto exceptionCaughtDto = new ExceptionCaughtDto()
                .setStatusId(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setTimespan(Calendar.getInstance().getTime().toString())
                .setMessage(exception.getMessage());

        model.addAttribute("error", exceptionCaughtDto);

        return "error.html";
    }

}
