package com.gymmanagement.dao;

import com.gymmanagement.database.DatabaseConnection;
import com.gymmanagement.model.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    public void addMember(String name, Date membershipDate, String goal) {
        String sql = "INSERT INTO members (name, membership_date, goal) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDate(2, membershipDate);
            stmt.setString(3, goal);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Member> getMembers() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date membershipDate = rs.getDate("membership_date");
                String goal = rs.getString("goal");
                members.add(new Member(id, name, membershipDate, goal));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
    // Method to get members with completed fees
    public List<Member> getMembersWithCompletedFees() throws SQLException {
        List<Member> members = new ArrayList<>();
        String query = "SELECT DISTINCT m.* " +
                "FROM members m " +
                "JOIN payments p ON m.id = p.member_id " +
                "WHERE p.status = 'Completed'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setMembershipDate(rs.getDate("membership_date"));
                member.setGoal(rs.getString("goal"));
                members.add(member);
            }
        }
        return members;
    }
}

