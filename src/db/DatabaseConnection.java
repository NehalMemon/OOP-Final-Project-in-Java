package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:students.db";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("✅ SQLite Connected");
            return conn;
        } catch (Exception e) {
            System.out.println("❌ SQLite Connection Failed");
            e.printStackTrace();
            return null;
        }
    }
}
