package com.example.hong.practice3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void button(View v){
        if(v.getId()==R.id.button){
            Intent intent = new Intent(Main3Activity.this, MainActivity.class);//현재 activity , 이동할 activity
            startActivity(intent);
        }else{
            Intent intent = new Intent(Main3Activity.this, Main2Activity.class);//현재 activity , 이동할 activity
            startActivity(intent);
        }

    }
}
