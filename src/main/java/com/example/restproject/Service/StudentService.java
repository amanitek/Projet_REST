package com.example.restproject.Service;

import com.example.restproject.Entity.Student;

import java.util.List;

public interface StudentService {
  void addStudent (Student student);
  Student getStudentById(long studentId);
  void updateStudent(Student student);
  void deleteStudent (long studentId);
  List<Student> getAllStudents();
}
