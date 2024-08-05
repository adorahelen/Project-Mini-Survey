package dao;
import model.SurveyVO;
import util.DBconJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 설문 목록 보기 = 셀렉트 올
// 설문 등록 == 인설트
// 설문 수정 == 업데이트
// 설문 삭제 == 딜리트
// 설문 조회 == 셀렉트


public class SurveyDAO {

    public boolean createSurvey(SurveyVO survey) throws SQLException {
        String sql = "INSERT INTO t_survey (survey_no, title, one, two, one_cnt, two_cnt, start_date, end_date, reg_date, mod_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, survey.getSurveyNo());
            stmt.setString(2, survey.getTitle());
            stmt.setString(3, survey.getOne());
            stmt.setString(4, survey.getTwo());
            stmt.setInt(5, survey.getOneCnt());
            stmt.setInt(6, survey.getTwoCnt());
            stmt.setDate(7, survey.getStartDate());
            stmt.setDate(8, survey.getEndDate());
            stmt.setDate(9, survey.getRegDate());
            stmt.setDate(10, survey.getModDate());
            stmt.executeUpdate();
        }
        return false;
    }


    public SurveyVO readSurvey(int surveyNo) throws SQLException {
        String sql = "SELECT * FROM t_survey WHERE survey_no = ?";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, surveyNo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                SurveyVO survey = new SurveyVO();
                survey.setSurveyNo(rs.getInt("survey_no"));
                survey.setTitle(rs.getString("title"));
                survey.setOne(rs.getString("one"));
                survey.setTwo(rs.getString("two"));
                survey.setOneCnt(rs.getInt("one_cnt"));
                survey.setTwoCnt(rs.getInt("two_cnt"));
                survey.setStartDate(rs.getDate("start_date"));
                survey.setEndDate(rs.getDate("end_date"));
                survey.setRegDate(rs.getDate("reg_date"));
                survey.setModDate(rs.getDate("mod_date"));
                return survey;
            }
        }
        return null;
    }

    // Update
    public boolean updateSurvey(SurveyVO survey) throws SQLException {
        String sql = "UPDATE t_survey SET title = ?, one = ?, two = ?, one_cnt = ?, two_cnt = ?, start_date = ?, end_date = ?, reg_date = ?, mod_date = ? WHERE survey_no = ?";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, survey.getTitle());
            stmt.setString(2, survey.getOne());
            stmt.setString(3, survey.getTwo());
            stmt.setInt(4, survey.getOneCnt());
            stmt.setInt(5, survey.getTwoCnt());
            stmt.setDate(6, survey.getStartDate());
            stmt.setDate(7, survey.getEndDate());
            stmt.setDate(8, survey.getRegDate());
            stmt.setDate(9, survey.getModDate());
            stmt.setInt(10, survey.getSurveyNo());
            stmt.executeUpdate();
        }
        return false;
    }

    // Delete
    public boolean deleteSurvey(int surveyNo) throws SQLException {
        String sql = "DELETE FROM t_survey WHERE survey_no = ?";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, surveyNo);
            stmt.executeUpdate();
        }
        return false;
    }


}
