package com.losung360.contact.controller;

import com.losung360.contact.entity.Contact;
import com.losung360.contact.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    @Operation(summary = "Get all contacts")
    public ResponseEntity<List<Contact>> fetchAllContacts() {
        return ResponseEntity.ok().body(contactService.getAllContacts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a  contact by id")
    public ResponseEntity<Contact> findContactById(@PathVariable Long id) {
        return new ResponseEntity<>(contactService.findContactById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a new contact")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.createContact(contact),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a new contact")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id,@RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.updateContact(id, contact),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a contact")
    public ResponseEntity<?> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/search")
    @Operation(summary = "Search new contacts")
    public ResponseEntity<List<Contact>> searchContact(@RequestParam String query) {
        return new ResponseEntity<>(contactService.searchContact(query),HttpStatus.OK);
    }
}

