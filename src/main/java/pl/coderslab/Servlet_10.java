package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet_10", urlPatterns = "/Servlet_10")
public class Servlet_10 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jumpToPage = request.getParameter("jumpToPage");

        if (jumpToPage == null) {
            jumpToPage = "1";
        }
        switch (jumpToPage) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                break;
            default:
                jumpToPage = "1";
                break;
        }
        addToHistory(request, jumpToPage);
        response.sendRedirect("index10" + jumpToPage + ".jsp");
    }

    public static void addToHistory(HttpServletRequest request, String pageNumber) {
        List<String> history = (ArrayList) request.getSession().getAttribute("history");
        if (history == null) {
            history = new ArrayList<>();
        }
        history.add("Strona " + pageNumber);
        request.getSession().setAttribute("history", history);
    }

}