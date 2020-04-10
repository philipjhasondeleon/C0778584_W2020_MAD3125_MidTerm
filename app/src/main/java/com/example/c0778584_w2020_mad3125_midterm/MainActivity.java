package com.example.c0778584_w2020_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c0778584_w2020_mad3125_midterm.model.Customer;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btnCalculate;
    private EditText edttxtFirstName;
    private EditText edttxtLastName;
    private EditText edttxtSinNumber;
    private EditText edttxtBirthDate;
    private TextView  edttxtTaxFiledDate;
    private EditText  edttxtGrossIncome;
    private EditText  edttxtRRSP;
    private RadioButton rdbtnMale;
    private RadioButton rdbtnFemale;
    private RadioButton rdbtnOther;
    private RadioGroup rdgrpGender;

    private DatePickerDialog picker;
    final Calendar calendar = Calendar.getInstance();
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final   int month = calendar.get(Calendar.MONTH);
    final int year = calendar.get(Calendar.YEAR);
    String gender=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edttxtFirstName = findViewById(R.id.editTextFirstName);
        edttxtLastName = findViewById(R.id.editTextLastName);
        edttxtSinNumber = findViewById(R.id.editTextSIN);
        rdgrpGender = findViewById(R.id.radioGrpGender);
        rdbtnMale = findViewById(R.id.radioButtonMale);
        rdbtnFemale = findViewById(R.id.radioButtonFemale);
        rdbtnOther = findViewById(R.id.radioButtonOther);
        edttxtGrossIncome = findViewById(R.id.editTextGrossIncome);
        edttxtRRSP =findViewById(R.id.editTextRRSP);
        edttxtBirthDate = findViewById(R.id.editTextBirthdate);
        edttxtTaxFiledDate = findViewById(R.id.editTextFilledDate);
        btnCalculate = findViewById(R.id.btnCalculate);

        edttxtTaxFiledDate.setText(new StringBuilder()
                .append(day).append(" ").append("-").append(month + 1).append("-")
                .append(year));

        edttxtBirthDate.setInputType(InputType.TYPE_NULL);
        edttxtBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {


                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edttxtBirthDate.setText(monthOfYear +"/"+ dayOfMonth +"/" +year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, SecondActivity.class);
                fieldIsEmpty();
            }
        });

        rdgrpGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i == R.id.radioButtonMale){
                    gender = rdbtnMale.getText().toString();
                }else if(i == R.id.radioButtonFemale){
                    gender = rdbtnFemale.getText().toString();
                }else {
                    gender = rdbtnOther.getText().toString();
                }
            }

        });
    }

    private void fieldIsEmpty() {
        boolean Flag = false;
        if(edttxtSinNumber.getText().toString().isEmpty())
        {
            edttxtSinNumber.setError("Please enter your SIN");
            Flag = true;
            return;
        }
        if(edttxtFirstName.getText().toString().isEmpty()){
            edttxtFirstName.setError("Please enter your first name");
            Flag = true;
            return;
        }
        if(edttxtLastName.getText().toString().isEmpty())
        {
            edttxtLastName.setError("Please enter your Last Name");
            Flag = true;
            return;
        }
        if(edttxtBirthDate.getText().toString().isEmpty())
        {
            edttxtBirthDate.setError("Please enter your date of birth");
            Flag = true;
            return;
        }
        if(edttxtGrossIncome.getText().toString().isEmpty())
        {
            edttxtGrossIncome.setError("Please enter your Gross Income");
            Flag = true;
            return;
        }
        if(edttxtRRSP.getText().toString().isEmpty())
        {
            edttxtRRSP.setError("Please enter valid RRSP");
            Flag = true;
            return;
        }

        if(!Flag)
        {
            Double grossIncome = Double.parseDouble(edttxtGrossIncome.getText().toString());
            Double rrspContribution = Double.parseDouble(edttxtRRSP.getText().toString());
            Customer customer = new Customer(edttxtSinNumber.getText().toString(),
                    edttxtFirstName.getText().toString(),edttxtLastName.getText().toString(),
                    edttxtBirthDate.getText().toString(),edttxtTaxFiledDate.toString(),Double.parseDouble(edttxtGrossIncome.getText().toString()),
                    Double.parseDouble(edttxtRRSP.getText().toString()));
            Intent mIntent = new Intent(MainActivity.this, SecondActivity.class);
            mIntent.putExtra("Customer", customer);
            mIntent.putExtra("gender", gender);
            mIntent.putExtra("age", getCurrentDate());
            mIntent.putExtra("filedDate",taxFiledDate);
            startActivity(mIntent);
        }
    }
    int calculateAge(String date){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        String age_e= "Age is"+String.valueOf(age);
        Toast.makeText(MainActivity.this, age_e, Toast.LENGTH_SHORT).show();
        if(today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)){
            age--;
        }
        return age;
    }
    public String getCurrentDate() {

        StringBuilder todaydate=new StringBuilder();
        Calendar today=Calendar.getInstance();
        int age=today.get(Calendar.YEAR)-picker.getDatePicker().getYear();
        if (today.get(Calendar.MONTH) < picker.getDatePicker().getYear()) {
            age--;
        } else if (today.get(Calendar.MONTH) == picker.getDatePicker().getYear()
                && today.get(Calendar.DAY_OF_MONTH) < picker.getDatePicker().getYear()) {
            age--;
        }

        todaydate.append(String.valueOf(age));
        return todaydate.toString();
    }
    Date date=java.util.Calendar.getInstance().getTime();
    String taxFiledDate = date.toString();
}


