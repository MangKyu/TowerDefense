package Controller;

import java.sql.*;

public class Database {

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/TOWER";
    private static final String USER_ID = "root";
    private static final String USER_PW = "2";
    private Connection conn;
    private Statement st;

    public Database() {
        try {
            Class.forName(DATABASE_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_ID, USER_PW);
            st = conn.createStatement();

        } catch (SQLSyntaxErrorException e){
            initDatabase();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=2&serverTimezone=UTC");
            st = conn.createStatement();
            st.executeUpdate("CREATE DATABASE TOWER");

            //String sql = "CREATE TABLE tab1 (number1 INTEGER, number2 TINYINT, name CHAR(64))";
            //st.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
