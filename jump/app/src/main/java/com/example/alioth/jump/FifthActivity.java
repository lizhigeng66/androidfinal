package com.example.alioth.jump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.SignatureSpi;

public class FifthActivity extends AppCompatActivity {
    private String data="";
    private String newdata="";
    private Button button;
    private String educated="";
    private RadioGroup edugroup;
    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Intent intent = getIntent();
        data = intent.getStringExtra("extradata");
        init();
        edugroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioButton1.getId()==i){
                    educated=radioButton1.getText().toString();
                }
                if(radioButton2.getId()==i){
                    educated=radioButton2.getText().toString();
                }
                if(radioButton3.getId()==i){
                    educated=radioButton3.getText().toString();
                }
                if(radioButton4.getId()==i){
                    educated=radioButton4.getText().toString();
                }
                if(radioButton5.getId()==i){
                    educated=radioButton5.getText().toString();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FifthActivity.this, SixthActivity.class);
                if(educated==""){
                    Toast.makeText(getApplicationContext(),"请选择一项",Toast.LENGTH_SHORT).show();
                }else{
                    newdata = data+" "+educated;
                    intent.putExtra("extradata",newdata);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    protected void init(){
        button = (Button)findViewById(R.id.button_5);
        edugroup = (RadioGroup)findViewById(R.id.edugroup);
        radioButton1 = (RadioButton)findViewById(R.id.eradio1);
        radioButton2 = (RadioButton)findViewById(R.id.eradio2);
        radioButton3 = (RadioButton)findViewById(R.id.eradio3);
        radioButton4 = (RadioButton)findViewById(R.id.eradio4);
        radioButton5 = (RadioButton)findViewById(R.id.eradio5);

    }
}
