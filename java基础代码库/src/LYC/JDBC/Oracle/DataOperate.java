package LYC.JDBC.Oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataOperate {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;


    public void Query() throws SQLException {
        String sql="select  * from  MYUSER1.\"test\" order by ID";
        connection=Conn.getconn();
        statement=connection.createStatement();
        resultSet=statement.executeQuery(sql);
        while (resultSet.next()){
            int id= resultSet.getInt("id");
            String name =resultSet.getString("name");
            System.out.println("id=" + id + "--" + "name=" + name );
        }
    }
    public static void main(String[] args) throws SQLException {
        DataOperate dataOperate=new DataOperate();
        dataOperate.Query();
    }

}
