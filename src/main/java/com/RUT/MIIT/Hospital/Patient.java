package com.RUT.MIIT.Hospital;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
public class Patient {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long selfCode;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;


    @NotEmpty(message = "Blood type should not be empty")
    private String bloodType;

    @Min(value = 2,message = "Weight should be greater than 2")
    private int weight;

    @Min(value = 30,message = "Height should be greater than 30")
    private int height;

    @Min(value = 0,message = "Room number should be greater than 0")
    private int roomNumber = 0;

    @Min(value = 1,message = "Age should be greater than 0")
    private  int age;


    @Min(value = 1,message = "Age should be greater than 0")
    private  int yearOfBirth;





    public Patient(String name,int age, String bloodType, int weight, int height, int roomNumber,int yearOfBirth) {
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
        this.weight = weight;
        this.height = height;
        this.roomNumber = roomNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public Patient(){

    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Long getSelfCode() {
        return selfCode;
    }

    public void setSelfCode(Long selfCode) {
        this.selfCode = selfCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
