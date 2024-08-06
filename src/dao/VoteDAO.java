package dao;
import model.VoteVO;
import util.DBconJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 설문 참여 == 생성
// 설문 응답 항목 업데이트 == 업데이트
// 설문 참여 여부 확인 == 셀렉트

public class VoteDAO {

    // Create 설문 참여
    public boolean createVote(VoteVO vote) throws SQLException {
        String sql = "INSERT INTO t_vote (survey_no, id, one_two, vote_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vote.getSurveyNo());
            stmt.setString(2, vote.getId());
            stmt.setInt(3, vote.getOneTwo());
            stmt.setDate(4, vote.getVoteDate());
            stmt.executeUpdate();
        } // 기본키 외래키 설정을 해놨기 때문에 survey_no, id가 문제 생길 수 있다.
        // 참조하는 설베이 테이블에 값이 있으면 입력이 될꺼고, 없는 값이면 입력이 되지 않을꺼다
        return false;
    }

    // Read 설문 참여 여부 확인
    public VoteVO readVote(int surveyNo, String id) throws SQLException {
        String sql = "SELECT * FROM t_vote WHERE survey_no = ? AND id = ?";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, surveyNo);
            stmt.setString(2, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                VoteVO vote = new VoteVO();
                vote.setSurveyNo(rs.getInt("survey_no"));
                vote.setId(rs.getString("id"));
                vote.setOneTwo(rs.getInt("one_two"));
                vote.setVoteDate(rs.getDate("vote_date"));
                return vote;
            }
        }
        return null;
    }

    // Update
    public boolean updateVote(VoteVO vote) throws SQLException {
        String sql = "UPDATE t_vote SET one_two = ?, vote_date = ? WHERE survey_no = ? AND id = ?";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vote.getOneTwo());
            stmt.setDate(2, vote.getVoteDate());
            stmt.setInt(3, vote.getSurveyNo());
            stmt.setString(4, vote.getId());
            stmt.executeUpdate();
        }
        return false;
    }

    // Delete
    public boolean deleteVote(int surveyNo, String id) throws SQLException {
        String sql = "DELETE FROM t_vote WHERE survey_no = ? AND id = ?";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, surveyNo);
            stmt.setString(2, id);
            stmt.executeUpdate();
        }
        return false;
    }
}