package com.ttn.contactbook.dao;

import com.ttn.contactbook.domain.Contact;
import com.ttn.contactbook.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface ContactOperations {

    String addContactUser(Contact contact,User user);
    void editContact(Contact contact);
    void deleteContact(Contact contact);
    boolean checkContact(Contact contact,User user);
}
