package com.gymmanagement.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Payment {
    private int memberId;
    private double amount;
    private String paymentMethod;

    // Updated constructor without planId
    public Payment(int memberId, double amount, String paymentMethod) {
        this.memberId = memberId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    // Update savePayment method to exclude planId
    public void savePayment(Connection conn) throws SQLException {
        String query = "INSERT INTO payments (member_id, amount, payment_method) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, memberId);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, paymentMethod);
            pstmt.executeUpdate();
        }
    }

    // Update Payment Status
    public void updatePaymentStatus(Connection conn, int paymentId, String newStatus) throws SQLException {
        String query = "UPDATE payments SET status = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, paymentId);
            pstmt.executeUpdate();
        }
    }
}
