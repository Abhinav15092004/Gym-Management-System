package com.gym;

import com.gym.entity.*;
import com.gym.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ShowMain {
    public static void main(String[] args) {
        showData();
    }

    public static void showData() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Retrieving and displaying Members
        List<Member> members = session.createQuery("from Member", Member.class).list();
        System.out.println("Members:");
        for (Member member : members) {
            System.out.println("ID: " + member.getId() + ", Name: " + member.getName() + ", Membership Plan: " + member.getMembershipPlan().getPlanName());
        }

        // Retrieving and displaying Trainers
        List<Trainer> trainers = session.createQuery("from Trainer", Trainer.class).list();
        System.out.println("\nTrainers:");
        for (Trainer trainer : trainers) {
            System.out.println("ID: " + trainer.getId() + ", Name: " + trainer.getName() + ", Specialty: " + trainer.getSpecialty());
        }

        // Retrieving and displaying Membership Plans
        List<MembershipPlan> membershipPlans = session.createQuery("from MembershipPlan", MembershipPlan.class).list();
        System.out.println("\nMembership Plans:");
        for (MembershipPlan plan : membershipPlans) {
            System.out.println("ID: " + plan.getId() + ", Plan Name: " + plan.getPlanName() + ", Price: " + plan.getPlanPrice());
        }

        // Retrieving and displaying Payments
        List<Payment> payments = session.createQuery("from Payment", Payment.class).list();
        System.out.println("\nPayments:");
        for (Payment payment : payments) {
            System.out.println("Member: " + payment.getMember().getName() + ", Amount Paid: " + payment.getAmountPaid() + ", Payment Date: " + payment.getPaymentDate());
        }

        session.close();
    }
}
