package com.csi.service;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //signup
    public Employee signUp(Employee employee){
        return employeeRepository.save(employee);
    }

    //signin
    public boolean signIn(String emailId, String emailPassword){

        boolean flag = false;
        for(Employee employee : employeeRepository.findAll()){

            if(employee.getEmailId().equals(emailId) && employee.getEmailPassword().equals(emailPassword)){

                flag = true;
            }
        }
        return flag;
    }

    //getdatabyid
    public Optional<Employee> getDataById(int id){
        return employeeRepository.findById(id);
    }

    //getdatabyname
    public List<Employee> getDataByName(String name){
        return employeeRepository.findByName(name);
    }

    //getdatabyemail
    public Employee getDataByEmailId(String emailId){
        return employeeRepository.findByEmailId(emailId);
    }

    //getdatabycontact
    public Employee getDataByContact(long contact){
        return employeeRepository.findByContact(contact);
    }

    //getdatausinganyinput
    public List<Employee> getDataByUsingAnyInput(String input){

        List<Employee> employeeList = new ArrayList<>();

        for(Employee employee : employeeRepository.findAll()){

            if(String.valueOf(employee.getSalary()).equals(input)
            || employee.getDobDate().equals(input)
            || employee.getName().equals(input)
            || String.valueOf(employee.getContact()).equals(input)
            || String.valueOf(employee.getAge()).equals(input)
            || employee.getEmailId().equals(input)
            || employee.getEmailPassword().equals(input)
            || String.valueOf(employee.getId()).equals(input)) {

                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    //getalldata
    public List<Employee> getAllData(){
        return employeeRepository.findAll();
    }

    //sortbyname
    public List<Employee> sortByName(){
        return employeeRepository.findAll().stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName())).toList();
    }

    //sortbyid
    public List<Employee> sortById(){
        return employeeRepository.findAll().stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).toList();
    }

    //sortbysalary
    public List<Employee> sortBySalary(){
        return employeeRepository.findAll().stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
    }

    //sortbyage
    public List<Employee> sortByAge(){
        return employeeRepository.findAll().stream().sorted(Comparator.comparingInt(Employee::getAge)).toList();
    }

    //sortbydob
    public List<Employee> sortByDob(){
        return employeeRepository.findAll().stream().sorted((e1, e2) -> e1.getDobDate().compareTo(e2.getDobDate())).toList();
    }

    //filterdatabysalary
    public List<Employee> filterDataBySalary(double salary){
        return employeeRepository.findAll().stream().filter(emp -> emp.getSalary() > 50000).toList();
    }

    //loanelegibility
    public boolean isEligibleForLoan(int id){

        boolean flag = false;
        for (Employee employee : employeeRepository.findAll()){

            if(employee.getId() == id && employee.getSalary() > 50000){

                flag = true;
            }
        }
        return flag;
    }

    //updatedata
    public Employee updateData(Employee employee){
        return employeeRepository.save(employee);
    }

    //deletebyid
    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }

    //deletealldata
    public void deleteAllData(){
        employeeRepository.deleteAll();
    }
}
