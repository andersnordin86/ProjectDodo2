package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsRepository {

    @Autowired
    public DataSource dataSource;

    public void addNews(String headline, String storytext) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO stories(headline, storytext) VALUES(?,?)", new String[] {"id"} );
            ps.setString(1,headline);
            ps.setString(2,storytext);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Stories> getStories() {
        List <Stories> allStories = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM stories");
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Stories story = new Stories(
                        resultSet.getDate("createddate"),
                        resultSet.getString("headline"),
                        resultSet.getString("storytext"));
                allStories.add(story);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allStories;
    }
}
