//showTemperature.java

package TemperatureSensor;

import java.sql.*;

public class showTemperature {
    private showTemperature() {
    }

    private void Show() throws SQLException {
        Connection connection;
        Statement sql;
        ResultSet rs;
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "74521");
        String sqlStr = "select * from sample";
        try {
            int i = 0;
            float sumTmp = 0;
            sql = connection.createStatement();
            rs = sql.executeQuery(sqlStr);
            while (rs.next()) {
                float temp = rs.getFloat(2);
                System.out.printf("当前温度是：%.2f\n", temp);
                sumTmp += temp;
                i++;
                Thread.sleep(10000);
                if (i % 6 == 0) {
                    System.out.printf("一分钟内的平均温度是：%.2f\n", sumTmp / 6);
                    sumTmp = 0;
                }
            }
        } catch (SQLException | InterruptedException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) throws SQLException {
        showTemperature s = new showTemperature();
        s.Show();
    }
}
