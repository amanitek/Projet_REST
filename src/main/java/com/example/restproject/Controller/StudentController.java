package com.example.restproject.Controller;

import com.example.restproject.Entity.Student;
import com.example.restproject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
  @Autowired
  private StudentService studentService;

  @PostMapping("/addStudent")
  public ResponseEntity<String> addStudent(@RequestBody Student student) {
    studentService.addStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully");
  }

  @GetMapping("/{studentId}")
  public ResponseEntity<Object> getStudentById(@PathVariable long studentId) {
    Student student = studentService.getStudentById(studentId);
    if (student != null) {
      return ResponseEntity.status(HttpStatus.OK).body(student);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
  }


  @PutMapping("/{studentId}")
  public ResponseEntity<String> updateStudent(@PathVariable long studentId, @RequestBody Student student) {
    student.setId(studentId);
    try {
      studentService.updateStudent(student);
      return ResponseEntity.status(HttpStatus.OK).body("Student updated successfully");
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
  }

  @DeleteMapping("/{studentId}")
  public ResponseEntity<String> deleteStudent(@PathVariable long studentId) {
    try {
      studentService.deleteStudent(studentId);
      return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
  }

  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> students = studentService.getAllStudents();
    return ResponseEntity.status(HttpStatus.OK).body(students);
  }
}
