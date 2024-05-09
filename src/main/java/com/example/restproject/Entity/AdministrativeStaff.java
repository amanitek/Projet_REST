package com.example.restproject.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class AdministrativeStaff {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String department;

  @OneToMany(mappedBy = "administrativeStaff")
  @JsonManagedReference
  private List<Teacher> teachers;



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public List<Teacher> getTeachers() {
    return teachers;
  }

  public void setTeachers(List<Teacher> teachers) {
    this.teachers = teachers;
  }
}
