package com.example.restproject.Service;

import com.example.restproject.Entity.AdministrativeStaff;

import java.util.List;

public interface StaffService {
  void addStaff(AdministrativeStaff Staff);
  List<AdministrativeStaff> getAllStaff();

  List<AdministrativeStaff> getStaffByDepartment(String department);

  AdministrativeStaff getStaffById(long id);

  void updateStaff(AdministrativeStaff staff);
  void deleteStaff(long id);
}
