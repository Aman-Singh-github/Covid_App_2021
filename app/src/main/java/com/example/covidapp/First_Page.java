package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__page);
        Button slidebutton1=findViewById(R.id.slidebutton1);
        Button slidebutton2=findViewById(R.id.slidebutton2);
        Button slidebutton3=findViewById(R.id.slidebutton3);
        Button slidebutton4=findViewById(R.id.slidebutton4);


        slidebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SlideButton2();

            }
        });
        slidebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SlideButton3();

            }
        });
        slidebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SlideButton4();

            }
        });
    }
    public void SlideButton2()
    {
        Intent intent=new Intent(this,Second_Page.class);
        startActivity(intent);
    }
    public void SlideButton3()
    {
        Intent intent=new Intent(this,Third_Page.class);
        startActivity(intent);

    }
    public void SlideButton4()
    {
        Intent intent=new Intent(this,Forth_Page.class);
        startActivity(intent);
    }
}