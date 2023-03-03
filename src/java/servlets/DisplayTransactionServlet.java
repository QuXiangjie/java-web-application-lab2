package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import exceptions.RecordNoFoundException;
import exceptions.*;

import domain.*;
import database.*;
import java.util.ArrayList;

public class DisplayTransactionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/transactionlist.jsp";
        // get current action
        String option = request.getParameter("option");

        if (option == null) {
            option = "showtranscation";  // default action
        }
        // perform action and set URL to appropriate page
        if (option.equals("backaccount")) {
            url = "/accountList.jsp";
        } else if (option.equals("showtranscation")) {
            String accountNumber = request.getParameter("accountNumber");
            Transaction transaction = Transaction.find(accountNumber);
            HttpSession session = request.getSession();
            session.setAttribute("transactions", transaction);

        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
