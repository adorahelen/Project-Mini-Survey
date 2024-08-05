package controller;

import model.MemberVO;
import model.VoteVO;
import model.SurveyVO;

import dao.SurveyDAO;
import dao.VoteDAO;
import dao.MemberDAO;

import util.DBconJDBC;

import java.util.Scanner;
import java.sql.SQLException;

public class SurveyController {

    private final SurveyDAO surveyDAO;

    public SurveyController() {
        this.surveyDAO = new SurveyDAO();
    }

    public void createSurvey(SurveyVO survey) throws SQLException {
        if (surveyDAO.createSurvey(survey)) {
            System.out.println("Survey added successfully.");
        } else {
            System.out.println("Failed to add survey.");
        }
    }

    public SurveyVO readSurvey(int surveyNo) throws SQLException {
        SurveyVO survey = surveyDAO.readSurvey(surveyNo);
        if (survey == null) {
            System.out.println("Survey not found.");
        }
        return survey;
    }

    public void updateSurvey(SurveyVO survey) throws SQLException {
        if (surveyDAO.updateSurvey(survey)) {
            System.out.println("Survey updated successfully.");
        } else {
            System.out.println("Failed to update survey.");
        }
    }

    public void deleteSurvey(int surveyNo) throws SQLException {
        if (surveyDAO.deleteSurvey(surveyNo)) {
            System.out.println("Survey deleted successfully.");
        } else {
            System.out.println("Failed to delete survey.");
        }
    }
}