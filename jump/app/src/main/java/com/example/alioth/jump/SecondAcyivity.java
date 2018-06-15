package com.example.alioth.jump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class SecondAcyivity extends AppCompatActivity {
    int year = 0;
    int monthOfYear = 0;
    int dayOfMonth = 0;
    private Button button;
    private TextView birthtext;
    private String data = "";
    private String birthdata = "";
    private String newData = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        data = intent.getStringExtra("extradata");
        init();
        //showDate(year,monthOfYear+1,dayOfMonth);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondAcyivity.this,ThirdActivity.class);
                birthdata = year+"-"+(monthOfYear+1)+"-"+dayOfMonth;
                newData = data+" "+birthdata;
                intent.putExtra("extradata", newData);
                startActivity(intent);
                finish();
            }
        });

    }
    public void init(){
        button = (Button)findViewById(R.id.button_2);
        final DatePicker birthday = (DatePicker)findViewById(R.id.birthday);
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        monthOfYear = c.get(Calendar.MONTH);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        birthtext = (TextView)findViewById(R.id.birthtext);
        birthday.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                SecondAcyivity.this.year=year;
                SecondAcyivity.this.monthOfYear=monthOfYear;
                SecondAcyivity.this.dayOfMonth=dayOfMonth;
                showDate(year,monthOfYear+1,dayOfMonth);
            }
        });
    }
    public void showDate(int year,int monthOfYear,int dayOfMonth){
        birthtext.setText("生日:  "+year+"-"+monthOfYear+"-"+dayOfMonth);
    }
}
