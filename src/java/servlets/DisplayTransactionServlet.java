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
            String accountNumberString = request.getParameter("accountNumber");
            int accountNumber = Integer.parseInt(accountNumberString);
            System.out.println("this is accountNumber" + accountNumber);
            HttpSession session = request.getSession();
            if (accountNumber != 0) {
                AccountDA accountDA = new AccountDA() {
                };
                ArrayList<Account> accounts = accountDA.getAccounts();
                for (int i = 0; i < accounts.size(); i++) {

                    if (accountNumber == accounts.get(i).getAccountNumber()) {
                        int balance = accounts.get(i).getbalance();
                        session.setAttribute("balance", balance);

                    }
                }

                ArrayList<Transaction> transaction = Transaction.find(accountNumber);

                session.setAttribute("transactions", transaction);

            } else {
                // handle case where accountNumber is null
            }

        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
