package model;
import java.sql.Date;

public class SurveyVO {

    private int surveyNo; // 설문번호
    private String title; // 설문 제목
    private String one; // 1번항목
    private String two; // 2번항목
    private int oneCnt; // 1번  항목 득표수
    private int twoCnt; // 2번 항목 득푝수
    private Date startDate; // 설문 시작일 - 강사님은 스트링
    private Date endDate; // 설문 종료일 - ;
    private Date regDate; // 설문 등록일
    private Date modDate; // 설문 수정일

    // Getters and Setters
    public int getSurveyNo() {
        return surveyNo;
    }

    public void setSurveyNo(int surveyNo) {
        this.surveyNo = surveyNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public int getOneCnt() {
        return oneCnt;
    }

    public void setOneCnt(int oneCnt) {
        this.oneCnt = oneCnt;
    }

    public int getTwoCnt() {
        return twoCnt;
    }

    public void setTwoCnt(int twoCnt) {
        this.twoCnt = twoCnt;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }
}