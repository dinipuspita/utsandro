package com.example.dini_pc.kel3_utsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class list_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        Bundle b = getIntent().getExtras();

        TextView username = (TextView) findViewById(R.id.usernameValue);

        username.setText(b.getCharSequence("username"));
    }
}
