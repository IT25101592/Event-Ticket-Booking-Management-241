package com.example.eventbookingsystem.eventController;

import com.example.eventbookingsystem.eventModel.Event;
import com.example.eventbookingsystem.eventService.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    private final EventService eventService;

    public PageController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event-page")
    public String showEventPage(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "event";
    }

    @GetMapping("/event-page/{type}")
    public String showEventsByType(@PathVariable String type, Model model) {
        model.addAttribute("events", eventService.getAllEvents()
                .stream()
                .filter(event -> event.getType().equalsIgnoreCase(type))
                .toList());
        return "event";
    }

    @GetMapping("/add-page")
    public String showAddPage() {
        return "addEvent";
    }

    @GetMapping("/update-page")
    public String showUpdatePage() {
        return "updateEvent";
    }

    @GetMapping("/delete-page")
    public String showDeletePage() {
        return "deleteEvent";
    }

    @GetMapping("/event-details/{id}")
    public String showEventDetails(@PathVariable int id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);

        String imagePath = "/images/default.jpg";

        if (event.getType().equalsIgnoreCase("concert")) {
            imagePath = "/images/concert.jpg";
        } else if (event.getType().equalsIgnoreCase("seminar")) {
            imagePath = "/images/seminar.jpg";
        } else if (event.getType().equalsIgnoreCase("edm")) {
            imagePath = "/images/edm.jpg";
        } else if (event.getType().equalsIgnoreCase("sports")) {
            imagePath = "/images/sports.jpg";
        } else if (event.getType().equalsIgnoreCase("conference")) {
            imagePath = "/images/conference.jpg";
        }

        model.addAttribute("imagePath", imagePath);

        return "details";
    }

    @PostMapping("/add-event-form")
    public String addEventFromForm(Event event) {
        eventService.addEvent(event);
        return "redirect:/event-page";
    }

    @PostMapping("/delete-event-form")
    public String deleteEventFromForm(int id) {
        eventService.deleteEvent(id);
        return "redirect:/event-page";
    }

    @PostMapping("/update-event-form")
    public String updateEventFromForm(Event event) {
        eventService.updateEvent(event.getId(), event);
        return "redirect:/event-page";
    }
}