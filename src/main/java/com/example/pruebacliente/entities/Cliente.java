package com.example.pruebacliente.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
public class Cliente {

    @Id
    private Long id;
    private String fullName;
    private String mail;
    private LocalDate birthDay;

    @Transient
    private int age;

    public Cliente() {
    }

    public Cliente(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public Cliente(Long id, String fullName, String mail, LocalDate birthDay) {
        this.id = id;
        this.fullName = fullName;
        this.mail = mail;
        this.birthDay = birthDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int getAge() {
        return age;
    }

    public int calculateAge() {
        if (this.birthDay != null) {
            Period period = Period.between(this.birthDay,LocalDate.now());
            this.age = period.getYears();
        }
        return age;
    }
}
