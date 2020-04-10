package com.example.c0778584_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.c0778584_w2020_mad3125_midterm.model.Customer;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    Customer customer;
    private TextView lblSin;
    private TextView lblFullName;
    private TextView lblBirthDate;
    private TextView lblAge;
    private TextView lblGender;
    private TextView lblTaxFilingDate;
    private TextView lblGrossIncome;
    private TextView lblRRSPContributed;
    private TextView lblRRSPCarryFwd;
    private TextView lblFederalTax;
    private TextView lblProvincialTax;
    private TextView lblEI;
    private TextView lblCpp;
    private TextView lblTaxableIncome;
    private TextView lblTaxPayed;

    double cpp = 0;
    double ei = 0;
    double rrsp = 0;
    double rrspContribution = 0;
    double rrspCarryFwd = 0;
    double taxableIncome;
    double federalTax;
    double provincialTax;
    double totalTaxPaid;

    final Calendar calendar = Calendar.getInstance();
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int month = calendar.get(Calendar.MONTH);
    final int year = calendar.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lblSin = findViewById(R.id.txtSin);
        lblFullName = findViewById(R.id.textFullName);
        lblAge = findViewById(R.id.textAge);
        lblGender = findViewById(R.id.textGender);
        lblTaxFilingDate = findViewById(R.id.txtTaxFilling);
        lblGrossIncome = findViewById(R.id.textGrossIncome);
        lblRRSPContributed = findViewById(R.id.textViewRRSPContributed);
        lblRRSPCarryFwd = findViewById(R.id.textViewCarryForward);
        lblFederalTax = findViewById(R.id.textFederalTax);
        lblProvincialTax = findViewById(R.id.textProvincialTax);
        lblEI = findViewById(R.id.textEI);
        lblCpp = findViewById(R.id.textCPP);
        lblTaxableIncome = findViewById(R.id.textTaxableIncome);
        lblTaxPayed = findViewById(R.id.textTotalTaxedPayed);


        Intent mIntent = getIntent();
        Customer customer = mIntent.getParcelableExtra("Customer");

        lblSin.setText(customer.getSinNumber());
//
    }
}
