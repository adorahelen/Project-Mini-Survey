package model;
import java.sql.Date;

public class VoteVO {

    private int surveyNo; // 설문번호
    private String id; // 설문 참여자
    private int oneTwo; // 투표 항목
    private Date voteDate; // 설문 참여일
    // 디비를 보면서 매핑, 자바니까 언더 바 없이 대소문자로 그리고 필드는 프라이빗으로 정보은닉과 보호
    // 밑에는 퍼블릭으로 메소드 접근 가능하게 하여 입출력 바꾸도록

    // Getters and Setters
    public int getSurveyNo() {
        return surveyNo;
    }

    public void setSurveyNo(int surveyNo) {
        this.surveyNo = surveyNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOneTwo() {
        return oneTwo;
    }

    public void setOneTwo(int oneTwo) {
        this.oneTwo = oneTwo;
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }
}