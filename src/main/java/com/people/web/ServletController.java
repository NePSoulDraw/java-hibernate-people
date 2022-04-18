
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
    
}
