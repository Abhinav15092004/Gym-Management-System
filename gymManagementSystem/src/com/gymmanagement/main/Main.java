package com.gymmanagement.main;

import com.gymmanagement.payment.Payment;
import com.gymmanagement.dao.MemberDAO;
import com.gymmanagement.dao.TrainerDAO;
import com.gymmanagement.model.Member;
import com.gymmanagement.model.Trainer;
import com.gymmanagement.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemberDAO memberDAO = new MemberDAO();
        TrainerDAO trainerDAO = new TrainerDAO();
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;

        try {
            conn = DatabaseConnection.getConnection();
            while (true) {
                System.out.println("Gym Management System");
                System.out.println("1. Add Member");
                System.out.println("2. View Members");
                System.out.println("3. Add Trainer");
                System.out.println("4. View Trainers");
                System.out.println("5. Add New Payment");
                System.out.println("6. Update Payment Status");
                System.out.println("7. Exit");
                System.out.println("8. Show Members with Completed Fees");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        // Add Member
                        System.out.print("Enter member name: ");
                        String memberName = scanner.nextLine();
                        System.out.print("Enter membership date (yyyy-mm-dd): ");
                        String dateInput = scanner.nextLine();
                        Date membershipDate = Date.valueOf(dateInput);
                        System.out.print("Enter member goal: ");
                        String goal = scanner.nextLine();
                        memberDAO.addMember(memberName, membershipDate, goal);
                        System.out.println("Member added successfully.");
                        break;

                    case 2:
                        // View Members
                        System.out.println("Members:");
                        List<Member> members = memberDAO.getMembers();
                        for (Member member : members) {
                            System.out.println(member);
                        }
                        break;

                    case 3:
                        // Add Trainer
                        System.out.print("Enter trainer name: ");
                        String trainerName = scanner.nextLine();
                        System.out.print("Enter trainer specialty: ");
                        String specialty = scanner.nextLine();
                        trainerDAO.addTrainer(trainerName, specialty);
                        System.out.println("Trainer added successfully.");
                        break;

                    case 4:
                        // View Trainers
                        System.out.println("Trainers:");
                        List<Trainer> trainers = trainerDAO.getTrainers();
                        for (Trainer trainer : trainers) {
                            System.out.println(trainer);
                        }
                        break;

                    case 5: // Add New Payment
                        System.out.println("\n--- Add New Payment ---");

                        System.out.print("Enter Member ID: ");
                        int memberId = scanner.nextInt();

                        System.out.print("Enter Payment Amount: ");
                        double amount = scanner.nextDouble();

                        System.out.print("Enter Payment Method (Credit Card, Debit Card, Cash, UPI): ");
                        String paymentMethod = scanner.next();

                        // Create and save the payment
                        Payment newPayment = new Payment(memberId, amount, paymentMethod);
                        newPayment.savePayment(conn);
                        System.out.println("Payment added successfully!");
                        break;

                    case 6: // Update Payment Status
                        System.out.println("\n--- Update Payment Status ---");

                        System.out.print("Enter Payment ID: ");
                        int paymentId = scanner.nextInt();

                        System.out.print("Enter New Status (Pending, Completed, Failed): ");
                        String newStatus = scanner.next();

                        // Update the payment status
                        Payment paymentToUpdate = new Payment(0, 0, "");  // Dummy object to call updatePaymentStatus
                        paymentToUpdate.updatePaymentStatus(conn, paymentId, newStatus);
                        System.out.println("Payment status updated successfully!");
                        break;

                    case 7:
                        // Exit
                        System.out.println("Exiting...");
                        return; // Exit the program

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                        break;

                    case 8: // Show Members with Completed Fees
                        System.out.println("\n--- Members with Completed Fees ---");
                        try {
                            List<Member> completedFeeMembers = memberDAO.getMembersWithCompletedFees();
                            if (completedFeeMembers.isEmpty()) {
                                System.out.println("No members with completed fees found.");
                            } else {
                                for (Member member : completedFeeMembers) {
                                    System.out.println(member);
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                            System.out.println("Error retrieving members with completed fees.");
                        }
                        break;

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
