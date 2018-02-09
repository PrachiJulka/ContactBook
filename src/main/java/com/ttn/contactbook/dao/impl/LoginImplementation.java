package com.ttn.contactbook.dao.impl;


import com.ttn.contactbook.dao.LoginOperations;
import com.ttn.contactbook.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class LoginImplementation implements LoginOperations {
    @Autowired
    private SessionFactory sessionFactory;


    public boolean checkUser(User user){
        //System.out.println("In Check login");
        Session session = sessionFactory.openSession();
        boolean IsuserFound = false;
        //Query using Hibernate Query Language
        //String SQL_QUERY ="from User where username=?";

        session.beginTransaction();
        //System.out.println(Password);
        Query query = session.createQuery("select password from User  where username=? And password=?");
        query.setParameter(0,user.getUserName());
        query.setParameter(1,user.getPassword());
        List list = query.getResultList();
        if ((list != null) && (list.size() > 0)) {
                IsuserFound= true;
            }
        session.getTransaction().commit();
        session.close();
        return IsuserFound;

    }
}
