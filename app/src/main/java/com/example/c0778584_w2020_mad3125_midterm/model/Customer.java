package com.example.c0778584_w2020_mad3125_midterm.model;

import java.util.Date;

public class Customer {
    private String firstName;
    private String  lastName;
    private String fullName;
    private  String gender;
    private  String personGender;
    private Date dateOfBirth;
    private Date filingTaxDate;
    private double fedTax, provTax;
    private double rrspCarryForward;
    private double totalEI;
    private double totalTaxableAmount;
    private double totalTaxPaid;

    public Customer(String firstName, String lastName, String fullName, String gender, String personGender, Date dateOfBirth, Date filingTaxDate, double fedTax, double provTax, double rrspCarryForward, double totalEI, double totalTaxableAmount, double totalTaxPaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.gender = gender;
        this.personGender = personGender;
        this.dateOfBirth = dateOfBirth;
        this.filingTaxDate = filingTaxDate;
        this.fedTax = fedTax;
        this.provTax = provTax;
        this.rrspCarryForward = rrspCarryForward;
        this.totalEI = totalEI;
        this.totalTaxableAmount = totalTaxableAmount;
        this.totalTaxPaid = totalTaxPaid;
    }
}
