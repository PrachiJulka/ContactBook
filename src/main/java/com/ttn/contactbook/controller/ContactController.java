package com.ttn.contactbook.controller;

import com.ttn.contactbook.dao.ContactOperations;
import com.ttn.contactbook.domain.Categories;
import com.ttn.contactbook.domain.Contact;
import com.ttn.contactbook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Cache;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ContactController {

    @Autowired
    ContactOperations contactOperations;

    @RequestMapping(value = "/addContact")
    @ResponseBody
    public String addContact(HttpServletRequest request,HttpSession session, @ModelAttribute("categories") Contact contact) {
        System.out.println("in contact");
       session  = request.getSession(false);

       User user=(User)session.getAttribute("user");
        System.out.println(user.getUserId());
        String valid=contactOperations.addContactUser(contact,user);
        System.out.println(valid);
        return "{}";
    }
   @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public String editContact(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("contact") Contact contact) {



        return ("redirect:/");
    }
    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public String deleteContact(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("contact") Contact contact) {



        return ("redirect:/");
    }

}
