package be.technifutur.java2020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionPSQL {

	private static String DBUrl = "jdbc:postgresql://localhost/Labo2";
    private static String user = "postgres";
    private static String pwd = "19410719";
	
    private static Connection instance;

    private ConnexionPSQL() {

    }

    public static Connection getInstance() throws SQLException {
        if (instance == null) {
            instance = DriverManager.getConnection(DBUrl, user, pwd);
        }

        return instance;
    }
    
    
    
    
    
}
