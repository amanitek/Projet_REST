package com.example.restproject.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String subject;

  @ManyToOne
  @JoinColumn(name = "administrative_staff_id")
  @JsonBackReference
  private AdministrativeStaff administrativeStaff;

  public Teacher() {
  }

  public Teacher(String name, String subject) {
    this.name = name;
    this.subject = subject;
  }

  // Getters and Setters
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public AdministrativeStaff getAdministrativeStaff() {
    return administrativeStaff;
  }

  public void setAdministrativeStaff(AdministrativeStaff administrativeStaff) {
    this.administrativeStaff = administrativeStaff;
  }
}
