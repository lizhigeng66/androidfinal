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

public class FourthActivity extends AppCompatActivity {
    private TextView test;
    private String data="";
    private String newdata="";
    private Button button;
    private String vocation="";
    private RadioGroup vocationgroup;
    private RadioButton radioButton0,radioButton1,radioButton2,radioButton3,radioButton4,radioButton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Intent intent = getIntent();
        data = intent.getStringExtra("extradata");
        init();
        vocationgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioButton0.getId()==i){
                    vocation=radioButton0.getText().toString();
                }
                if(radioButton1.getId()==i){
                    vocation=radioButton1.getText().toString();
                }
                if(radioButton2.getId()==i){
                    vocation=radioButton2.getText().toString();
                }
                if(radioButton3.getId()==i){
                    vocation=radioButton3.getText().toString();
                }
                if(radioButton4.getId()==i){
                    vocation=radioButton4.getText().toString();
                }
                if(radioButton5.getId()==i){
                    vocation=radioButton5.getText().toString();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthActivity.this,FifthActivity.class);
                if(vocation==""){
                    Toast.makeText(getApplicationContext(),"请选择一项",Toast.LENGTH_SHORT).show();
                }else{
                    newdata = data+" "+vocation;
                    intent.putExtra("extradata",newdata);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
    protected void init(){
        test=(TextView)findViewById(R.id.vocation);
        button = (Button)findViewById(R.id.button_4);
        vocationgroup = (RadioGroup)findViewById(R.id.vocationgroup);
        radioButton0 = (RadioButton)findViewById(R.id.vradio1);
        radioButton1 = (RadioButton)findViewById(R.id.vradio2);
        radioButton2 = (RadioButton)findViewById(R.id.vradio3);
        radioButton3 = (RadioButton)findViewById(R.id.vradio4);
        radioButton4 = (RadioButton)findViewById(R.id.vradio5);
        radioButton5 = (RadioButton)findViewById(R.id.vradio6);
    }
}
