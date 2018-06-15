package com.example.alioth.jump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private Button button_1,button_2;
    private RadioGroup sexRadioGroup;
    private RadioButton male,female;
    private String data="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        initConment();
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FirstActivity.this,SecondAcyivity.class);
                if(data==""){
                    Toast.makeText(getApplicationContext(),"请选择性别",Toast.LENGTH_SHORT).show();
                }else{
                    intent.putExtra("extradata",data);
                    startActivity(intent);
                    finish();
                }
               // intent.putExtra("sex",)

            }
        });
        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //String data = "";
                if(male.getId()==i){
                    data=male.getText().toString();
                }
                if(female.getId()==i){
                    data =female.getText().toString();
                }
                //Toast.makeText(getApplicationContext(),sex,Toast.LENGTH_LONG).show();
            }
        });
    }
    private void initConment(){
        button_1 = (Button)findViewById(R.id.button_1);
        sexRadioGroup = (RadioGroup)findViewById(R.id.sexgroup);
        male = (RadioButton)findViewById(R.id.radioButton2);
        female = (RadioButton)findViewById(R.id.radioButton3);
    }


}
