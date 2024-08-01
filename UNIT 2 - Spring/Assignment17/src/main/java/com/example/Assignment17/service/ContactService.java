package com.example.Assignment17.service;

import com.example.Assignment17.model.Contact;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContactService {

    // In-memory storage for contacts.
    Map<String, Contact> contacts = new HashMap<>();

    // Creates a new contact.
    public Contact createContact(Contact contact) {
        contacts.put(contact.getFirstName(), contact);
        return contact;
    }

    // Retrieves a contact by first firstName.
    public Contact getContact(String firstName) {
        return contacts.get(firstName);
    }

    // Retrieves all contacts
    public Map<String, Contact> getAllContact() {
        return contacts;
    }

    // Updates an existing contact by replacing it with a new one.
    public void updateContact(String currentName, Contact contact) {
        if (contacts.containsKey(currentName)) {
            String newName = contact.getFirstName();
            contacts.put(newName, contact);
            contacts.remove(currentName);
        }
    }

    // Deletes a contact by first name.
    public void deleteContact(String name ){
        contacts.remove(name);
    }
}
