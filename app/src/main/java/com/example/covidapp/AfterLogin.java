package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class AfterLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        final Button logout=findViewById(R.id.logout);
        TextView mail=findViewById(R.id.loginuserView);
        TextView name=findViewById(R.id.nameView);
        Button covidRateTracker=findViewById(R.id.covidRateTracker);
        covidRateTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AfterLogin.this,CovidTrackerData.class);
                startActivity(intent);
            }
        });


        GoogleSignInAccount googleSignInAccount= GoogleSignIn.getLastSignedInAccount(this);
        if(googleSignInAccount!=null){
            name.setText(googleSignInAccount.getDisplayName());
            mail.setText(googleSignInAccount.getEmail());

        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),Login_Page.class);
               finish();
              //  startActivity(new Intent(AfterLogin.this,Login_Page.class));
            }
        });
    }
}