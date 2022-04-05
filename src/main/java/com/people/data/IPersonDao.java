
package com.people.data;

import com.people.domain.Person;
import java.util.List;

public interface IPersonDao {

    List<Person> getAllPeople();
    
    Person getPerson(Person person);
    
    int insertPerson(Person person);
    
    int updatePerson(Person person);
    
    int deletePerson(Person person);
    
}
