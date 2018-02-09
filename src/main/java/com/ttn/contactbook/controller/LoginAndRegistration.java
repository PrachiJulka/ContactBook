package com.ttn.contactbook.controller;

//import com.ttn.contactbook.domain.User;

import com.ttn.contactbook.dao.LoginOperations;
import com.ttn.contactbook.domain.User;
import com.ttn.contactbook.dao.Registration;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import java.util.Collection;

@Controller
public class LoginAndRegistration {

    @Autowired
    Registration registration;

    @Autowired
    LoginOperations loginOperations;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
        //      System.out.println("in reg");
        //  String valid= userImplement.addUser(user);
        registration.addUser(user);

        return ("redirect:/");
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        //      System.out.println("in reg");
        //  String valid= userImplement.addUser(user);
       // registration.addUser(user);

        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
//
//        return "login";
//    }

   /* @RequestMapping(value = "/accessdeniedu", method = RequestMethod.GET)
    public String home(SecurityContextHolder auth) {
        Collection<? extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        String role = null;
//set page default to rules common

        for (int i = 0; i < granted.size(); i++) {
            role = granted.toArray()[i] + "";
            System.out.println("role verified" + i + " is -> " + role);
            //verify if user contain role to view dashboard page default
            if (role.equals("ROLE_DASHBOARD")) {
                System.out.println("IDENTIFIED: ROLE_DASHBOARD = " + role);
            }
        }
        return "accessdeniedu";
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logIn(HttpServletRequest request, HttpServletResponse response, HttpSession session /*SecurityContextHolder auth*/ , @ModelAttribute("user") User user) {
    //    Collection<? extends GrantedAuthority> granted = auth.getContext().getAuthentication().getAuthorities();
        String role = null;
//set page default to rules common
        boolean result = loginOperations.checkUser(user);
        System.out.println("user = " +user);
        System.out.println("user id=  " +user.getUserId());
        System.out.println("user name = " +user.getUserName());

        session=request.getSession(false);
        if (result == true) {

            session.setAttribute("user",user);
//            model.setViewName("dashboard");
            //List userData=userImplement.getUserData(Username);
            //System.out.println(userData.get(0));
            System.out.println(user.getUserId());
            return "contactPage";
        } else {

            request.setAttribute("msg","Not a valid Username or Password");
            return ("redirect:/");
        }


       /* for (int i = 0; i < granted.size(); i++) {
            role = granted.toArray()[i] + "";
            System.out.println("role verified" + i + " is -> " + role);
            //verify if user contain role to view dashboard page default
            if (role.equals("ROLE_DASHBOARD")) {
                System.out.println("IDENTIFIED: ROLE_DASHBOARD = " + role);
            }
        }
        if (role.equals("USER")) {
            session.setAttribute("user",user);
            return "contactPage";
        } else {
            return "login";
        }*/
    }

    @RequestMapping(value = "/contactpage", method = RequestMethod.GET)
    public String cp() {
        return "contactPage";
    }
}
