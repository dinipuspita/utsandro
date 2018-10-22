package com.example.dini_pc.kel3_utsandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private Button button_recycler;
    private Button button_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public  void button_logout(View view){
        SharedPreferences click = this.getSharedPreferences("key", Context.MODE_PRIVATE);
        SharedPreferences .Editor editor = click.edit();
        editor.remove("usename");
        editor.remove("password");
        editor.commit();
        finish();

        Intent i = new Intent(this.getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
    public void recycler(View view){
        button_recycler = findViewById(R.id.btn_recycler);
        button_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(i);
            }
        });
    }
    public void tambahdata(View view){
        button_tambah = findViewById(R.id.btn_tambah);
        button_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);
            }
        });
    }


}
