package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalendarRepository {


    @Autowired
    public DataSource dataSource;

    public List<Calendar> getEvents() {
        List<Calendar> allEvents = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Calendar");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Calendar p = new Calendar(resultSet.getString("start"), resultSet.getString("title"), resultSet.getString("description"));
                allEvents.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allEvents;
    }


    public void newEvent(String start,
                         String title,
                         String description) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO calendar(start, title, description)VALUES(?, ?, ?)");
            ps.setString(1, start);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
