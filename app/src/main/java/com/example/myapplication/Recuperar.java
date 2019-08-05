package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Recuperar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        /* Back button at the top of the pagee that goes back to the previous activity */
        TextView textBack = findViewById(R.id.backButtonTextRecuperar);
        textBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /* created the OnClick Method for when a user puts in credentials to sign into an account */
        Button buttonRecuperar = findViewById(R.id.buttonRecuperar);
        buttonRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO store new credentials into model
            }
        });
    }
}
