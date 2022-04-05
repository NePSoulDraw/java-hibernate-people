
package com.people.data;

import com.people.domain.Person;
import java.util.List;
import javax.persistence.*;

public class PersonDao{
    
    // Apply PersonDao interface
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PersonDao(){
        emf = Persistence.createEntityManagerFactory("hibernate-people");
        em = emf.createEntityManager();
    }
    
    public void getAllPeople(){
    }
    
    public void getPerson(Person person) {
    }
    
    public void insertPerson(Person person){
        
    }

    public void updatePerson(Person person) {
    }

    public void deletePerson(Person person) {
    }
    
}
