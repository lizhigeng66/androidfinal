package com.example.alioth.jump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private TextView test;
    private String data;
    private String newData="";
    private String cost = "";
    private Button button;
    private RadioGroup costgroup;
    private RadioButton radioButton0,radioButton1,radioButton2,radioButton3,radioButton4,radioButton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        data = intent.getStringExtra("extradata");
        init();
        costgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioButton0.getId()==i){
                    cost=radioButton0.getText().toString();
                }
                if(radioButton1.getId()==i){
                    cost=radioButton1.getText().toString();
                }
                if(radioButton2.getId()==i){
                    cost=radioButton2.getText().toString();
                }
                if(radioButton3.getId()==i){
                    cost=radioButton3.getText().toString();
                }
                if(radioButton4.getId()==i){
                    cost=radioButton4.getText().toString();
                }
                if(radioButton5.getId()==i){
                    cost=radioButton5.getText().toString();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this,FourthActivity.class);
                if(cost==""){
                    Toast.makeText(getApplicationContext(),"请选择一项",Toast.LENGTH_SHORT).show();
                }else{
                    newData=data+" "+cost;
                    intent.putExtra("extradata",newData);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    protected void init(){
        button = (Button)findViewById(R.id.button_3);
        costgroup = (RadioGroup)findViewById(R.id.costgroup);
        radioButton0=(RadioButton)findViewById(R.id.radio0);
        radioButton1 =(RadioButton)findViewById(R.id.radio1);
        radioButton2=(RadioButton)findViewById(R.id.radio2);
        radioButton3=(RadioButton)findViewById(R.id.radio3);
        radioButton4=(RadioButton)findViewById(R.id.radio4);
        radioButton5=(RadioButton)findViewById(R.id.radio5);
    }
}
