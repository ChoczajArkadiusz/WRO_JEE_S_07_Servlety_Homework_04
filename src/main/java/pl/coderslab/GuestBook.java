package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(name = "GuestBook", urlPatterns = "/guest-book")
public class GuestBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        String name = request.getParameter("name");
        String message = request.getParameter("message");

        if (name != null && !name.equals("") && message != null && !message.equals("")) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Entry entry = new Entry(timestamp, name, message);
            try {
                Connection connection = DBUtil.getConn();
                entry.saveToDB(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        try {
            Connection connection = DBUtil.getConn();
            Entry[] entries = Entry.loadAll(connection);
            request.setAttribute("entries", entries);
            getServletContext().getRequestDispatcher("/guest-book.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/guest-book.jsp");
    }


}