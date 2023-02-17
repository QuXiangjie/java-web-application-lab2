package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import domain.Customer;
import database.CustomerDA;

public class LoginServlet extends HttpServlet {
        
       protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
                         //System.out.println("this is the request="+request);
       //System.out.println("this is the response="+response);
        String url = "/index.html";
        // get current action
        String option = request.getParameter("option");
        if (option == null) {
            option = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (option.equals("join")) {
            url = "/index.html";    // the "join" page
        }
       /* else if (option.equals("add")) {                
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // store data in User object and save User object in database
            Customer  = new User(firstName, lastName, email);
            user.add();
            
            // set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp";   // the "thanks" page
        }*/
        
        // forward request and response objects to specified URL
        //System.out.println("this is the getServletContext()"+getServletContext());
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
        
        
    }    
    
    protected void doGet(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {
        doPost(request, response);
    }    
}
