package dbops;

import java.sql.*;

public class orderQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement sql;
        ResultSet rs;
//        String url = "jdbc:mysql://127.0.0.1:3306/test?user=root&password=74521";
        connection = getConn.connectDB("student", "root", "74521");
        try {
            sql = connection.createStatement();
            rs = sql.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                String number = rs.getString(1);
                String name = rs.getString(2);
                Date date = rs.getDate(3);
                float height = rs.getFloat(4);
                System.out.printf("%s\t", number);
                System.out.printf("%s\t", name);
                System.out.printf("%s\t", date);
                System.out.printf("%.2f\n", height);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
