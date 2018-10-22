package com.example.dini_pc.kel3_utsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class details extends AppCompatActivity {
    TextView id, judul, penulis, penerbit, tahunterbit, sinopsis;
    ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        id= (TextView) findViewById(R.id.id);
        judul=(TextView) findViewById(R.id.judul);
        penulis=(TextView) findViewById(R.id.penulis);
        penerbit=(TextView) findViewById(R.id.penerbit);
        tahunterbit=(TextView) findViewById(R.id.tahunterbit);
        sinopsis=(TextView) findViewById(R.id.sinopsis);
        gambar=(ImageView) findViewById(R.id.gambar);

        Intent i = getIntent();
        String ids=i.getStringExtra("id");
        String juduls=i.getStringExtra("judul");
        String penuliss=i.getStringExtra("penulis");
        String penerbits=i.getStringExtra("penerbit");
        String tahunterbits=i.getStringExtra("tahunterbit");
        String sinopsiss=i.getStringExtra("sinopsis");
        int thumbnail = i.getIntExtra("gambar", 0);
        id.setText(ids);
        judul.setText(juduls);
        penulis.setText(penuliss);
        penerbit.setText(penerbits);
        tahunterbit.setText(tahunterbits);
        sinopsis.setText(sinopsiss);
        gambar.setImageResource(thumbnail);

    }
}
