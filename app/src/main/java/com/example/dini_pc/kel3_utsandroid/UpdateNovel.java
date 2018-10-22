package com.example.dini_pc.kel3_utsandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNovel extends AppCompatActivity {
    protected Cursor cursor;
    MyDataHelper dbHelper;
    Button button1, button2;
    EditText text2, text3, text4, text5, text6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_novel);
        dbHelper = new MyDataHelper(this);

        //digunakan untuk mencari id dari view
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText5);
        text5 = (EditText) findViewById(R.id.editText4);
        text6 = (EditText) findViewById(R.id.editText6);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //Select item yg dipilih
        cursor = db.rawQuery("SELECT * FROM tb_novel WHERE judul = '" +
                getIntent().getStringExtra("judul") + "'",null);
        //pindah ke record data pertama
        cursor.moveToFirst();
        //mengambil data pada database
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(5).toString());
            text6.setText(cursor.getString(4).toString());
        }
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        // daftarkan even onClick pada btnSimpan
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                //mencari database yang bisa diedit
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //syntax update pada databse
                db.execSQL("update tb_novel set judul='"+
                        text2.getText().toString() +"', penulis='" +
                        text3.getText().toString()+"', penerbit='"+
                        text4.getText().toString() +"', tahunterbit='" +
                        text5.getText().toString() +"', sinopsis='" +
                        text6.getText().toString() + "' where judul = '" + getIntent().getStringExtra("judul")+ "'");
                //menampilkan notifikasi data berhasil di edit
                Toast.makeText(getApplicationContext(), "Data Berhasil diUpdate", Toast.LENGTH_LONG).show();
                //menampilkan data item berupa list data
                Main2Activity.layarutama.TampilkanList();
                finish(); 
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
    }

