package com.academy.ticketservice.controller;

import com.academy.ticketservice.dto.TicketModelDto;
import com.academy.ticketservice.dto.TicketOrderDto;
import com.academy.ticketservice.service.TicketServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketServiceInterface ticketService;

    @GetMapping("{eventId}")
    public String getOrderTicketPage(Model model,
                                     @PathVariable("eventId") Long eventId) {

        model.addAttribute("orderDto", new TicketOrderDto());
        model.addAttribute("currentEventId", eventId);

        return "tickets/ticket-order-presentation.html";
    }

    @PostMapping("")
    public String orderAnTicket(Model model,
                                @ModelAttribute TicketOrderDto ticketOrder) {

        TicketModelDto ticketModelDto = ticketService.orderAnTicket(ticketOrder);
        model.addAttribute("ticket", ticketModelDto);

        return "tickets/ticket-order.html";
    }

    @GetMapping("/securityCheck/{ticketId}")
    public String getCurrentTicketById(Model model,
                                       @PathVariable("ticketId") Long ticketId) {

        TicketModelDto ticketModelDto = ticketService.getTicketById(ticketId);
        model.addAttribute("ticket", ticketModelDto);

        return "tickets/ticket-order.html";
    }

}