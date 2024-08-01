package com.example.Assignment17.controller;

import com.example.Assignment17.model.Contact;
import com.example.Assignment17.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MainController {

    private final ContactService contactService;

    // Injects the ContactService dependency
    public MainController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Handles POST requests to create a contact
    @PostMapping("/create-contact")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }


    // Handles GET requests to retrieve all contacts
    @GetMapping("/get-all-contacts")
    public Map<String, Contact> getAllContact() {
        return contactService.getAllContact();
    }

    // Handles GET requests to retrieve a specific contact by name
    @GetMapping("/get-contact/{name}")
    public Contact getContact(@PathVariable("name") String name) {
        return contactService.getContact(name);
    }

    // Handles PUT requests to update a contact by name
    @PutMapping("/update-contact/{name}")
    public Contact updateContact(@PathVariable("name") String name, @RequestBody Contact contact) {
        contactService.updateContact(name, contact);
        return contact;
    }

    // Handles DELETE requests to delete a contact by name
    @DeleteMapping("delete-contact/{name}")
    public void deleteContact(@PathVariable("name") String name) {
        contactService.deleteContact(name);
    }

}
