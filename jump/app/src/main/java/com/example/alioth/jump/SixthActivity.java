package com.example.alioth.jump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SixthActivity extends AppCompatActivity {
    private String data="";
    private String newdata="";
    private Button button;
    private String emotional="";
    private RadioGroup emgroup;
    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        Intent intent = getIntent();
        data = intent.getStringExtra("extradata");
        init();
        emgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioButton1.getId()==i){
                    emotional=radioButton1.getText().toString();
                }
                if(radioButton2.getId()==i){
                    emotional=radioButton2.getText().toString();
                }
                if(radioButton3.getId()==i){
                    emotional=radioButton3.getText().toString();
                }
                if(radioButton4.getId()==i){
                    emotional=radioButton4.getText().toString();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SixthActivity.this, SeventhActivity.class);
                if (emotional == "") {
                    Toast.makeText(getApplicationContext(), "请选择一项", Toast.LENGTH_SHORT).show();
                } else {
                    newdata = data + " " + emotional;
                    intent.putExtra("extradata", newdata);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    protected void init(){
        button = (Button)findViewById(R.id.button_6);
        emgroup = (RadioGroup)findViewById(R.id.emgroup);
        radioButton1 = (RadioButton)findViewById(R.id.emradio1);
        radioButton2 = (RadioButton)findViewById(R.id.emradio2);
        radioButton3 = (RadioButton)findViewById(R.id.emradio3);
        radioButton4 = (RadioButton)findViewById(R.id.emradio4);
    }
}
