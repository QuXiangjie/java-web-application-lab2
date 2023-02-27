package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

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
            try{
            // get parameters from the request
            String UserID = request.getParameter("UserID");
            String Password = request.getParameter("Password");

// set User object in request object and set URL
            CustomerDA customerDA = new CustomerDA(); // Create an instance of the data access class
            customerDA.initialize();
            ArrayList<Customer> customers = CustomerDA.getCustomers();
            Customer customer = customerDA.getCustomer(customers, UserID,Password); // Retrieve the customer with the given user ID
            if (customer != null) {
                HttpSession session = request.getSession();
                session.setAttribute("customer", customer);
                url = "/welcome.jsp";   // the "welcome" page
            } else {
                url = "/Login.jsp";
            }
            }catch(RecordNoFoundException e){
              request.setAttribute("errirNessage",e.getMessage());
              request.getRequestDispatcher("login.jsp").forward(request, response);
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
