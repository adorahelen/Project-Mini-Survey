import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import model.MemberVO;
import model.VoteVO;
import model.SurveyVO;

import controller.MemberController;
import controller.SurveyController;
import controller.VoteController;

public class View {

    private final MemberController memberController;
    private final SurveyController surveyController;
    private final VoteController voteController;

    public View() {
        memberController = new MemberController();
        surveyController = new SurveyController();
        voteController = new VoteController();
    }

    public void displayMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Manage Members");
            System.out.println("2. Manage Surveys");
            System.out.println("3. Manage Votes");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> manageMembers(scanner);
                case 2 -> manageSurveys(scanner);
                case 3 -> manageVotes(scanner);
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
// 1번 맴버로 진입시, 만나는 맴버 씨알유디
    private void manageMembers(Scanner scanner) {
        System.out.println("\n--- Manage Members ---");
        System.out.println("1. Add Member");
        System.out.println("2. View Member");
        System.out.println("3. Update Member");
        System.out.println("4. Delete Member");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> addMember(scanner);
            case 2 -> viewMember(scanner);
            case 3 -> updateMember(scanner);
            case 4 -> deleteMember(scanner);
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
// 이거 스캐너로 직접 대입하도록 코드를 작성한거 같은데, private으로 막아놔서 값이 안들어 갈꺼다. 수정 필요할듯
    private void addMember(Scanner scanner) {
        System.out.print("Enter Member ID: ");
        String mid = scanner.nextLine();
        System.out.print("Enter Name: ");
        String mname = scanner.nextLine();
        System.out.print("Enter Password: ");
        String mpw = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Gender (M/F): ");
        String gender = scanner.nextLine();
        System.out.print("Enter Photo URL: ");
        String photo = scanner.nextLine();
        System.out.print("Enter Birth Date (YYYY-MM-DD): ");
        Date birthDate = Date.valueOf(scanner.nextLine());
        System.out.print("Enter Join Date (YYYY-MM-DD): ");
        Date joinDate = Date.valueOf(scanner.nextLine());

        MemberVO member = new MemberVO();
        memberController.createMember(member);
    }

    private void viewMember(Scanner scanner) {
        System.out.print("Enter Member ID: ");
        String mid = scanner.nextLine();
        MemberVO member = memberController.readMember(mid);
        if (member != null) {
            System.out.println("Member Details:");
            System.out.println("Name: " + member.getMname());
            System.out.println("Email: " + member.getEmail());
            System.out.println("Gender: " + member.getGender());
            System.out.println("Photo: " + member.getPhoto());
            System.out.println("Birth Date: " + member.getBirthDate());
            System.out.println("Join Date: " + member.getJoinDate());
        }
    }

    private void updateMember(Scanner scanner) {
        System.out.print("Enter Member ID to Update: ");
        String mid = scanner.nextLine();
        MemberVO member = memberController.readMember(mid);
        if (member != null) {
            System.out.print("Enter New Name (current: " + member.getMname() + "): ");
            member.setMname(scanner.nextLine());
            System.out.print("Enter New Email (current: " + member.getEmail() + "): ");
            member.setEmail(scanner.nextLine());
            System.out.print("Enter New Gender (current: " + member.getGender() + "): ");
            member.setGender(scanner.nextLine());
            System.out.print("Enter New Photo URL (current: " + member.getPhoto() + "): ");
            member.setPhoto(scanner.nextLine());
            System.out.print("Enter New Birth Date (current: " + member.getBirthDate() + "): ");
            member.setBirthDate(Date.valueOf(scanner.nextLine()));
            System.out.print("Enter New Join Date (current: " + member.getJoinDate() + "): ");
            member.setJoinDate(Date.valueOf(scanner.nextLine()));

            memberController.updateMember(member);
        }
    }

    private void deleteMember(Scanner scanner) {
        System.out.print("Enter Member ID to Delete: ");
        String mid = scanner.nextLine();
        memberController.deleteMember(mid);
    }

    // 여기까지가 1번 맴버 관리에 대한 씨알유디

    private void manageSurveys(Scanner scanner) throws SQLException {
        System.out.println("\n--- Manage Surveys ---");
        System.out.println("1. Add Survey");
        System.out.println("2. View Survey");
        System.out.println("3. Update Survey");
        System.out.println("4. Delete Survey");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> addSurvey(scanner);
            case 2 -> viewSurvey(scanner);
            case 3 -> updateSurvey(scanner);
            case 4 -> deleteSurvey(scanner);
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addSurvey(Scanner scanner) throws SQLException {
        System.out.print("Enter Survey Number: ");
        int surveyNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Option One: ");
        String one = scanner.nextLine();
        System.out.print("Enter Option Two: ");
        String two = scanner.nextLine();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        Date startDate = Date.valueOf(scanner.nextLine());
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        Date endDate = Date.valueOf(scanner.nextLine());
        System.out.print("Enter Reg Date (YYYY-MM-DD): ");
        Date regDate = Date.valueOf(scanner.nextLine());
        System.out.print("Enter Mod Date (YYYY-MM-DD): ");
        Date modDate = Date.valueOf(scanner.nextLine());

        SurveyVO survey = new SurveyVO();
        surveyController.createSurvey(survey);
    }

    private void viewSurvey(Scanner scanner) throws SQLException {
        System.out.print("Enter Survey Number: ");
        int surveyNo = scanner.nextInt();
        scanner.nextLine();
        SurveyVO survey = surveyController.readSurvey(surveyNo);
        if (survey != null) {
            System.out.println("Survey Details:");
            System.out.println("Title: " + survey.getTitle());
            System.out.println("Option One: " + survey.getOne());
            System.out.println("Option Two: " + survey.getTwo());
            System.out.println("One Count: " + survey.getOneCnt());
            System.out.println("Two Count: " + survey.getTwoCnt());
            System.out.println("Start Date: " + survey.getStartDate());
            System.out.println("End Date: " + survey.getEndDate());
            System.out.println("Reg Date: " + survey.getRegDate());
            System.out.println("Mod Date: " + survey.getModDate());
        }
    }

    private void updateSurvey(Scanner scanner) throws SQLException {
        System.out.print("Enter Survey Number to Update: ");
        int surveyNo = scanner.nextInt();
        scanner.nextLine();
        SurveyVO survey = surveyController.readSurvey(surveyNo);
        if (survey != null) {
            System.out.print("Enter New Title (current: " + survey.getTitle() + "): ");
            survey.setTitle(scanner.nextLine());
            System.out.print("Enter New Option One (current: " + survey.getOne() + "): ");
            survey.setOne(scanner.nextLine());
            System.out.print("Enter New Option Two (current: " + survey.getTwo() + "): ");
            survey.setTwo(scanner.nextLine());
            System.out.print("Enter New Start Date (current: " + survey.getStartDate() + "): ");
            survey.setStartDate(Date.valueOf(scanner.nextLine()));
            System.out.print("Enter New End Date (current: " + survey.getEndDate() + "): ");
            survey.setEndDate(Date.valueOf(scanner.nextLine()));
            System.out.print("Enter New Reg Date (current: " + survey.getRegDate() + "): ");
            survey.setRegDate(Date.valueOf(scanner.nextLine()));
            System.out.print("Enter New Mod Date (current: " + survey.getModDate() + "): ");
            survey.setModDate(Date.valueOf(scanner.nextLine()));

            surveyController.updateSurvey(survey);
        }
    }

    private void deleteSurvey(Scanner scanner) throws SQLException {
        System.out.print("Enter Survey Number to Delete: ");
        int surveyNo = scanner.nextInt();
        scanner.nextLine();
        surveyController.deleteSurvey(surveyNo);
    }

    private void manageVotes(Scanner scanner) throws SQLException {

        System.out.println("\n- Manage Votes - ");
        System.out.println("1. Add  2. View  3. Update  4. Delete  : choice ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> addVote(scanner);
            case 2 -> viewVote(scanner);
            case 3 -> updateVote(scanner);
            case 4 -> deleteVote(scanner);
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addVote(Scanner scanner) throws SQLException {
        System.out.print("Enter Survey Number: ");
        int surveyNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Choice (1 or 2): ");
        int oneTwo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Vote Date (YYYY-MM-DD): ");
        Date voteDate = Date.valueOf(scanner.nextLine());

        VoteVO vote = new VoteVO();
        voteController.createVote(vote);
    }

    private void viewVote(Scanner scanner) throws SQLException {
        System.out.print("Enter Survey Number: ");
        int surveyNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine();
        VoteVO vote = voteController.readVote(surveyNo, id);
        if (vote != null) {
            System.out.println("Vote Details:");
            System.out.println("Choice: " + vote.getOneTwo());
            System.out.println("Vote Date: " + vote.getVoteDate());
        }
    }

    private void updateVote(Scanner scanner) throws SQLException {
        System.out.print("Enter Survey Number: ");
        int surveyNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine();
        VoteVO vote = voteController.readVote(surveyNo, id);
        if (vote != null) {
            System.out.print("Enter New Choice (1 or 2) (current: " + vote.getOneTwo() + "): ");
            vote.setOneTwo(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Enter New Vote Date (current: " + vote.getVoteDate() + "): ");
            vote.setVoteDate(Date.valueOf(scanner.nextLine()));

            voteController.updateVote(vote);
        }
    }

    private void deleteVote(Scanner scanner) throws SQLException {
        System.out.print("Enter Survey Number: ");
        int surveyNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine();
        voteController.deleteVote(surveyNo, id);
    }
}