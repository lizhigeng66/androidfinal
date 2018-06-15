package com.example.alioth.jump;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;;
import android.provider.Settings;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class EighthActivity extends AppCompatActivity {
    private String data="";
    private String newdata="";
    private Button button;
    private String hobbit="";
    private Socket socket;
    private ExecutorService mTreadPool;
    private static final String serverip = "10.202.4.76";
    private static final int port = 10081;
    OutputStream outputStream;
    private RadioGroup hobbitgroup;
    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4,radioButton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth);
        Intent intent = getIntent();
        data = intent.getStringExtra("extradata");
        init();
        hobbitgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioButton1.getId()==i){
                    hobbit=radioButton1.getText().toString();
                }
                if(radioButton2.getId()==i){
                    hobbit=radioButton2.getText().toString();
                }
                if(radioButton3.getId()==i){
                    hobbit=radioButton3.getText().toString();
                }
                if(radioButton4.getId()==i){
                    hobbit=radioButton4.getText().toString();
                }
                if(radioButton5.getId()==i){
                    hobbit=radioButton5.getText().toString();
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EighthActivity.this, NinethActivity.class);
                if(hobbit==""){
                    Toast.makeText(getApplicationContext(),"请选择一项",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"已发送",Toast.LENGTH_SHORT).show();
                    newdata = data+" "+hobbit;
                    intent.putExtra("extradata",newdata);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    protected void init(){

        button = (Button)findViewById(R.id.button_8);
        hobbitgroup = (RadioGroup)findViewById(R.id.hgroup);
        radioButton1 = (RadioButton)findViewById(R.id.hradio1);
        radioButton2 = (RadioButton)findViewById(R.id.hradio2);
        radioButton3 = (RadioButton)findViewById(R.id.hradio3);
        radioButton4 = (RadioButton)findViewById(R.id.hradio4);
        radioButton5 = (RadioButton)findViewById(R.id.hradio5);
    }
}
