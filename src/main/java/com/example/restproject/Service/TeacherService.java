package com.example.restproject.Service;

import com.example.restproject.Entity.Teacher;

import java.util.List;

public interface TeacherService {
  void addTeacher(Teacher teacher, Long administrativeStaffId);
  Teacher getTeacherById(long teacherId);
  void deleteTeacher (long teacherId);
  List<Teacher> getAllTeachers();

  void updateTeacher(Teacher teacher, Long administrativeStaffId);
}
