package com.zumba.model;

import java.sql.Timestamp;

public class Participant {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int batchId;
    private Timestamp enrollmentDate;

    public Participant(int id, String name, String email, String phone, int batchId, Timestamp enrollmentDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.batchId = batchId;
        this.enrollmentDate = enrollmentDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getBatchId() { return batchId; }
    public void setBatchId(int batchId) { this.batchId = batchId; }

    public Timestamp getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(Timestamp enrollmentDate) { this.enrollmentDate = enrollmentDate; }
}
