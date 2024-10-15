package com.gym;

import com.gym.entity.*;
import com.gym.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class StoreMain {
    public static void main(String[] args) {
        storeData();
    }

    public static void storeData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Storing Membership Plans
        MembershipPlan plan1 = new MembershipPlan("Basic", 1000, 3);
        MembershipPlan plan2 = new MembershipPlan("Premium", 3000, 6);
        session.persist(plan1);
        session.persist(plan2);

        // Storing Members
        Member member1 = new Member("Abhi", "abhi@example.com", "1234567890", plan1);
        Member member2 = new Member("Aadi", "aadi@example.com", "0987654321", plan2);
        session.persist(member1);
        session.persist(member2);

        // Storing Trainers
        Trainer trainer1 = new Trainer("Jaysingh", "Jay@example.com", "1112223333", "Strength Training");
        Trainer trainer2 = new Trainer("Salman khan", "salman@example.com", "4445556666", "Yoga");
        session.persist(trainer1);
        session.persist(trainer2);

        // Storing Payments
        Payment payment1 = new Payment(member1, 1000, LocalDate.now());
        Payment payment2 = new Payment(member2, 3000, LocalDate.now());
        session.persist(payment1);
        session.persist(payment2);

        transaction.commit();
        session.close();

        System.out.println("Data has been successfully stored.");
    }
}
