package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    private String emailId;

    private String emailPassword;

    private String name;

    private int age;

    private long contact;

    private double salary;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dobDate;

}
