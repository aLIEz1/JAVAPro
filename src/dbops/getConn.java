package dbops;

import java.sql.*;

public class getConn {
    public static Connection connectDB(String DBName,String id, String password){
        Connection con =null;
        String url = "jdbc:mysql://127.0.0.1:3306/"+DBName;
        try {
            con=DriverManager.getConnection(url,id,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;

    }
}
