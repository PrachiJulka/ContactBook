package com.ttn.contactbook.dao;

import com.ttn.contactbook.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface LoginOperations {

    boolean checkUser(User user);
}
