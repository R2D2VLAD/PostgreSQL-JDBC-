package com.example.jdbc.model;

import java.util.Objects;

public class Emploee {
    private String firstname;
    private String lastname;
    private String gender;
    private int age;
    private City cityId;

    public Emploee() {

    }

    public Emploee(String firstname, String lastname, String gender, int age, City city_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.cityId = city_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emploee)) return false;
        Emploee emploee = (Emploee) o;
        return age == emploee.age && firstname.equals(emploee.firstname) && lastname.equals(emploee.lastname) && gender.equals(emploee.gender) && cityId.equals(emploee.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, gender, age, cityId);
    }

    @Override
    public String toString() {
        return "Emploee {" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", cityId=" + cityId +
                '}';
    }
}
