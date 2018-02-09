package com.ttn.contactbook.dao;

import com.ttn.contactbook.domain.Categories;
import com.ttn.contactbook.domain.Contact;
import org.springframework.stereotype.Component;

@Component
public interface SearchContact {
    void searchByName(Contact contact);
    void searchByCategory(Categories categories);
}
