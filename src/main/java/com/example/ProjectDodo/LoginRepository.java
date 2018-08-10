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
public class LoginRepository {

    @Autowired
    public DataSource dataSource;

        public boolean getMember(String userName, String password) {

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM members WHERE username=? AND password=?");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                  return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public void addMember(String username, String firstname, String lastname, String password, String email) {
        try {
            System.out.println("addmember");
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO members(username,firstname,lastname,password,email) VALUES(?,?,?,?,?)", new String[] {"id"} );
            ps.setString(1,username);
            ps.setString(2,firstname);
            ps.setString(3,lastname);
            ps.setString(4,password);
            ps.setString(5,email);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Boolean checkMember(String userName, String email) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM members WHERE username=? OR email=?");
            ps.setString(1, userName);
            ps.setString(2, email);
            ResultSet resultSet = ps.executeQuery();
            System.out.println(ps);
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Members> getUsers() {
        List <Members> allUsers = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM members");
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Members user = new Members(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("email"), resultSet.getString("username"),
                        resultSet.getString("password"), resultSet.getDate("created"), resultSet.getDate("lastlogin"), resultSet.getString("email"), resultSet.getBoolean("admin"));

                allUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }


}
