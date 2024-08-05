import java.sql.SQLException;

public class AppMain {

// 설베이 메인 호출 || 맴버 메인 호출 이런식으로
// 여기는 메인 메서드
// 컨트롤로는 메서드만



    public static void main(String[] args) {
        View view = new View();
        try {
            view.displayMenu();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}