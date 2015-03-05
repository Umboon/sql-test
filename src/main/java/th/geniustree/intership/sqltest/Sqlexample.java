/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.geniustree.intership.sqltest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author oom
 */
public class Sqlexample {

    public static void main(String[] args) throws SQLException {
        
        Connection connection = null;
        try {
             connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", null);
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery("SELECT *FROM TEST");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String sex = rs.getString("Sex");
                Date date = rs.getDate("BOD");
                System.out.println("ID = " + id + " Name " + name + " Sex " + sex + " BOD " + date);
            }
        } finally {
            if (connection != null){
                connection.close();
            }
        }

    }
}
