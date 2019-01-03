package pl.coderslab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsletterUser {
    private static final Pattern PATERN_EMAIL = Pattern.compile("[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}");
    private static final String sqlSaveToDB = "INSERT INTO Newsletter_Users(email, name) VALUES (?, ?)";


    public static boolean isEmailValid(String email) {
        Matcher matcher = PATERN_EMAIL.matcher(email);
        return (matcher.matches());
    }


    public static void saveToDB(Connection conn, String email, String name) throws SQLException {
        String[] generatedColumns = {"ID"};

        PreparedStatement preparedStatement
                = conn.prepareStatement(sqlSaveToDB, generatedColumns);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, name);
        preparedStatement.executeUpdate();
    }


}