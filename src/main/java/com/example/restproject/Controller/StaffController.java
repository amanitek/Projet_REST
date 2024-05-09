package com.example.restproject.Controller;

import com.example.restproject.Entity.AdministrativeStaff;
import com.example.restproject.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

  @Autowired
  private StaffService staffService;

  @PostMapping("/add")
  public ResponseEntity<String> addStaff(@RequestBody AdministrativeStaff staff) {
    staffService.addStaff(staff);
    return ResponseEntity.status(HttpStatus.CREATED).body("Administrative Staff added successfully");
  }

  @GetMapping("/all")
  public ResponseEntity<List<AdministrativeStaff>> getAllStaff() {
    List<AdministrativeStaff> staffList = staffService.getAllStaff();
    return new ResponseEntity<>(staffList, HttpStatus.OK);
  }

  @GetMapping("/department/{department}")
  public ResponseEntity<List<AdministrativeStaff>> getStaffByDepartment(@PathVariable String department) {
    List<AdministrativeStaff> staffList = staffService.getStaffByDepartment(department);
    return new ResponseEntity<>(staffList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AdministrativeStaff> getStaffById(@PathVariable long id) {
    AdministrativeStaff staff = staffService.getStaffById(id);
    if (staff != null) {
      return new ResponseEntity<>(staff, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateStaff(@PathVariable long id, @RequestBody AdministrativeStaff staff) {
    staff.setId(id);
    try {
      staffService.updateStaff(staff);
      return ResponseEntity.status(HttpStatus.OK).body("Staff updated successfully");
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Staff not found");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteStaff(@PathVariable long id) {
    try {
      staffService.deleteStaff(id);
      return ResponseEntity.status(HttpStatus.OK).body("Student deleted successfully");
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
    }
  }
}


