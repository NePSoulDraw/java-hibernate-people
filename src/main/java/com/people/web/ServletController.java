
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
        
        this.deployInfo(req, res);
        
    }
    
    private void deployInfo(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        List<Person> people = new PersonService().getAllPeople();
        
        HttpSession session = req.getSession();
        
        session.setAttribute("people", people);
        
        res.sendRedirect("people.jsp");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        String action = req.getParameter("action");
        
        if(action != null){
            
            switch(action){
                case "insert":
                    this.insertPerson(req, res);
                    break;
                default:
                    this.deployInfo(req, res);
            }
            
        }else{
            this.deployInfo(req, res);
        }
        
    }
    
    private void insertPerson(HttpServletRequest req, HttpServletResponse res) 
                   throws ServletException, IOException{
        
        String name = req.getParameter("name");
        
        String surname = req.getParameter("surname");
        
        String email = req.getParameter("email");
        
        int phone = 0;
        
        String phoneString = req.getParameter("phone");
        
        if(phoneString != null && !"".equals(phoneString)){
            
            phone = Integer.parseInt(phoneString);
            
        }
        
        Person person = new Person(name, surname, email, phone);
        
        new PersonService().createPerson(person);
        
        this.deployInfo(req, res);
        
    }
    
}
