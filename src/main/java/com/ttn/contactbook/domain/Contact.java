package com.ttn.contactbook.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

@Entity
public class Contact {
    @Id @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int contactId;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    private String name;
    private String email;
    private String phone;
    private String company;

    //private Date dateCreated;
    //private Date lastUpdated;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = ("categoriesAndcontact"),
            joinColumns = { @JoinColumn(name = ("contactId")) },
            inverseJoinColumns = { @JoinColumn(name = ("categoryId")) })
    Set<Categories > categories=new HashSet<Categories>();

    public Set<Categories> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categories> categories) {
        this.categories = categories;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }







    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

   /* public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
*/



}
