package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Forth_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth__page);
        Button slidebutton1=findViewById(R.id.slidebutton1);
        Button slidebutton2=findViewById(R.id.slidebutton2);
        Button slidebutton3=findViewById(R.id.slidebutton3);
        Button slidebutton4=findViewById(R.id.slidebutton4);
        Button getStarted=findViewById(R.id.getStartedButton);
        slidebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Forth_Page.this, First_Page.class);
                startActivity(intent);
            }
        }
        );
        slidebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Forth_Page.this,Second_Page.class);
                startActivity(intent);
            }
        });
        slidebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Forth_Page.this,Third_Page.class);
                startActivity(intent);
            }
        });
        slidebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Forth_Page.this,Forth_Page.class);
                startActivity(intent);
            }
        });
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Forth_Page.this,Login_Page.class);
                startActivity(intent);
            }
        });
    }
}