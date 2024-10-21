package com.suresh.Spring_boot_demo.service;
import com.suresh.Spring_boot_demo.entity.Department;

import java.util.*;

public interface DepartmentService {
    public List<Department> getDepartments();
    public Optional<Department> getDepartmentById(Long departmentId);
    public void deleteDepartmentById(Long departmentId);
    public Department updateDepartmentById(Long departmentId, Department department);
    public Department saveDepartment(Department department);
    public void deleteDepartments();
    public Department getDepartmentByName(String departmentName);
    public List<Department> getDepartmentByCode(String departmentCode);
}
