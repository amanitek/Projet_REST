package com.example.restproject.Controller;

import com.example.restproject.Entity.Teacher;
import com.example.restproject.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
  @Autowired
  private TeacherService teacherService;

  @PostMapping("/addTeacher")
  public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher, @RequestParam Long administrativeStaffId) {
    teacherService.addTeacher(teacher, administrativeStaffId);
    return ResponseEntity.status(HttpStatus.CREATED).body("Teacher added successfully");
  }

  @GetMapping("/{teacherId}")
  public ResponseEntity<Object> getTeacherById(@PathVariable long teacherId) {
    Teacher teacher = teacherService.getTeacherById(teacherId);
    if (teacher != null) {
      return ResponseEntity.status(HttpStatus.OK).body(teacher);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found");
    }
  }

  @PutMapping("/{teacherId}")
  public ResponseEntity<String> updateTeacher(@PathVariable long teacherId, @RequestParam Long administrativeStaffId, @RequestBody Teacher teacher) {
    teacher.setId(teacherId);
    try {
      teacherService.updateTeacher(teacher, administrativeStaffId);
      return ResponseEntity.status(HttpStatus.OK).body("Teacher updated successfully");
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found");
    }
  }

  @DeleteMapping("/{teacherId}")
  public ResponseEntity<String> deleteTeacher(@PathVariable long teacherId) {
    try {
      teacherService.deleteTeacher(teacherId);
      return ResponseEntity.status(HttpStatus.OK).body("Teacher deleted successfully");
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found");
    }
  }

  @GetMapping
  public ResponseEntity<List<Teacher>> getAllTeachers() {
    List<Teacher> teachers = teacherService.getAllTeachers();
    return ResponseEntity.status(HttpStatus.OK).body(teachers);
  }
}
