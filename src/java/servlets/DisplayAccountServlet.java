package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import exceptions.RecordNoFoundException;
import exceptions.*;

import domain.*;
import database.*;
import java.util.ArrayList;

public class DisplayAccountServlet extends HttpServlet {

    private AccountDA accountDA;

    public void init() throws ServletException {
        System.out.println("this is display init");
        accountDA = new AccountDA();
        accountDA.initialize();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/accountList.jsp";
        // get current action
        String option = request.getParameter("option");

        if (option == null) {
            option = "logout";  // default action
        }
        // perform action and set URL to appropriate page
        if (option.equals("logout")) {
            url = "/Login.jsp";
        } else if (option.equals("accounts")) {

            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            ArrayList<Account> accounts = accountDA.findAccount(customer.getCustomerID());
            session.setAttribute("accounts", accounts);

        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
