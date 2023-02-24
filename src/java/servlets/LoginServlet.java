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
            // get parameters from the request
            String UserID = request.getParameter("UserID");
            String Password = request.getParameter("Password");
            // set User object in request object and set URL
            ArrayList<Customer> customers = CustomerDA.getCustomers();
            System.out.println(customers);
            CustomerDA customerDA = new CustomerDA(); // Create an instance of the data access class
            Customer customer = customerDA.getCustomer(customers, UserID); // Retrieve the customer with the given user ID
            HttpSession session = request.getSession();
            session.setAttribute("cutomer", customer);

            url = "/welcome.jsp";   // the "welcome" page
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
