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

    public void addNews(String headline, String storytext, String imageurl) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO stories(headline, storytext, imageurl) VALUES(?,?,?)", new String[] {"id"} );
            ps.setString(1,headline);
            ps.setString(2,storytext);
            ps.setString(3, imageurl);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Stories> getStories() {
        List <Stories> allStories = new ArrayList<>();
        List <Stories> allStoriesNewFirst = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM stories");
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Stories story = new Stories(
                        resultSet.getDate("createddate"),
                        resultSet.getString("headline"),
                        resultSet.getString("storytext"),
                        resultSet.getString("imageurl"));
                allStories.add(story);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i =allStories.size()-1;i>0;i--){
            allStoriesNewFirst.add(allStories.get(i));
            System.out.println(i);
        }
        return allStoriesNewFirst;
    }
}
