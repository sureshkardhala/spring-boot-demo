package com.suresh.Spring_boot_demo.respository;

import com.suresh.Spring_boot_demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentName(String departmentName);
    public List<Department> findByDepartmentCode(String departmentCode);
}
