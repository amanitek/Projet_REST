package com.example.restproject.Service;

import com.example.restproject.Entity.AdministrativeStaff;
import com.example.restproject.Entity.Student;
import com.example.restproject.Repository.StaffManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImp implements StaffService{
  @Autowired
  StaffManagementRepository staffRepository;
  @Override
  public void addStaff(AdministrativeStaff Staff) {
      staffRepository.save(Staff) ;
  }

  @Override
  public List<AdministrativeStaff> getAllStaff() {
    return staffRepository.findAll();
  }

  @Override
  public List<AdministrativeStaff> getStaffByDepartment(String department) {
    return staffRepository.findByDepartment(department);
  }

  @Override
  public AdministrativeStaff getStaffById(long id) {
    Optional<AdministrativeStaff> optionalStaff = staffRepository.findById(id);
    return optionalStaff.orElse(null);  }

  @Override
  public void updateStaff(AdministrativeStaff staff) {
    Optional<AdministrativeStaff> optionalExistingStaff = staffRepository.findById(staff.getId());
    if (optionalExistingStaff.isPresent()) {
      staffRepository.save(staff);
    } else {
      throw new RuntimeException("Student with ID " + staff.getId() + " not found");
    }
  }

  @Override
  public void deleteStaff(long id) {
    Optional<AdministrativeStaff> optionalExistingStaff = staffRepository.findById(id);
    if (optionalExistingStaff.isPresent()) {
      staffRepository.deleteById(id);
    } else {
      throw new RuntimeException("Student with ID " + id + " not found");
    }
  }
}
