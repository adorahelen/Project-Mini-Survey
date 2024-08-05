package model;
import java.sql.Date;

public class SurveyVO {

    private int surveyNo;
    private String title;
    private String one;
    private String two;
    private int oneCnt;
    private int twoCnt;
    private Date startDate;
    private Date endDate;
    private Date regDate;
    private Date modDate;

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