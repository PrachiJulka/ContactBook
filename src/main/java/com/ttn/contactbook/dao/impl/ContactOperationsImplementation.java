package com.ttn.contactbook.dao.impl;

import com.ttn.contactbook.dao.ContactOperations;
import com.ttn.contactbook.domain.Contact;
import com.ttn.contactbook.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class ContactOperationsImplementation implements ContactOperations {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String addContactUser(Contact contact, User user){
        String message="Contact Already Created";
        System.out.println(user.getUserId());
        boolean flag=true;
        contact.setUser(user);
        flag=checkContact(contact,user);

        if(flag==true) {
            Session session=sessionFactory.openSession();
            session.beginTransaction();
            session.save(contact);
            session.getTransaction().commit();
            session.close();
            message="Created Contact Success";
        }
       System.out.println(message);
        return message;


    }

    public void deleteContact(Contact contact){

    }
    public void editContact(Contact contact){

    }
    public boolean checkContact(Contact contact,User user){
        boolean flag=true;
        Session session = sessionFactory.openSession();
        System.out.println("in checkcontact");
        session.beginTransaction();
        String checkCategory=contact.getName();
        Query query=session.createQuery("from Contact where name=? And user_userId=?");
        query.setParameter(0,contact.getName());
        System.out.println("aaaaa "+ user.getUserId());
        query.setParameter(1,user.getUserId());
        List list = query.getResultList();

        if ((list != null) && (list.size() > 0)) {
            System.out.println("hello1");
            flag=false;
        }
        session.getTransaction().commit();
        session.close();

        return flag;

    }

}
