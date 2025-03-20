package com.csi.repository;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //findbyname
    public List<Employee> findByName(String name);

    //findbyemail
    public Employee findByEmailId(String emailId);

    //findbycontact
    public Employee findByContact(long contact);
}
