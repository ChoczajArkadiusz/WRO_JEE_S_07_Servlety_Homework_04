package pl.coderslab;

import java.sql.*;
import java.util.ArrayList;

public class Entry {
    private int id;
    private Timestamp timestamp;
    private String name;
    private String message;

    private static final String sqlAdd = "INSERT INTO Guest_Book(timestamp, name, message) VALUES (?, ?, ?)";
    private static final String sqlLoadAll = "SELECT * FROM Guest_Book ORDER BY timestamp DESC";


    public void saveToDB(Connection conn) throws SQLException {
        String generatedColumns[] = {"ID"};
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sqlAdd, generatedColumns);
        preparedStatement.setTimestamp(1, this.timestamp);
        preparedStatement.setString(2, this.name);
        preparedStatement.setString(3, this.message);
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            this.id = rs.getInt(1);
        }
    }


    public static Entry[] loadAll(Connection conn) throws SQLException {
        ArrayList<Entry> entries = new ArrayList<Entry>();
        PreparedStatement preparedStatement;
        preparedStatement = conn.prepareStatement(sqlLoadAll);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Entry loadedEntry = new Entry();
            loadedEntry.id = resultSet.getInt("id");
            loadedEntry.timestamp = resultSet.getTimestamp("timestamp");
            loadedEntry.name = resultSet.getString("name");
            loadedEntry.message = resultSet.getString("message");
            entries.add(loadedEntry);
        }
        Entry[] uArray = new Entry[entries.size()];
        uArray = entries.toArray(uArray);
        return uArray;
    }


    public Entry() {
    }

    public Entry(Timestamp timestamp, String name, String message) {
        this.timestamp = timestamp;
        this.name = name;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}