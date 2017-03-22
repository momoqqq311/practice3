package com.example.hong.practice3;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    TextView t1,t2;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onMyClick(View v){
        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView2);
        image = (ImageView)findViewById(R.id.imageView);

        if(v.getId()== R.id.button){//학점 계산
            String kor = e1.getText().toString();
            String math = e2.getText().toString();
            String eng = e3.getText().toString();
            if(kor.equals("")){
                e1.setText("0");
                kor="0";
            }if(math.equals("")){
                e2.setText("0");
                math="0";
            }if(eng.equals("")){
                e3.setText("0");
                eng="0";
            }

            int total = Integer.parseInt(kor) + Integer.parseInt(math) + Integer.parseInt(eng);
            double average = total/3;
            t1.setText(total+"점");
            t2.setText(average+"점");
            image.setVisibility(image.VISIBLE);
            if(average>=90){
                image.setImageResource(R.drawable.score_a);
            }else if(average>=80){
                image.setImageResource(R.drawable.score_b);
            }else if(average>=70){
                image.setImageResource(R.drawable.score_c);
            }else if(average>=60){
                image.setImageResource(R.drawable.score_d);
            }else if(average>=50){
                image.setImageResource(R.drawable.score_e);
            }else{
                image.setImageResource(R.drawable.score_f);
            }

        }else{//초기화
            e1.setText("0");
            e2.setText("0");
            e3.setText("0");
            t1.setText("0점");
            t2.setText("0점");
            image.setVisibility(image.INVISIBLE);
            Toast.makeText(getApplicationContext(), "초기화 되었습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
