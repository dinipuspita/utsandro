package com.example.dini_pc.kel3_utsandroid;

import android.Manifest;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertNovel extends AppCompatActivity {

    protected Cursor cursor;
    MyDataHelper dbHelper;
    Button btn1, btn2, btn_Choose;
    EditText text2, text3, text4, text5, text6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_novel);

        dbHelper = new MyDataHelper(this);

        //digunakan untuk mencari id dari view
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        text6 = (EditText) findViewById(R.id.editText6);

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //mencari data yang dapat di edit
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                //insert data ke database dengan value judul dan tahun rilis berupa text dengan tipe data string
                db.execSQL("INSERT INTO tb_novel(judul, penulis, penerbit, tahunterbit, sinopsis ) values('" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "','" +
                        text6.getText().toString() + "')");

                // Menampilkan teks berhasil setelah menambahkan data
                Toast.makeText(getApplicationContext(), "Data Berhasil Ditambahkan",
                        Toast.LENGTH_LONG).show();
                //Menampilkan list movie yang telah di tambahkan
                Main2Activity.layarutama.TampilkanList();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                finish();

            }
        });
    }


}
