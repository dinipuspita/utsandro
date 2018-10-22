package com.example.dini_pc.kel3_utsandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewMovie extends AppCompatActivity {

    protected Cursor cursor;
    MyDataHelper dbHelper;
    Button btn2;
    TextView text1, text2, text3, text4, text5, text6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movie);

        dbHelper = new MyDataHelper(this);
        //digunakan untuk mencari id dari view
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text5 = (TextView) findViewById(R.id.textView5);
        text4 = (TextView) findViewById(R.id.textView4);
        text6 = (TextView) findViewById(R.id.textView6);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //menampilkan data pada database sinetrons berdasarkan judul
        cursor = db.rawQuery("SELECT * FROM tb_novel WHERE judul = '" + getIntent().getStringExtra("judul")+ "'",null);
        //mendapat nilai kembalian saat pindah ke record data pertama
        cursor.moveToFirst();

        //untuk set data ke database
        if(cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0));
            text2.setText(cursor.getString(1));
            text3.setText(cursor.getString(2));
            text4.setText(cursor.getString(3));
            text5.setText(cursor.getString(4));
            text6.setText(cursor.getString(5));

        }
        btn2 = (Button) findViewById (R.id.button1);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
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
}
