package com.example.alioth.jump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SeventhActivity extends AppCompatActivity {
    private String data="";
    private String newdata="";
    private Button button;
    private String transportation="";
    private RadioGroup transgroup;
    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5,radioButton6,radioButton7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        Intent intent = getIntent();
        data = intent.getStringExtra("extradata");
        init();
        transgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioButton1.getId()==i){
                    transportation=radioButton1.getText().toString();
                }
                if(radioButton2.getId()==i){
                    transportation=radioButton2.getText().toString();
                }
                if(radioButton3.getId()==i){
                    transportation=radioButton3.getText().toString();
                }
                if(radioButton4.getId()==i){
                    transportation=radioButton4.getText().toString();
                }
                if(radioButton5.getId()==i){
                    transportation=radioButton5.getText().toString();
                }
                if(radioButton6.getId()==i){
                    transportation=radioButton6.getText().toString();
                }
                if(radioButton7.getId()==i){
                    transportation=radioButton7.getText().toString();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeventhActivity.this, EighthActivity.class);
                if(transportation==""){
                    Toast.makeText(getApplicationContext(),"请选择一项",Toast.LENGTH_SHORT).show();
                }else{
                    newdata = data+" "+transportation;
                    intent.putExtra("extradata",newdata);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    protected void init(){
        button = (Button)findViewById(R.id.button_7);
        transgroup = (RadioGroup)findViewById(R.id.transgroup);
        radioButton1 = (RadioButton)findViewById(R.id.tradio1);
        radioButton2 = (RadioButton)findViewById(R.id.tradio2);
        radioButton3 = (RadioButton)findViewById(R.id.tradio3);
        radioButton4 = (RadioButton)findViewById(R.id.tradio4);
        radioButton5 = (RadioButton)findViewById(R.id.tradio5);
        radioButton6 = (RadioButton)findViewById(R.id.tradio6);
        radioButton7 = (RadioButton)findViewById(R.id.tradio7);
    }
}
