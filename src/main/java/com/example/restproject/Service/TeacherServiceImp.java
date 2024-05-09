package com.example.restproject.Service;

import com.example.restproject.Entity.AdministrativeStaff;
import com.example.restproject.Entity.Teacher;
import com.example.restproject.Repository.StaffManagementRepository;
import com.example.restproject.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService{
  @Autowired
  TeacherRepository teacherRepository;
  @Autowired
  StaffManagementRepository staffRepository;
  @Override
  public void addTeacher(Teacher teacher, Long administrativeStaffId) {
    AdministrativeStaff staff = staffRepository.findById(administrativeStaffId)
      .orElseThrow(() -> new RuntimeException("Administrative staff with ID " + administrativeStaffId + " not found"));

    teacher.setAdministrativeStaff(staff);
    teacherRepository.save(teacher);
  }


  @Override
  public Teacher getTeacherById(long teacherId) {
    Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
    return optionalTeacher.orElse(null);
  }

  @Override
  public void updateTeacher(Teacher teacher, Long administrativeStaffId) {
    Optional<Teacher> optionalExistingTeacher = teacherRepository.findById(teacher.getId());

    // Check if the teacher exists
    if (optionalExistingTeacher.isPresent()) {
      AdministrativeStaff staff = staffRepository.findById(administrativeStaffId)
        .orElseThrow(() -> new RuntimeException("Administrative staff with ID " + administrativeStaffId + " not found"));

      teacher.setAdministrativeStaff(staff);

      teacherRepository.save(teacher);
    } else {
      throw new RuntimeException("Teacher with ID " + teacher.getId() + " not found");
    }}
@Override
  public void deleteTeacher(long teacherId) {
    Optional<Teacher> optionalExistingTeacher = teacherRepository.findById(teacherId);
    if (optionalExistingTeacher.isPresent()) {
      Teacher teacher = optionalExistingTeacher.get();
      AdministrativeStaff staff = teacher.getAdministrativeStaff();
      if (staff != null) {
        staff.getTeachers().remove(teacher);
      }
      teacherRepository.deleteById(teacherId);
    } else {
      throw new RuntimeException("Teacher with ID " + teacherId + " not found");
    }
  }


  @Override
  public List<Teacher> getAllTeachers() {
    return teacherRepository.findAll();
  }
}
