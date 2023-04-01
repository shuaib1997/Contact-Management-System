package com.losung360.contact.service;

import com.losung360.contact.entity.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getAllContacts();
    public Contact findContactById(Long id);
    public Contact createContact(Contact contact);
    public Contact updateContact(Long id,Contact contact);
    public void deleteContact(Long id);
    public List<Contact> searchContact(String query);
}
