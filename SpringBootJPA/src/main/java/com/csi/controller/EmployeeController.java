package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //signup
    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee){
        log.info("######################################## sign up for employee");
        return ResponseEntity.ok(employeeService.signUp(employee));
    }

    //signin
    @GetMapping("/signin/{emailId}/{emailPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String emailId, @PathVariable String emailPassword){
        log.info("################################################ sign in for employee");
        return ResponseEntity.ok(employeeService.signIn(emailId, emailPassword));
    }

    //getdatabyid
    @GetMapping("/getdatabyid/{id}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int id){
        log.info("################################################# get data by employee ID");
        return ResponseEntity.ok(employeeService.getDataById(id));
    }


    //getdatabyname
    @GetMapping("/getdatabyname/{name}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String name){
        log.info("############################################## get data by name");
        return ResponseEntity.ok(employeeService.getDataByName(name));
    }

    //getdatabyemail
    @GetMapping("/getdatabyemailid/{emailId}")
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String emailId){
        log.info("######################################### get data by email");
        return ResponseEntity.ok(employeeService.getDataByEmailId(emailId));
    }

    //getdatabycontact
    @GetMapping("/getdatabycontact/{contact}")
    public ResponseEntity<Employee> getDataByContact(@PathVariable long contact){
        log.info("############################################ get data by contact");
        return ResponseEntity.ok(employeeService.getDataByContact(contact));
    }

    //getdatausinganyinput
    @GetMapping("/getdatabyanyinput/{input}")
    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String input){
        log.info("############################################ get data by any input");
        return ResponseEntity.ok(employeeService.getDataByUsingAnyInput(input));
    }

    //getalldata
    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        log.info("################################################ get all data");
        return ResponseEntity.ok(employeeService.getAllData());
    }

    //sortbyname
    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
        log.info("##################################################### sort by emp name");
        return ResponseEntity.ok(employeeService.sortByName());
    }

    //sortbyid
    @GetMapping("/sortbyid")
    public ResponseEntity<List<Employee>> sortById(){
        log.info("##################################################### sort by emp ID");
        return ResponseEntity.ok(employeeService.sortById());
    }

    //sortbysalary
    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortBySalary(){
        log.info("##################################################### sort by emp salary");
        return ResponseEntity.ok(employeeService.sortBySalary());
    }

    //sortbyage
    @GetMapping("/sortbyage")
    public ResponseEntity<List<Employee>> sortByAge(){
        log.info("##################################################### sort by emp AGE");
        return ResponseEntity.ok(employeeService.sortByAge());
    }

    //sortbydob
    @GetMapping("/sortbydob")
    public ResponseEntity<List<Employee>> sortByDOB(){
        log.info("##################################################### sort by emp DOB");
        return ResponseEntity.ok(employeeService.sortByDob());
    }

    //filterdatabysalary
    @GetMapping("/filterdatabysalary/{salary}")
    public ResponseEntity<List<Employee>> filterDataBySalary(@PathVariable double salary){
        log.info("##################################################### sort by emp salary");
        return ResponseEntity.ok(employeeService.filterDataBySalary(salary));
    }

    //loanelegibility
    @GetMapping("/loanelegibility/{id}")
    public ResponseEntity<String> isEligibleForLoan(@PathVariable int id){

        log.info("########################################## checking loan eligibility");
        String msg = null;
        if(employeeService.isEligibleForLoan(id)){
            msg = "YES! ELIGIBLE";
        } else {
            msg = "NOT ELIGIBLE";
        }
        return ResponseEntity.ok(msg);
    }

    //updatedata
    @PutMapping("/updatedatabyid/{id}")
    public ResponseEntity<Employee> updateDataById(@PathVariable int id, @RequestBody Employee employee){
        log.info("########################################## update emp data by ID");
        Employee employee1 = employeeService.getDataById(id).orElseThrow(() -> new RecordNotFoundException("RECORD NOT FOUND!!!"));

        employee1.setSalary(employee.getSalary());
        employee1.setName(employee.getName());
        employee1.setEmailPassword(employee.getEmailPassword());
        employee1.setDobDate(employee.getDobDate());
        employee1.setAge(employee.getAge());
        employee1.setSalary(employee.getSalary());
        employee1.setEmailId(employee.getEmailId());

        return ResponseEntity.ok(employeeService.updateData(employee1));
    }

    //deletebyid
    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        log.info("################################################ data deleted by emp ID");
        employeeService.deleteById(id);
        return ResponseEntity.ok("DATA DELETED");
    }

    //deletealldata
    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData(){
        log.info("################################################ deleted all data");
        employeeService.deleteAllData();
        return ResponseEntity.ok("DATA DELETED");
    }
}
