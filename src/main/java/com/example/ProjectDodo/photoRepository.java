package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class photoRepository {

    @Autowired
    public DataSource dataSource;

    public List<photos> getphotos() {
        List<photos> allPhotos = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM gallery");
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                photos p = new photos(resultSet.getInt("imageID"), resultSet.getString("url"), resultSet.getString("title"));
                allPhotos.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allPhotos;
    }
}
