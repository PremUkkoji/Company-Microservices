package com.premukkoji.department.repository;

import com.premukkoji.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    Department findByDepartmentId(final Long departmentId);

}
