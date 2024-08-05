import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    private static Connection con;
    public TestJDBC() {
        String url = "jdbc:mysql://localhost:3306/JDBC"; //mysql 접속 정보 및 스키마 선택
        String username = "root";   //mysql 접속 계정
        String password = "12345678";   //      "      의 비밀번호
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println(" O K ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        TestJDBC jt = new TestJDBC();
    }
}

