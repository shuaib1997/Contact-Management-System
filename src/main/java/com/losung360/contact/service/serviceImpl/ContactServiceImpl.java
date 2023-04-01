package com.losung360.contact.service.serviceImpl;

import com.losung360.contact.entity.Contact;
import com.losung360.contact.exception.ResourceNotFoundException;
import com.losung360.contact.repository.ContactRepo;
import com.losung360.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }

    public Contact findContactById(Long id) {
        return contactRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id",id+""));
    }

    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public Contact updateContact(Long id, Contact contact) {
        Contact existingContact = findContactById(id);
        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setPhoneNumber(contact.getPhoneNumber());
        return contactRepo.save(existingContact);
    }

    public void deleteContact(Long id) {
        Contact contact = findContactById(id);
        contactRepo.delete(contact);
    }

    public List<Contact> searchContact(String query) {
        return contactRepo.findByFirstNameContainingOrLastNameContainingOrEmailContaining(query, query, query);
    }
}
