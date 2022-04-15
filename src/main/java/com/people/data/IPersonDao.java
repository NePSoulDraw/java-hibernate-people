
package com.people.data;

import com.people.domain.Person;
import java.util.List;

public interface IPersonDao {

    List<Person> getAllPeople();
    
    Person getPerson(Person person);
    
    void insertPerson(Person person);
    
    void updatePerson(Person person);
    
    void deletePerson(Person person);
    
}
