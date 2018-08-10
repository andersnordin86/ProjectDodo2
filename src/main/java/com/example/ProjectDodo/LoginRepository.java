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



    public Boolean checkUsernameAndEmail(String userName, String email) {
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

    }



