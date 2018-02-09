package com.ttn.contactbook.dao.impl;

import com.ttn.contactbook.dao.CategoriesOperations;
import com.ttn.contactbook.domain.Categories;
import com.ttn.contactbook.domain.Contact;
import com.ttn.contactbook.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class CategoriesOperationsImplementation implements CategoriesOperations {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public String addCategory(Categories categories,User user) {

        String message="Topic Already Created";

        boolean flag=true;
        flag=checkCategory(categories,user);
        if(flag==true) {
            Session session=sessionFactory.openSession();
            session.beginTransaction();
            session.save(categories);
            session.getTransaction().commit();
            session.close();
            message="Created Topic Success";
        }
        return message;

    }

    public boolean checkCategory(Categories categories, User user){

        boolean flag=true;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String checkCategory=categories.getName();
        Query query=session.createQuery("from Categories where User.userId=? AND Categories.name=?");
        query.setParameter(0,user.getUserId());
        query.setParameter(1,categories.getCategoryId());
        List list = query.getResultList();

        if ((list != null) && (list.size() > 0)) {
            System.out.println("hello1");
            flag=false;
        }
        session.getTransaction().commit();
        session.close();

        return flag;
    }

    public void deleteCategory(Categories categories,User user) {

    }

    public void editCategory(Categories categories,User user) {

    }
}
