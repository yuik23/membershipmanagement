package com.raisetech.membershipmanagement.entity;

import java.time.LocalDate;

public class Member {
    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate enrollmentDate;
    private String schoolName;
    private int grade;

    public Member(int id, String name, LocalDate birthDate, LocalDate enrollmentDate, String schoolName, int grade) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.enrollmentDate = enrollmentDate;
        this.schoolName = schoolName;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public int getGrade() {
        return grade;
    }
}
