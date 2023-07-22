package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
