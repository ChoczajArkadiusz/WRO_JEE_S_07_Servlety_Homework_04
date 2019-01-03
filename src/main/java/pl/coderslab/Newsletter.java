package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "Newsletter", urlPatterns = "/newsletter")
public class Newsletter extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String submitAccept = request.getParameter("submitAccept");
        String submitReject = request.getParameter("submitReject");

        if (email != null && NewsletterUser.isEmailValid(email) && name != null && submitAccept != null) {
            Cookie acceptNewsletter = new Cookie("acceptNewsletter", "true");
            acceptNewsletter.setMaxAge(60 * 60 * 24 * 365 * 50);
            response.addCookie(acceptNewsletter);

            try {
                Connection connection = DBUtil.getConn();
                NewsletterUser.saveToDB(connection, email, name);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if (submitReject != null) {
            Cookie rejectNewsletter = new Cookie("rejectNewsletter", "true");
            rejectNewsletter.setMaxAge(60 * 60 * 24);
            response.addCookie(rejectNewsletter);
        }
        response.sendRedirect("/newsletter");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain");

        Cookie acceptNewsletter = null;
        Cookie rejectNewsletter = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("acceptNewsletter".equals(cookie.getName())) {
                    acceptNewsletter = cookie;
                }
                if ("rejectNewsletter".equals(cookie.getName())) {
                    rejectNewsletter = cookie;
                }
            }
        }
        if ((acceptNewsletter != null && acceptNewsletter.getValue().equals("true")) ||
                rejectNewsletter != null && rejectNewsletter.getValue().equals("true")) {
            request.setAttribute("showNewsletterForm", 0);
        } else {
            request.setAttribute("showNewsletterForm", 1);
        }
        getServletContext().getRequestDispatcher("/newsletter.jsp").forward(request, response);
    }


}