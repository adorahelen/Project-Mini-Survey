package dao;
import model.MemberVO;
import util.DBconJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 회원여부 확인 == 셀렉트
// 가입 == 인설트
// 수정 == 업데이트
// 삭제 == 딜리트
// 조회 == 셀렉트
// 목록 == 셀렉트 올

public class MemberDAO {

    // Create
    public boolean createMember(MemberVO member) throws SQLException {
        String sql = "INSERT INTO t_member (mid, mname, mpw, email, gender, photo, birth_date, join_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, member.getMid());
            stmt.setString(2, member.getMname());
            stmt.setString(3, member.getMpw());
            stmt.setString(4, member.getEmail());
            stmt.setString(5, member.getGender());
            stmt.setString(6, member.getPhoto());
            stmt.setDate(7, member.getBirthDate());
            stmt.setDate(8, member.getJoinDate());
            stmt.executeUpdate();
        }
        return false;
    }

    // Read
    public MemberVO readMember(String mid) throws SQLException {
        String sql = "SELECT * FROM t_member WHERE mid = ?";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                MemberVO member = new MemberVO();
                member.setMid(rs.getString("mid"));
                member.setMname(rs.getString("mname"));
                member.setMpw(rs.getString("mpw"));
                member.setEmail(rs.getString("email"));
                member.setGender(rs.getString("gender"));
                member.setPhoto(rs.getString("photo"));
                member.setBirthDate(rs.getDate("birth_date"));
                member.setJoinDate(rs.getDate("join_date"));
                return member;
            }
        }
        return null;
    }

    // Update
    public boolean updateMember(MemberVO member) throws SQLException {
        String sql = "UPDATE t_member SET mname = ?, mpw = ?, email = ?, gender = ?, photo = ?, birth_date = ?, join_date = ? WHERE mid = ?";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, member.getMname());
            stmt.setString(2, member.getMpw());
            stmt.setString(3, member.getEmail());
            stmt.setString(4, member.getGender());
            stmt.setString(5, member.getPhoto());
            stmt.setDate(6, member.getBirthDate());
            stmt.setDate(7, member.getJoinDate());
            stmt.setString(8, member.getMid());
            stmt.executeUpdate();
        }
        return false;
    }

    // Delete
    public boolean deleteMember(String mid) throws SQLException {
        String sql = "DELETE FROM t_member WHERE mid = ?";
        try (Connection conn = DBconJDBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, mid);
            stmt.executeUpdate();
        }
        return false;
    }
}