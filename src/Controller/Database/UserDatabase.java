package Controller.Database;

import java.sql.*;

public class UserDatabase {

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/TOWER?&serverTimezone=UTC";
    private static final String USER_ID = "root";
    private static final String USER_PW = "2";
    private Connection conn;
    private Statement st;

    public UserDatabase() {
        boolean connectFlag = connectDB();
        if (!connectFlag) {
            initDatabase();
            connectDB();
            createTables();
        }
    }

    private void initDatabase() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=2&serverTimezone=UTC");
            st = conn.createStatement();
            st.executeUpdate("CREATE DATABASE TOWER");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean connectDB() {
        boolean connectFlag = false;
        try {
            Class.forName(DATABASE_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER_ID, USER_PW);
            st = conn.createStatement();
            connectFlag = true;
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Create Database");
            //e.printStackTrace();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connectFlag;
    }

    private void createTables() {
        // http://hmkcode.com/java-mybatis-mysql/
        try {
            String sql = "DROP TABLE IF EXISTS USER_INFO;";
            st.execute(sql);
            sql = "CREATE TABLE USER_INFO ( " +
                    "ID VARCHAR(20) NOT NULL PRIMARY KEY COMMENT '사용자 아이디', " +
                    "PW VARCHAR(20) NOT NULL COMMENT '사용자 비밀번호', " +
                    "MONEY INTEGER(11) DEFAULT 0 COMMENT '사용자 금액', " +
                    "SCORE INTEGER(11) DEFAULT 0 COMMENT '사용자 점수'" +
                    ") DEFAULT CHARACTER SET UTF8 COMMENT '사용자 정보 테이블'";
            st.execute(sql);

            sql = "DROP TABLE IF EXISTS LEVEL_INFO;";
            st.execute(sql);

            sql = "CREATE TABLE LEVEL_INFO( " +
                    "UNIT_A INTEGER(5) DEFAULT 1 COMMENT '유닛A의 레벨', " +
                    "UNIT_B INTEGER(5) DEFAULT 1 COMMENT '유닛B의 레벨', " +
                    "UNIT_C INTEGER(5) DEFAULT 1 COMMENT '유닛C의 레벨', " +
                    "UNIT_D INTEGER(5) DEFAULT 1 COMMENT '유닛D의 레벨', " +
                    "UNIT_E INTEGER(5) DEFAULT 1 COMMENT '유닛E의 레벨', " +
                    "UNIT_F INTEGER(5) DEFAULT 1 COMMENT '유닛F의 레벨'  " +
                    ") DEFAULT CHARACTER SET UTF8 COMMENT '사용자 유닛 레벨 테이블'";
            st.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
