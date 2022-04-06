
package com.people.web;

import com.people.domain.Person;
import com.people.services.PersonService;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        
        PersonService personService = new PersonService();
        
        List<Person> allPeople = personService.getAllPeople();
        
        req.setAttribute("people", allPeople);
        
        req.getRequestDispatcher("/WEB-INF/peopleList.jsp").forward(req, res);
        
    }
    
    
}
