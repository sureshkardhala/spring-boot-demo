package com.suresh.Spring_boot_demo.controller;

import com.suresh.Spring_boot_demo.entity.Department;
import com.suresh.Spring_boot_demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/department/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("/updatedepartment/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @PostMapping("/savedepartment")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/deletedepartments")
    public String deleteDepartments(){
        departmentService.deleteDepartments();
        return "Departments deleted successfully!";
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }

    @GetMapping("/departments/code/{code}")
    public List<Department> getDepartmentByCode(@PathVariable("code") String departmentCode){
        return departmentService.getDepartmentByCode(departmentCode);
    }
}
