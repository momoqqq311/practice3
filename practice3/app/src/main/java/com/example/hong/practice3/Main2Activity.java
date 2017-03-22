package com.example.hong.practice3;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import static android.R.attr.format;
import static android.R.attr.timePickerDialogTheme;

public class Main2Activity extends AppCompatActivity {
    Switch s1;
    TextView time;
    DatePicker date;
    Button before, next;
    Chronometer c1;
    TimePicker timepicker;
    TableLayout tablelayout,tablelayout2;
    FrameLayout framelayout;
    EditText e1,e2,e3;
    TextView t1,t2,t3,t4,t5;
    int page = 1;

    @Override
    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        start();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    void start(){
        time = (TextView)findViewById(R.id.time);
        s1 = (Switch)findViewById(R.id.switch1);
        c1 = (Chronometer) findViewById(R.id.chronometer);

        before = (Button) findViewById(R.id.button);
        next = (Button) findViewById(R.id.button2);

        date=(DatePicker)findViewById(R.id.datePicker);
        timepicker = (TimePicker)findViewById(R.id.timePicker);

        framelayout = (FrameLayout)findViewById(R.id.fm);
        tablelayout = (TableLayout)findViewById(R.id.tb);
        tablelayout2 = (TableLayout)findViewById(R.id.tb2);

        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView2);
        t3 = (TextView)findViewById(R.id.textView3);
        t4 = (TextView)findViewById(R.id.textView4);
        t5 = (TextView)findViewById(R.id.textView5);

        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(s1.isChecked()) {
                    framelayout.setVisibility(framelayout.VISIBLE);
                    time.setVisibility(time.VISIBLE);
                    c1.setVisibility(c1.VISIBLE);
                    c1.start();

                    //page1
                    before.setVisibility(before.VISIBLE);
                    next.setVisibility(next.VISIBLE);
                    date.setVisibility(date.VISIBLE);
                    next.setEnabled(true);
                    before.setEnabled(false);
                    next.setEnabled(true);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(page==1){//->page2
                                date.setVisibility(date.INVISIBLE);
                                before.setEnabled(true);
                                timepicker.setVisibility(timepicker.VISIBLE);
                                page++;//2
                            }else if(page==2){//->3
                                timepicker.setVisibility(timepicker.INVISIBLE);
                                tablelayout.setVisibility(tablelayout.VISIBLE);
                                page++;
                            }else if(page==3){//->4
                                next.setEnabled(false);
                                tablelayout2.setVisibility(tablelayout2.VISIBLE);
                                String adult = e1.getText().toString();
                                String youth = e2.getText().toString();
                                String child = e3.getText().toString();
                                t1.setText(date.getYear()+"년"+date.getMonth()+"월"+date.getDayOfMonth()+"일");
                                t2.setText(timepicker.getHour()+"시"+timepicker.getMinute()+"분");
                                t3.setText(adult);
                                t4.setText(youth);
                                t5.setText(child);
                                page++;
                            }else{

                            }
                        }
                    });
                    before.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if(page==2){//-->1
                                timepicker.setVisibility(timepicker.INVISIBLE);
                                date.setVisibility(date.VISIBLE);
                                before.setEnabled(false);
                                page--;
                            }else if(page==3){//->2
                                tablelayout.setVisibility(tablelayout.INVISIBLE);
                                timepicker.setVisibility(timepicker.VISIBLE);
                                page--;
                            }else if(page==4){
                                tablelayout2.setVisibility(tablelayout2.INVISIBLE);
                                tablelayout.setVisibility(tablelayout.VISIBLE);
                                next.setEnabled(true);
                                page--;
                            }else{

                            }
                        }
                    });

                }else{
                    c1.setBase(SystemClock.elapsedRealtime());
                    before.setVisibility(before.INVISIBLE);
                    next.setVisibility(next.INVISIBLE);
                    tablelayout2.setVisibility(tablelayout2.INVISIBLE);
                    framelayout.setVisibility(framelayout .INVISIBLE);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t1.setText("");
                    tablelayout.setVisibility(tablelayout.INVISIBLE);
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    date.setVisibility(date.INVISIBLE);
                    timepicker.setVisibility(timepicker.INVISIBLE);
                    page=1;
                }
            }
        });
    }
}
