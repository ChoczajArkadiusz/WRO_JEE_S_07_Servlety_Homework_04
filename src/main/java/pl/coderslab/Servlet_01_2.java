package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_01_2", urlPatterns = "/Servlet_01_2")
public class Servlet_01_2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("language");
        Cookie cookie = new Cookie("language", language);
        response.addCookie(cookie);
        response.sendRedirect("/Servlet_01_1");


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("language", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect("/Servlet_01_1");


    }


}
