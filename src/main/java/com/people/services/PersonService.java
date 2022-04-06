
package com.people.services;

import com.people.data.PersonDao;
import com.people.domain.Person;

import java.util.List;

public class PersonService {
    
    private PersonDao personDao;
    
    public PersonService(){
        
        this.personDao = new PersonDao();
        
    }
    
    public List<Person> getAllPeople(){
        
        return this.personDao.getAllPeople();
        
    }
    
}
