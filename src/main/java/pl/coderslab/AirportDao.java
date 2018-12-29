package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirportDao {

    public static List<Airport> getList(String path) {
        System.out.println(path);
        File file = new File(path);
        List<Airport> airports = new ArrayList<>();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                Airport airport = new Airport();
                String[] airportArr = (scan.nextLine()).split(",");
                airport.setName(airportArr[0]);
                airport.setCode(airportArr[1]);
                airport.setTimezone(airportArr[2]);
                airports.add(airport);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return airports;


    }


}
