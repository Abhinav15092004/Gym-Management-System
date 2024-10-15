package com.gym.entity;

import jakarta.persistence.*;

@Entity
public class Trainer extends Person {
    private String specialty;

    public Trainer() {}

    public Trainer(String name, String email, String phoneNumber, String specialty) {
        super(name, email, phoneNumber);
        this.specialty = specialty;
    }

    // Getters and Setters
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
