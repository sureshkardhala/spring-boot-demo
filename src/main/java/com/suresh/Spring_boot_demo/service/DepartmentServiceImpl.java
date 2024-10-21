package com.suresh.Spring_boot_demo.service;

import com.suresh.Spring_boot_demo.entity.Department;
import com.suresh.Spring_boot_demo.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department departmentDBO = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(departmentDBO.getDepartmentAddress())
                && !"".equalsIgnoreCase(departmentDBO.getDepartmentAddress())){
            departmentDBO.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(departmentDBO.getDepartmentCode())
                && !"".equalsIgnoreCase(departmentDBO.getDepartmentCode())){
            departmentDBO.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(departmentDBO.getDepartmentName())
                && !"".equalsIgnoreCase(departmentDBO.getDepartmentName())){
            departmentDBO.setDepartmentName(department.getDepartmentName());
        }

        return departmentRepository.save(departmentDBO);
    }

    @Override
    public Department saveDepartment(Department department){
        Department dbto = new Department();
        dbto.setDepartmentName(department.getDepartmentName());
        dbto.setDepartmentCode(department.getDepartmentCode());
        dbto.setDepartmentAddress(department.getDepartmentAddress());
        return departmentRepository.save(dbto);
    }

    @Override
    public void deleteDepartments() {
        departmentRepository.deleteAll();
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public List<Department> getDepartmentByCode(String departmentCode) {
        return departmentRepository.findByDepartmentCode(departmentCode);
    }
}
