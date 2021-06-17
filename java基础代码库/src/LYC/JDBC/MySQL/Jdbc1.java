package LYC.JDBC.MySQL;

import java.sql.*;

public class Jdbc1 {
    static String driver="com.mysql.cj.jdbc.Driver";
    static String username = "root";
    static String password = "123456";
    static String url = "jdbc:mysql://192.168.3.101:3306/jdbc_test?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE";
    static String url1 = "jdbc:mysql://192.168.3.101:3306/jdbc_test?useSSL=false&serverTimezone=UTC";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String sql1 = "SELECT * FROM test1 ORDER BY id";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url1,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()){
                int id = resultSet.getInt(1);   // 下标从一开始
                String name = resultSet.getString(2);
                System.out.println(id+name);
            }
    }
}
