package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "Servlet_02", urlPatterns = "/Servlet_02")
public class Servlet_02 extends HttpServlet {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departureParam = request.getParameter("departure");
        String departureTimeParam = request.getParameter("departureTime");
        String arrivalParam = request.getParameter("arrival");
        String durationParam = request.getParameter("duration");
        String priceParam = request.getParameter("price");
//        List<Airport> airports = (ArrayList<Airport>) request.getAttribute("airports");
        List<Airport> airports = AirportDao.getList(getServletContext().getRealPath("airports.txt"));

        Long duration = 0L;
        Double price = 0.0;
        ZonedDateTime departureTime;
        ZonedDateTime arrivalTime;

        if (priceParam != null) {
            price = Double.valueOf(priceParam);
        }
        if (durationParam != null) {
            duration = Long.valueOf(durationParam);
        }

        if (departureParam != null &&
                arrivalParam != null &&
                !departureParam.equals(arrivalParam) &&
                priceParam != null &&
                duration != null &&
                departureTimeParam != null &&
                price > 0.0) {
            LocalDateTime departureLocalTime = LocalDateTime.parse(departureTimeParam);
            ZoneId departureZoneId = ZoneId.of(extractTimeZone(airports, departureParam));
            departureTime = departureLocalTime.atZone(departureZoneId);
            ZoneId arrivalZoneId = ZoneId.of(extractTimeZone(airports, arrivalParam));
            arrivalTime = departureTime.plusHours(duration).withZoneSameInstant(arrivalZoneId);

            Flight flight = new Flight();
            flight.setDeparture(departureParam);
            flight.setArrival(arrivalParam);
            flight.setArrivalTime(arrivalTime);
            flight.setPrice(price);

            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);


            response.getWriter().append("<br>")
                    .append("<table cellpadding='4' border='1'>")
                        .append("<tr>")
                            .append("<td></td>")
                            .append("<th> Miasto </th>")
                            .append("<th> Kod </th>")
                            .append("<th> Czas lokalny </th>")
                            .append("<th> Czas lotu </th>")
                            .append("<th> Cena </th>")
                        .append("</tr>")
                        .append("<tr>")
                            .append("<th> Wylot </th>")
                            .append("<td>").append(flight.getDeparture()).append("</td>")
                            .append("<td>").append(extractAirportCode(airports, flight.getDeparture())).append("</td>")
                            .append("<td>").append(dateTimeFormatter.format(departureTime)).append("</td>")
                            .append("<td rowspan='2'>").append(duration + "h").append("</td>")
                            .append("<td rowspan='2'>").append(price + "zł").append("</td>")
                        .append("</tr>")
                        .append("<tr>")
                            .append("<th> Przylot </th>")
                            .append("<td>").append(flight.getArrival()).append("</td>")
                            .append("<td>").append(extractAirportCode(airports, flight.getArrival())).append("</td>")
                            .append("<td>").append(dateTimeFormatter.format(flight.getArrivalTime())).append("</td>")
                        .append("</tr>")
                    .append("</table>");
        }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Airport> airports = AirportDao.getList(getServletContext().getRealPath("airports.txt"));

        request.setAttribute("airports", airports);
        getServletContext().getRequestDispatcher("/index5.jsp").forward(request, response);


    }


    protected String extractTimeZone(List<Airport> airports, String city) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getName().equals(city)){
                return airports.get(i).getTimezone();
            }
        }
        return "";


    }

    protected String extractAirportCode(List<Airport> airports, String city) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getName().equals(city)){
                return airports.get(i).getCode();
            }
        }
        return "";


    }


}
