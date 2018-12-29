package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet_01_1", urlPatterns = "/Servlet_01_1")
public class Servlet_01_1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Cookie[] cookies = request.getCookies();
        Cookie cookieLanguage = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("language")) {
                cookieLanguage = cookie;
            }
        }

        Map<String, String> lang = new HashMap<>();
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Ehre");
        lang.put("es", "Hola");
        lang.put("fr", "Bienvenue");

        if (cookieLanguage != null && lang.containsKey(cookieLanguage.getValue())) {
            response.getWriter().append(lang.get(cookieLanguage.getValue()));
        } else {
            response.getWriter().append("<h4>  ***  Wybór języka  ***  </h4><br>");
            response.getWriter().append("<form method='post' action='/Servlet_01_2'>");
            response.getWriter().append("<label> wybierz swój język: ")
                    .append("<select name='language'>")
                    .append("   <option value='en'>en</option>")
                    .append("   <option value='pl'>pl</option>")
                    .append("   <option value='de'>de</option>")
                    .append("   <option value='es'>es</option>")
                    .append("   <option value='fr'>fr</option>")
                    .append("</select></label>");
            response.getWriter().append("<input type='submit' name='userSubmit' value='Zatwierdź'/>");
            response.getWriter().append("</form><br />");
        }
        response.getWriter().append("<br><br><br><br>");
        response.getWriter().append("<a href='/Servlet_01_2'> Usuń ciasteczko language </a>");


    }


}
