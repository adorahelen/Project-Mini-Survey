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

public class MemberController {

    private static MemberDAO memberDAO;

    public MemberController() {
        memberDAO = new MemberDAO();
    }

    // Unhandled exception: java.sql.SQLException
    // 밑에 전부 예외처리만 해주면 되는데 트라이 캐치 써버렸다
    // 딱히 상관은 없을 거 같은데 이게 원인이면 설베이 컨트롤러 따라하고
    // 그게 원인이면 이거 따라 할ㄷ것
    MemberVO member = new MemberVO();
    public void createMember(MemberVO member) {
        try {
            if (memberDAO.createMember(member)) {
                System.out.println("Member added successfully.");
            } else {
                System.out.println("Failed to add member.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MemberVO readMember(String mid) {
        MemberVO member = null;
        try {
            member = memberDAO.readMember(mid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (member == null) {
            System.out.println("Member not found.");
        }
        return member;
    }

    public void updateMember(MemberVO member) {
        try {
            if (memberDAO.updateMember(member)) {
                System.out.println("Member updated successfully.");
            } else {
                System.out.println("Failed to update member.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMember(String mid) {
        try {
            if (memberDAO.deleteMember(mid)) {
                System.out.println("Member deleted successfully.");
            } else {
                System.out.println("Failed to delete member.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}