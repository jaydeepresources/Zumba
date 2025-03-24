package com.zumba.dto;

import java.util.Date;

public class ParticipantDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private Date enrollmentDate;
    private int batchId;
    private String batchName;

    public ParticipantDTO(int id, String name, String email, String phone, Date enrollmentDate, int batchId, String batchName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.enrollmentDate = enrollmentDate;
        this.batchId = batchId;
        this.batchName = batchName;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Date getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(Date enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public int getBatchId() { return batchId; }
    public void setBatchId(int batchId) { this.batchId = batchId; }

    public String getBatchName() { return batchName; }
    public void setBatchName(String batchName) { this.batchName = batchName; }
}
