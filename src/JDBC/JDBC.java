package JDBC;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/University";
        String username = "root";
        String password = "Vanossgaming1234!";
        String query = "select * from EngineeringStudents";
        String query2 = "select * from EngineeringStudents where Student_ID = 10201";


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery(query);
            ResultSetMetaData rsmd = results.getMetaData();
            int column_count = rsmd.getColumnCount();
            System.out.println("Column Count is: " + column_count);

            while(results.next()){
                String UniversityData = "";
                for(int i = 1; i <= column_count; i++){
                    UniversityData += results.getString(i) + ":";
                }
                System.out.println(UniversityData);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            ResultSet results = statement.executeQuery(query2);
            while(results.next()){
                String UniversityData = "";
                for(int i = 1; i < 6; i++) {
                    UniversityData += results.getString(i) + ":";
                }
                System.out.println(UniversityData);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
