package com.example.restproject.Service;

import com.example.restproject.Entity.Student;
import com.example.restproject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{
  @Autowired
  StudentRepository studentRepository;

  @Override
  public void addStudent(Student student) {
    studentRepository.save(student);

  }

  @Override
  public Student getStudentById(long studentId) {
    Optional<Student> optionalStudent = studentRepository.findById(studentId);
    return optionalStudent.orElse(null);  }

  @Override
  public void updateStudent(Student student) {
    Optional<Student> optionalExistingStudent = studentRepository.findById(student.getId());
    if (optionalExistingStudent.isPresent()) {
      studentRepository.save(student);
    } else {
      throw new RuntimeException("Student with ID " + student.getId() + " not found");
    }
  }

  @Override
  public void deleteStudent(long studentId) {
    Optional<Student> optionalExistingStudent = studentRepository.findById(studentId);
    if (optionalExistingStudent.isPresent()) {
      studentRepository.deleteById(studentId);
    } else {
      throw new RuntimeException("Student with ID " + studentId + " not found");
    }
  }
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }
}
