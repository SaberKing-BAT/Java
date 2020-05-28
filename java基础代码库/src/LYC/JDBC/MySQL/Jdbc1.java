package LYC.JDBC.MySQL;

import java.sql.*;

public class Jdbc1 {
    static String driver="com.mysql.cj.jdbc.Driver";
    static String username = "root";
    static String password = "20161921";
    static String url = "jdbc:mysql://127.0.0.1:3306/ssm?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE";
    static String url1 = "jdbc:mysql://localhost:3306/ssm?useSSL=false&serverTimezone=UTC";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String sql1 = " select * from account";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url1,username,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()){
                int id = resultSet.getInt(1);   // 下标从一开始
                String name = resultSet.getString(2);
                double money = resultSet.getDouble(3);
                System.out.println(id+name+money);
            }
    }
}
