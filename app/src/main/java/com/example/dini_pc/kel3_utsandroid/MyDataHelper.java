package com.example.dini_pc.kel3_utsandroid;

import android.Manifest;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyDataHelper extends SQLiteOpenHelper {

    // nama database
    private static final String NAMA_DB = "novel.db";
    // nama tabel
    private static final String NAMA_TABEL = "tb_novel";
    // versi database
    private static final int VERSI_DB = 1;
    //nama kolom dalam tabel
    private static final String ID = "_id";
    private static final String JUDUL = "judul";
    private static final String PENULIS= "penulis";
    private static final String PENERBIT = "penerbit";
    private static final String TAHUNTERBIT = "tahunterbit";
    private static final String SINOPSIS = "sinopsis";




    // sql untuk create table
    private static final String CREATE_TABLE =
            "CREATE TABLE "
                    + NAMA_TABEL
                    + " ("
                    + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + JUDUL + " VARCHAR(255), "
                    + PENULIS + " VARCHAR(255), "
                    + PENERBIT + " VARCHAR,"
                    + TAHUNTERBIT + " INTEGER,"
                    + SINOPSIS + " VARCHAR(255)"
                    + ");";
    //  sql untuk drop table
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS" + NAMA_TABEL;

    // custom constructor
    public MyDataHelper(Context context){
        super(context, NAMA_DB, null, VERSI_DB);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

   }
