package com.ttn.contactbook.controller;

import com.ttn.contactbook.dao.CategoriesOperations;
import com.ttn.contactbook.dao.ContactOperations;
import com.ttn.contactbook.domain.Categories;
import com.ttn.contactbook.domain.Contact;
import com.ttn.contactbook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CategoryController {


    @Autowired
    CategoriesOperations categoriesOperations;

    @Autowired
    ContactOperations contactOperations;

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addContact(HttpServletRequest request, HttpServletResponse response, HttpSession session, @ModelAttribute("categories") Categories categories) {
        System.out.println("in category");
        session  = request.getSession(false);
        User user=(User) session.getAttribute("user");
        String valid= categoriesOperations.addCategory(categories,user);
        return "{}";

  }
    @RequestMapping(value = "/editCategory", method = RequestMethod.GET)
    public String editCategory(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("contact") Contact contact) {



        return ("redirect:/");
    }
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
    public String deleteCategory(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("contact") Contact contact) {



        return ("redirect:/");
    }
}
