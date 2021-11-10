package fr.matthieu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnection {
    private Connection databaseLink;

    public Connection getConnection() {
        String db = "group_assoc";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/" + db;
        Statement stmt;
        ResultSet res;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.databaseLink = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
            stmt = databaseLink.createStatement();
            res = stmt.executeQuery("SELECT * FROM user");
            while(res.next()) {
                System.out.printf("User_name: %s | User_password: %s | User_id: %d\n", res.getString("user_name"), res.getString("user_password"), res.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection Error");
        }
        return this.databaseLink;
    }
}