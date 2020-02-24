//sentTemperature.java

package TemperatureSensor;

import java.sql.*;

class sentTemperature {
    private sentTemperature() {
    }

    private float genTemperature() {
        int max = 25, min = 15;
        return (float) (Math.random() * (max - min) + min);
    }

    private void sentTemp() throws SQLException {
        Connection connection;
        PreparedStatement preSql;
        ResultSet rs;
        String sqlStr = "insert into sample values(?,?)";
        connection = DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/test", "root", "74521");
        try {
            int i = 0;
            while (i<20) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                preSql = connection.prepareStatement(sqlStr);
                preSql.setTimestamp(1, timestamp);
                preSql.setFloat(2, genTemperature());
                int ok = preSql.executeUpdate();
                i++;
                Thread.sleep(10000);

            }
            connection.close();

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException {
        sentTemperature s = new sentTemperature();
        s.sentTemp();
    }
}
