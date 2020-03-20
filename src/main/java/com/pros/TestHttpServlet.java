package com.pros;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

public class TestHttpServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DataSource dataSource = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/mysql");
        }catch (NamingException ex) {
            String message = "Failed to lookup at: " + ex.getMessage();
            System.out.println();

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println(message);
            return;
        }

        try (Connection connection = dataSource.getConnection()) {
        } catch (SQLException ex) {
            String message = "Failed to get connection: " + ex.getMessage();
            System.out.println(message);

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();
            out.println(message);
            return;
        }

        String message = "Connected to tradeconnex database!";
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(message);
    }
}
