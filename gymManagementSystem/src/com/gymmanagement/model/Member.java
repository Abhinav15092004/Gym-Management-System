package com.gymmanagement.model;

import java.sql.Date;

public class Member {
    private int id;
    private String name;
    private Date membershipDate;
    private String goal;

    public Member() {
    }

    public Member(int id, String name, Date membershipDate, String goal) {
        this.id = id;
        this.name = name;
        this.membershipDate = membershipDate;
        this.goal = goal;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Date getMembershipDate() { return membershipDate; }
    public void setMembershipDate(Date membershipDate) { this.membershipDate = membershipDate; }
    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Membership Date: " + membershipDate;
    }
}
