package com.example.c0778584_w2020_mad3125_midterm.model;

import java.util.Date;

public class Customer {
    private String sinNumber;
    private String firstName;
    private String  lastName;
    private String fullName;
    private  String gender;
    private Date dateOfBirth;
    private Date filingTaxDate;
    private double fedTax;
    private double provTax;
    private  double grossIncome;
    private double rrspCarryForward;
    private double rrspContribution;
    private double totalEI;
    private double totalTaxableAmount;
    private double totalTaxPaid;

    public Customer(String sinNumber, String firstName, String lastName, String gender, double grossIncome, double rrspContribution) {
        this.sinNumber = sinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.grossIncome = grossIncome;
        this.rrspContribution = rrspContribution;
    }
}
