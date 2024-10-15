package com.gym;

import com.gym.entity.Member;
import com.gym.entity.Trainer;
import com.gym.entity.MembershipPlan;
import com.gym.entity.Payment;
import com.gym.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class RetrieveMain {
    public static void main(String[] args) {
        retrieveData();
    }

    public static void retrieveData() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Retrieving Members
        List<Member> members = session.createQuery("from Member", Member.class).list();

        // Retrieving Trainers
        List<Trainer> trainers = session.createQuery("from Trainer", Trainer.class).list();

        // Retrieving Membership Plans
        List<MembershipPlan> membershipPlans = session.createQuery("from MembershipPlan", MembershipPlan.class).list();

        // Retrieving Payments
        List<Payment> payments = session.createQuery("from Payment", Payment.class).list();

        session.close();

        System.out.println("Data has been successfully retrieved.");
    }
}
