package com.gymmanagement.model;

public class Trainer {
    private int id;
    private String name;
    private String specialty;

    public Trainer(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Specialty: " + specialty;
    }
}
