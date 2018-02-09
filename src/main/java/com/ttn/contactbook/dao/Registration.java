package com.ttn.contactbook.dao;

import com.ttn.contactbook.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface Registration {

     void addUser(User user);



}
