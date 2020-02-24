package dbops;

import java.sql.*;

public class PrepossessingDB {
    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preSql;
        ResultSet rs;
        connection=getConn.connectDB("student","root","74521");
        String sqlStr="insert into student values(?,?,?,?)";
        try {
            preSql=connection.prepareStatement(sqlStr);
            preSql.setString(1,"A001");
            preSql.setString(2,"刘伟");
            preSql.setString(3,"1999-9-10");
            preSql.setFloat(4,1.17f);
            int ok =preSql.executeUpdate();
            sqlStr="select * from student where name like ?";
            preSql=connection.prepareStatement(sqlStr);
            preSql.setString(1,"张%");
            rs=preSql.executeQuery();
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
