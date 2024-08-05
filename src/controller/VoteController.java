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

public class VoteController {

    private final VoteDAO voteDAO;

    public VoteController() {
        this.voteDAO = new VoteDAO();
    }

    public void createVote(VoteVO vote) throws SQLException {
        if (voteDAO.createVote(vote)) {
            System.out.println("Vote added successfully.");
        } else {
            System.out.println("Failed to add vote.");
        }
    }

    public VoteVO readVote(int surveyNo, String id) throws SQLException {
        VoteVO vote = voteDAO.readVote(surveyNo, id);
        if (vote == null) {
            System.out.println("Vote not found.");
        }
        return vote;
    }

    public void updateVote(VoteVO vote) throws SQLException {
        if (voteDAO.updateVote(vote)) {
            System.out.println("Vote updated successfully.");
        } else {
            System.out.println("Failed to update vote.");
        }
    }

    public void deleteVote(int surveyNo, String id) throws SQLException {
        if (voteDAO.deleteVote(surveyNo, id)) {
            System.out.println("Vote deleted successfully.");
        } else {
            System.out.println("Failed to delete vote.");
        }
    }
}