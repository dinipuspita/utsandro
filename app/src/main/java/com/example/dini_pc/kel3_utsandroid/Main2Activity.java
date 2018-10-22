package com.example.dini_pc.kel3_utsandroid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    ListView ListView01;
    protected Cursor cursor;
    MyDataHelper datanovel;
   private Button button_recycler;

    public static Main2Activity layarutama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle b = getIntent().getExtras();

        Button btn = (Button) findViewById(R.id.button2);


        // Register event onClick ke tombol btn
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Main2Activity.this, InsertNovel.class);
                startActivity(myintent);
            }
        });

        layarutama = this;
        TampilkanList();
    }

    public void TampilkanList() {
        datanovel = new MyDataHelper(this);
        SQLiteDatabase db = datanovel.getReadableDatabase();

        //Untuk mendapatkan nilai kembalian dari hasil select table sinetrons
        cursor = db.rawQuery("SELECT * FROM tb_novel", null);
        final String[] databaru = new String[cursor.getCount()];

        //  untuk mendapatkan nilai kembalian saat kembali ke record data pertama
        cursor.moveToFirst();

        //cursor memilih data dengan colom index 1
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            databaru[cc] = cursor.getString(1);
        }
        //Untuk menampilkan listview
        ListView01 = (ListView) findViewById (R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, databaru));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0 , View arg1, int arg2, long arg3) {

                final String selection = databaru[arg2]; // getItemAtposition(arg2).toString();
                // untuk menampilkan dialog saat memilih item dengan pilihan lihat , update dan hapus item
                final CharSequence[] dialogitem = {"Lihat Novel", "Update Novel", "hapus Novel"};

                // Untuk menampilkan menu View dan Insert melalui alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);

                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int item){
                        switch (item){
                            case 0 :
                                // menampilkan data dan intent ke halaman ViewMovie
                                Intent intent0 = new Intent(getApplicationContext(), ViewMovie.class);
                                intent0.putExtra("judul", selection);
                                startActivity(intent0);
                                break;

                            case 1 :
                                //mengupdate data dan intent ke halaman UpdateMovie
                                Intent intent1 = new Intent(getApplicationContext(), UpdateNovel.class);
                                intent1.putExtra("judul", selection);
                                startActivity(intent1);
                                break;

                            case 2 :
                                //menghapus data berdasarkan judul item
                                SQLiteDatabase db = datanovel.getWritableDatabase();
                                db.execSQL("DELETE FROM tb_novel WHERE judul = '" + selection + "'");
                                TampilkanList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
        cursor.close();
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
