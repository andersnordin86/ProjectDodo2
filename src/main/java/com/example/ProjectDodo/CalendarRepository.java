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
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Calendar");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Calendar p = new Calendar(resultSet.getString("start"), resultSet.getString("title"), resultSet.getString("description"));
                allEvents.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return allEvents;
    }


    public void newEvent(String start,
                         String title,
                         String description) {
        Connection conn = null;
        try {
           conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO calendar(start, title, description)VALUES(?, ?, ?)");
            ps.setString(1, start);
            ps.setString(2, title);
            ps.setString(3, description);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
