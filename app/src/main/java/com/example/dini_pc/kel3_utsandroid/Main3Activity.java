package com.example.dini_pc.kel3_utsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.dini_pc.kel3_utsandroid.models.ClickListener;
import com.example.dini_pc.kel3_utsandroid.models.MyData;
import com.example.dini_pc.kel3_utsandroid.models.MyDataAdapter;
import com.example.dini_pc.kel3_utsandroid.models.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<MyData> myDatas = new ArrayList<>();
    private MyData data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        data = new MyData("Id                   : 1", "Judul              : Ayat-ayat Cinta", "Penulis           : habiburrahman El Shirazy", "Penerbit          : Republika", "Tahun Terbit   :2017", "Sinopsis          :Ini adalah kisah cinta. Tapi bukan cuma sekadar kisah cinta yang biasa. Ini tentang bagaimana menghadapi turun-naiknya persoalan hidup dengan cara Islam.", R.drawable.nv1);
        myDatas.add(data);

        data = new MyData("Id                   : 2", "Judul              : Aku Benci & Cinta", "Penulis           : Wulan Fadi", "Penerbit          : Best Media", "Tahun Terbit   :2015", "Sinopsis          :Bercerita tentang cowok bandel bernama Alvaro yang sering berantem dengan Anggi, padahal diam-diam Alvaro sebenarnya jatuh hati pada musuhnya ini. Uniknya meski bandel Alvaro menjabat sebagai ketua osis.", R.drawable.nv1);
        myDatas.add(data);

        data = new MyData("Id                   : 3", "Judul              : Laut Bercerita", "Penulis           :Candara Bayu", "Penerbit          : Republika", "Tahun Terbit   :2017", "Sinopsis          :bertutur tentang kisah keluarga yang kehilangan, sekumpulan sahabat yang merasakan kekosongan di dada, sekelompok orang yang gemar menyiksa dan lancar berkhianat, sejumlah keluarga yang mencari kejelasan makam anaknya, dan tentang cinta yang tak akan luntur.", R.drawable.nv2);
        myDatas.add(data);

        data = new MyData("Id                   : 4", "Judul              : Andrea Hirata", "Penulis           :Andrea Hirata ", "Penerbit          : Media Center", "Tahun Terbit   :2015", "Sinopsis          :Baiklah, Kawan, kuceritakan padamu soal pertempuranku melawan pohon delima di pekarangan rumahku dan bagaimana akhirnya pohon itu membuatku kena sel,lalu wajib lapor setiap Hari Senin, di Polsek Belantik. Benci nian aku pada delima itu, lihatlah pohon kampungan itu, ia macam kena kutuk. .", R.drawable.nv4);
        myDatas.add(data);

        data = new MyData("Id                   : 5", "Judul              : RoofTop Buddies", "Penulis           :Honey De ", "Penerbit          : Republika", "Tahun Terbit   :2016", "Sinopsis          :Bagi Rie berjuang menahan sakit dalam masa pengobatan hanyalah sia-sia. Jika pada akhirnya akan mati, kenapa harus menunggu dan seolah menjalin harapan? Ia mengidap kanker, dan lompat dari gedung apartemen sudah menjadi pertimbangannya untuk cepat mengakhiri penyiksaan dalam hidupnya.", R.drawable.nv5);
        myDatas.add(data);

        data = new MyData("Id                   : 6", "Judul              : Floating In Space", "Penulis           :Naela Ali ", "Penerbit          : Best Media", "Tahun Terbit   :2016", "Sinopsis          :Setelah sukses dengan ketiga bukunya dan hujan dalam buku Stories for Rainy Days, kini Naela Ali kembali menghadirkan kesegaran baru lewat Floating in Space.", R.drawable.nv6);
        myDatas.add(data);

        data = new MyData("Id                   : 7", "Judul              : Manusia Setengah Salmon", "Penulis           :Raditya Dika ", "Penerbit          : Best Media", "Tahun Terbit   :2014", "Sinopsis          : Manusia Setengah Salmon ini dikemas dengan unsur komedi. Di buku ini juga banyak cerita mengenai pengalaman pribadi Radit.", R.drawable.nv8);
        myDatas.add(data);

        data = new MyData("Id                   : 8", "Judul              : Dia Adalah Dilanku Tahun 19990", "Penulis           :Pidi Baiq ", "Penerbit          : Pastel Books", "Tahun Terbit   :2011", "Sinopsis          : Novel Dilan ini menceritakan sebuah kisah seorang perempuan yang bernama Milea. Milea merupakan seorang murid yang baru saja pindah dari Jakarta.", R.drawable.nv9);
        myDatas.add(data);

        mAdapter = new MyDataAdapter(myDatas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new ClickListener(){

            @Override
            public void onClick(View view, int position) {
                MyData data = myDatas.get(position);
                Toast.makeText(getApplicationContext(), data.getJudul() + " is selected;",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent (getApplicationContext(), details.class);
                i.putExtra("id", data.getId());
                i.putExtra("judul", data.getJudul());
                i.putExtra("penulis", data.getPenulis());
                i.putExtra("penerbit", data.getPenerbit());
                i.putExtra("tahunterbit", data.getTahunterbit());
                i.putExtra("sinopsis", data.getSinopsis());
                i.putExtra("gambar", data.getGambar());
                startActivity(i);

            }

            @Override
            public void onLongClick(View view, int position) {

            }

        }));
    }

}