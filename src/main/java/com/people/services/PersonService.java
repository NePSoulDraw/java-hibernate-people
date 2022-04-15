
package com.people.services;

import com.people.data.PersonDao;
import com.people.domain.Person;
import java.util.*;

import java.util.List;

public class PersonService {
    
    private PersonDao personDao;
    
    public PersonService(){
        
        this.personDao = new PersonDao();
        
    }
    
    public List<Person> getAllPeople(){
        
        return this.personDao.getAllPeople();
        
    }
    
    public List<Person> getAllPeopleSortByName(){
        
        List<Person> peopleList = this.personDao.getAllPeople();
        
        if (peopleList.size() > 0) {
            
            Collections.sort(peopleList, new Comparator<Person>() {
                
                @Override
                public int compare(final Person person1, final Person person2) {
                    
                    return person1.getName().compareTo(person2.getName());
                    
                }
                
            });
        }

        return peopleList;
        
    }
    
    public List<Person> getAllPeopleSortBySurname(){
        
        List<Person> peopleList = this.personDao.getAllPeople();
        
        if (peopleList.size() > 0) {
            
            Collections.sort(peopleList, new Comparator<Person>() {
                
                @Override
                public int compare(final Person person1, final Person person2) {
                    
                    return person1.getSurname().compareTo(person2.getSurname());
                    
                }
                
            });
            
        }

        return peopleList;
        
    }
    
    public List<Person> getAllPeopleSortByPhoneAsc(){
        
        List<Person> peopleList = this.personDao.getAllPeople();
        
        Collections.sort(peopleList, new Comparator<Person>() {

            public int compare(Person person1, Person person2) {

                if (person1.getPhone()> person2.getPhone()) {

                    return 1;

                }

                if (person1.getPhone()< person2.getPhone()) {

                    return -1;

                }

                return 0;

            }

        });
        
        return peopleList;
        
    }
    
    public List<Person> getAllPeopleSortByPhoneDesc(){
        
        List<Person> peopleList = this.personDao.getAllPeople();
        
        Collections.sort(peopleList, new Comparator<Person>() {

            public int compare(Person person1, Person person2) {

                if (person1.getPhone()> person2.getPhone()) {

                    return -1;

                }

                if (person1.getPhone()< person2.getPhone()) {

                    return 1;

                }

                return 0;

            }

        });
        
        return peopleList;
        
    }
    
    public Person getPerson(Person person){
        
        return personDao.getPerson(person);
        
    }
    
    public void createPerson(Person person){
        
        personDao.insertPerson(person);
        
    }
    
    public void updatePerson(Person person){
        
        personDao.updatePerson(person);
        
    }
    
    public void deletePerson(Person person){
        
        personDao.deletePerson(person);
        
    }
    
}