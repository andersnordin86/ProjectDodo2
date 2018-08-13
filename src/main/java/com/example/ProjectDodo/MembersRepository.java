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
public class MembersRepository {

    @Autowired
    public DataSource dataSource;

    private int userid;

    public boolean getMember(String userName, String password) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM members WHERE username=? AND password=?");
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                this.userid = resultSet.getInt("id");
                return true;
            } else {
                return false;
            }
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

        return false;
    }

    public void addMember(String username, String firstname, String lastname, String password, String email) {
        try {

            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO members(username,firstname,lastname,password,email) VALUES(?,?,?,?,?)", new String[]{"id"});
            ps.setString(1, username);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, password);
            ps.setString(5, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editMemberInformation(String username, String firstname, String lastname, String password, String email){
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE members SET username=?, firstname=?, lastname=?, password=?, email=? WHERE id = ?" );
            ps.setString(1, username);
            ps.setString(2, firstname);
            ps.setString(3,lastname);
            ps.setString(4,password);
            ps.setString(5,email);
            ps.setInt(6,this.userid);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public List<Members> getAllMembers() {
        List<Members> allUsers = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM members");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Members user = new Members(resultSet.getString("username"),

                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("password"),
                        resultSet.getString("email"));


                        allUsers.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }
    public List<Members> getLoggdeInMembers() {
        List<Members> allUsers = new ArrayList<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM members WHERE id=?");
            ps.setInt(1,this.userid);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Members user = new Members(resultSet.getString("username"),

                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("password"),
                        resultSet.getString("email"));


                allUsers.add(user);
            }
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
        return allUsers;
    }

    public Boolean checkToEditUserInformation(String userName, String email) {
            Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM members WHERE (username=? OR email=?) AND NOT id=? ");
            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setInt(3,this.userid);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}