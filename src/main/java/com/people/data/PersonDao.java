
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
    @SuppressWarnings("unchecked")
    public List<Person> getAllPeople(){
        
        String hql = "SELECT p FROM Person p";
        
        Query query = em.createQuery(hql);
        
        List<Person> people = query.getResultList();
        
        return people;
        
    }
    
    @Override
    public Person getPerson(Person person) {
        
        return em.find(Person.class, person.getPersonId());
        
    }
    
    @Override
    public void insertPerson(Person person){
        
        try {
            
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
            
        } finally {
            
            if (em != null){
                em.close();
            }
            
        }
        
    }

    @Override
    public void updatePerson(Person person) {
        
        try {
            
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
            
        } finally {
            
            if (em != null){
                em.close();
            }
            
        }
        
    }

    @Override
    public void deletePerson(Person person) {
        
        Person personForDelete = this.getPerson(person);
        
        try {
            
            em.getTransaction().begin();
            em.remove(em.merge(personForDelete));
            em.getTransaction().commit();
            
        } catch (Exception ex) {
            
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
            
        } finally {
            
            if (em != null){
                em.close();
            }
            
        }
        
    }
    
}
