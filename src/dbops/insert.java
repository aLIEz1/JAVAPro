package dbops;

import java.sql.*;

public class insert {
    public static void main(String[] args) {
        Connection connection;
        Statement sql;
        ResultSet rs;
        connection = getConn.connectDB("student", "root", "74521");
        if (connection == null){
            return;
        }
        String records="('R11','张三','2000-10-23',1.66),"+"('R13','李四','2010-1-20',1.83)";
        String sqlStr="insert into student values"+records;
        try {
            sql=connection.createStatement();
            //int ok=sql.executeUpdate(sqlStr);
            rs=sql.executeQuery("select * from student");
            while (rs.next()){
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
            e.printStackTrace();
        }

    }
}
