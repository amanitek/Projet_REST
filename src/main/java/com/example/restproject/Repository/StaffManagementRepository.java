package com.example.restproject.Repository;

import com.example.restproject.Entity.AdministrativeStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffManagementRepository extends JpaRepository<AdministrativeStaff,Long> {
  List<AdministrativeStaff> findByDepartment(String department);

}
