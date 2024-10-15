package com.gym.entity;

import jakarta.persistence.*;

@Entity
public class MembershipPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String planName;
    private double planPrice;
    private int durationInMonths;

    public MembershipPlan() {}

    public MembershipPlan(String planName, double planPrice, int durationInMonths) {
        this.planName = planName;
        this.planPrice = planPrice;
        this.durationInMonths = durationInMonths;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(double planPrice) {
        this.planPrice = planPrice;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }
}
