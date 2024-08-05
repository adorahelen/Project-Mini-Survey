package util;
import java.sql.*;

public class DBconJDBC {

    //1. 데이터베이스 연결 공유 객체를 클래스 외부에서 접근할 수 없도록 선언
    private static Connection con;

    //2. 기본생성자를 선언하여 클래스 외부에서 접근할 수 없도록 처리
    private DBconJDBC() { }

    //3. 필드로 선언된 객체를 반환하는 클래스 메서드 getConnection 작성
    //   단, 필드가 null인 경우에는 객체를 생성하여 반환하도록 처리
    public static Connection getConnection(){
        if( con == null ) {
            String url = "jdbc:mysql://localhost:3306/JDBC"; //mysql 접속 정보 및 스키마 선택
            String username = "root";   //mysql 접속 계정
            String password = "12345678";   //      "      의 비밀번호

            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }

    //** 4 ~ 7은 모두 공유 메서드로 작성
    //4. ResultSet 객체와 PreparedStatement 객체를 매개변수로 받아서 닫는 close 메서드 작성
    public static void close(ResultSet rs, PreparedStatement pstmt){
        try {   //객체 생성 역순으로 닫음
            if( rs != null )        rs.close();
            if( pstmt != null )     pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //5. ResultSet 객체와 Statement 객체를 매개변수로 받아서 닫는 close 메서드 오버로딩
    public static void close(ResultSet rs, Statement stmt){
        try {
            if( rs != null )        rs.close();
            if( stmt != null )      stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //6. PreparedStatement 객체를 매개변수로 받아서 닫는 close 메서드 오버로딩
    public static void close(PreparedStatement pstmt){
        try {
            if( pstmt != null )     pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //7. 필드로 선언된 객체를 닫는 close 메서드 오버로딩
    public static void close(){
        try {
            if( con != null )     con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

// 이렇게 많은 CLOSE 메소드가 필요할까?