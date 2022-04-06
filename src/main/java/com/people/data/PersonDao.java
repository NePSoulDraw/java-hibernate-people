
package com.people.data;

import com.people.domain.Person;
import java.util.List;
import javax.persistence.*;

public class PersonDao implements IPersonDao{
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PersonDao(){
        emf = Persistence.createEntityManagerFactory("hibernate-people");
        em = emf.createEntityManager();
    }
    
    @Override
    public List<Person> getAllPeople(){
        
        String hql = "SELECT p FROM Person p";
        
        Query query = em.createQuery(hql);
        
        List<Person> people = query.getResultList();
        
        return people;
        
    }
    
    @Override
    public Person getPerson(Person person) {
        
        return person;
        
    }
    
    @Override
    public int insertPerson(Person person){
        
        return 1;
        
    }

    @Override
    public int updatePerson(Person person) {
        
        return 1;
        
    }

    @Override
    public int deletePerson(Person person) {
        
        return 1;
        
    }
    
}
