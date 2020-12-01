package com.codersait;

public class Person {
    private String firstName;
    private String lastName;
    private int personID;
    private String city;
    private String address;

    public Person(String firstName, String lastName, int personID, String city, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personID = personID;
        this.city = city;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPersonID() {
        return personID;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
