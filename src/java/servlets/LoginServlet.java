package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import exceptions.RecordNoFoundException;
import exceptions.*;

import domain.*;
import database.*;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/Login.jsp";
        // get current action
        String option = request.getParameter("option");

        if (option == null) {
            option = "join";  // default action
        }
        // perform action and set URL to appropriate page
        if (option.equals("join")) {
            url = "/Login.jsp";
        } else if (option.equals("login")) {

            // get parameters from the request
            String UserID = request.getParameter("UserID");
            String Password = request.getParameter("Password");

            // set User object in request object and set URL
            CustomerDA customerDA = new CustomerDA(); // Create an instance of the data access class
            customerDA.initialize();
            Customer customer = customerDA.findCustomer(UserID);
            System.out.println(customer+"customer in the loginsevlet");

            try {
                if (customer != null) {
                    if (Password.equals( customer.getPassword())) {
                        
                        HttpSession session = request.getSession();
                        session.setAttribute("customer", customer);
                        url = "/welcome.jsp";   // the "welcome" page
                    } else {
                        url = "/Error.jsp";

                        throw new RecordNoFoundException();
                    }

                }
            } catch (RecordNoFoundException e) {
                HttpSession session = request.getSession();
                String error_notmatch = "Can not match the password";
                session.setAttribute("Error", error_notmatch);// i don't know how to return the error to the page
            }
            
            try {
                if (customer == null) {
                    url = "/Error.jsp";
                    throw new RecordNoFoundException();
                }
            } catch (RecordNoFoundException e) {
                HttpSession session = request.getSession();
                String error_notfind = "Can not find the Record";
                session.setAttribute("Error", error_notfind);// i don't know how to return the error to the page

            }

        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
