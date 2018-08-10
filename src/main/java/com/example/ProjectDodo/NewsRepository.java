package com.example.ProjectDodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
