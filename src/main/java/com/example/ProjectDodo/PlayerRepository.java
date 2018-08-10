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
public class PlayerRepository {

    @Autowired
    public DataSource dataSource;

    public List<Player> getPlayers() {
        List<Player> allPlayers = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM team");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Player p = new Player(
                        resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("image"));
                allPlayers.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allPlayers;
    }


    public void newEvent(String firstname,
                         String lastname,
                         String image) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO team(firstname, lastname, image)VALUES(?, ?, ?)");
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, image);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
