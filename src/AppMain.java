import java.sql.SQLException;

public class AppMain {

// 설베이 메인 호출 || 맴버 메인 호출 이런식으로
// 여기는 메인 메서드
// 컨트롤로는 메서드만



    public static void main(String[] args) {
        View view = new View();
        try {
            view.displayMenu();
            // 지금은 이렇게 메뉴를 먼저 띄우지만, 만약 로그인 기능을 도입한다면?
            // 로그인 화면 메뉴를 먼저 띄운다음, 조건을 충족하면 메뉴를 띄우는 함수를 호출하게끔
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}