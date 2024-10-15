package com.gym.entity;

import jakarta.persistence.*;

@Entity
public class Member extends Person {
    @ManyToOne
    @JoinColumn(name = "membership_plan_id")
    private MembershipPlan membershipPlan;

    public Member() {}

    public Member(String name, String email, String phoneNumber, MembershipPlan membershipPlan) {
        super(name, email, phoneNumber);
        this.membershipPlan = membershipPlan;
    }

    // Getters and Setters
    public MembershipPlan getMembershipPlan() {
        return membershipPlan;
    }

    public void setMembershipPlan(MembershipPlan membershipPlan) {
        this.membershipPlan = membershipPlan;
    }
}
