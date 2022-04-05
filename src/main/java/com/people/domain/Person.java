
package com.people.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "person_id")
    @Id
    private int personId;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private int phone;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" + "personId=" + personId + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone + '}';
    }

}
