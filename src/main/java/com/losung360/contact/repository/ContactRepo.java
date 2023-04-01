package com.losung360.contact.repository;

import com.losung360.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {

    List<Contact> findByFirstNameContainingOrLastNameContainingOrEmailContaining(String firstName, String lastName, String email);

}
