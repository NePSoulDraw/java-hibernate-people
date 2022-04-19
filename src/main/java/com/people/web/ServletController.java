
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
        
        String action = req.getParameter("action");
        
        if(action != null){
            
            switch(action){
                case "orderByName":
                    this.deployInfoSortByName(req, res);
                    break;
                case "orderBySurname":
                    this.deployInfoSortBySurname(req, res);
                    break;
                case "orderByPhone":
                    this.deployInfoSortByPhone(req, res);
                    break;
                case "edit":
                    this.updatePerson(req, res);
                    break;
                case "delete":
                    this.deletePerson(req, res);
                    break;
                default:
                    this.deployInfo(req, res);
            }
            
        }else{
            this.deployInfo(req, res);
        }
        
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
                case "modify":
                    this.modifyPerson(req, res);
                    break;
                default:
                    this.deployInfo(req, res);
            }
            
        }else{
            this.deployInfo(req, res);
        }
        
    }
    
    private void deployInfo(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        
        List<Person> people = new PersonService().getAllPeople();
        
        HttpSession session = req.getSession();
        
        session.setAttribute("people", people);
        
        res.sendRedirect("people.jsp");
        
    }
    
    private void deployInfoSortByName(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        
        List<Person> people = new PersonService().getAllPeopleSortByName();
        
        HttpSession session = req.getSession();
        
        session.setAttribute("people", people);
        
        res.sendRedirect("people.jsp");
        
    }
    
    private void deployInfoSortBySurname(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        
        List<Person> people = new PersonService().getAllPeopleSortBySurname();
        
        HttpSession session = req.getSession();
        
        session.setAttribute("people", people);
        
        res.sendRedirect("people.jsp");
        
    }
    
    private void deployInfoSortByPhone(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        
        List<Person> people = new PersonService().getAllPeopleSortByPhoneDesc();
        
        HttpSession session = req.getSession();
        
        session.setAttribute("people", people);
        
        res.sendRedirect("people.jsp");
        
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
    
    private void updatePerson(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        
        String personIdString = req.getParameter("personId");
        
        int personId = Integer.parseInt(personIdString);
        
        Person person = new Person(personId);
        
        Person personObtained = new PersonService().getPerson(person);
        
        req.setAttribute("person", personObtained);
        
        req.getRequestDispatcher("/WEB-INF/components/people/editPerson.jsp").forward(req, res);
        
    }
    
    private void modifyPerson(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        
        String personIdString = req.getParameter("personId");
        
        int personId = 0;
        
        String name = req.getParameter("name");
        
        String surname = req.getParameter("surname");
        
        String email = req.getParameter("email");
        
        String phoneString = req.getParameter("phone");
        
        int phone = 0;
        
        if(phoneString != null && !"".equals(phoneString)){
            
            phone = Integer.parseInt(phoneString);
            
        }
        
        if(personIdString != null && !"".equals(personIdString)){
            
            personId = Integer.parseInt(personIdString);
            
        }
        
        Person person = new Person(personId, name, surname, email, phone);
        
        new PersonService().updatePerson(person);
        
        this.deployInfo(req, res);
        
    }
    
    private void deletePerson(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException{
        
        String personIdString = req.getParameter("personId");
        
        int personId = 0;
        
        if(personIdString != null && !"".equals(personIdString)){
            
            personId = Integer.parseInt(personIdString);
            
        }
        
        PersonService personService = new PersonService();
        
        Person person = personService.getPerson(new Person(personId));
        
        personService.deletePerson(person);
        
        this.deployInfo(req, res);
        
    }
    
}