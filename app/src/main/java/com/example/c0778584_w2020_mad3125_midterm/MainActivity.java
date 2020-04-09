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

import java.util.Calendar;

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

        edttxtBirthDate.setInputType(InputType.TYPE_NULL);
        edttxtBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {


                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                //edttxtBirthDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
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
                startActivity(mIntent);
            }
        });



    }
}
