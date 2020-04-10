package com.example.c0778584_w2020_mad3125_midterm.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Customer implements Parcelable{
    private String sinNumber;
    private String firstName;
    private String  lastName;
    private String fullName;
    private  String gender;
    private Date dateOfBirth;
    private String filingTaxDate;
    private double fedTax;
    private double provTax;
    private  double grossIncome;
    private double rrspCarryForward;
    private double rrspContribution;
    private double totalEI;
    private double totalTaxableAmount;
    private double totalTaxPaid;

    public Customer(String sinNumber, String firstName, String lastName, String gender, String filingTaxDate, double grossIncome, double rrspContribution) {
        this.sinNumber = sinNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.filingTaxDate = filingTaxDate;
        this.grossIncome = grossIncome;
        this.rrspContribution = rrspContribution;
    }
    public String getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(String sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFull_name() {
        return lastName.toUpperCase()+","+firstName;
    }

    public void setFull_name(String full_name) {
        this.fullName = full_name;
    }

    public String getPersonGender() {
        return gender;
    }

    public void setPersonGender(String personGender) {
        this.gender = personGender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFilingTaxDate() {
        return filingTaxDate;
    }

    public void setFilingTaxDate(String filingTaxDate) {
        this.filingTaxDate = filingTaxDate;
    }

    public double getFedTax() {
        return fedTax;
    }

    public void setFedTax(double fedTax) {
        this.fedTax = fedTax;
    }

    public double getProvTax() {
        return provTax;
    }

    public void setProvTax(double provTax) {
        this.provTax = provTax;
    }

    public double getRrspCarryForward() {
        return rrspCarryForward;
    }

    public void setRrspCarryForward(double rrspCarryForward) {
        this.rrspCarryForward = rrspCarryForward;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public double getRrspContribution() {
        return rrspContribution;
    }

    public void setRrspContribution(double rrspContribution) {
        this.rrspContribution = rrspContribution;
    }

    public double getTotalEI() {
        return totalEI;
    }

    public void setTotalEI(double totalEI) {
        this.totalEI = totalEI;
    }

    public double getTotalTaxableAmount() {
        return totalTaxableAmount;
    }

    public void setTotalTaxableAmount(double totalTaxableAmount) {
        this.totalTaxableAmount = totalTaxableAmount;
    }

    public double getTotalTaxPaid() {
        return totalTaxPaid;
    }

    public void setTotalTaxPaid(double totalTaxPaid) {
        this.totalTaxPaid = totalTaxPaid;
    }

    protected Customer(Parcel parcel) {
        sinNumber = parcel.readString();
        firstName = parcel.readString();
        lastName = parcel.readString();
        gender = parcel.readString();
        provTax = parcel.readDouble();
        fedTax = parcel.readDouble();
        rrspCarryForward = parcel.readDouble();
        grossIncome = parcel.readDouble();
        rrspContribution = parcel.readDouble();
        totalEI = parcel.readDouble();
        totalTaxableAmount = parcel.readDouble();
        totalTaxPaid = parcel.readDouble();

    }
    public static final Parcelable.Creator<Customer> CREATOR = new Parcelable.Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel parcel) {
            return new Customer(parcel);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sinNumber);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(gender);
        dest.writeDouble(fedTax);
        dest.writeDouble(provTax);
        dest.writeDouble(rrspCarryForward);
        dest.writeDouble(grossIncome);
        dest.writeDouble(rrspContribution);
        dest.writeDouble(totalEI);
        dest.writeDouble(totalTaxableAmount);
        dest.writeDouble(totalTaxPaid);
    }

}
