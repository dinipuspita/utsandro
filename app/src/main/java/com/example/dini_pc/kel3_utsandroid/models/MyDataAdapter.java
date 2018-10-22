package com.example.dini_pc.kel3_utsandroid.models;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dini_pc.kel3_utsandroid.R;

import java.nio.IntBuffer;
import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.ViewHolder>{
    public List<MyData> myData;
    public MyDataAdapter(List<MyData> myDatas) {
        this.myData = myDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_data,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IntBuffer myDatas;
        MyData data = myData.get(position);
        holder.id.setText(data.getId());
        holder.judul.setText(data.getJudul());
        holder.penulis.setText(data.getPenulis());
        holder.penerbit.setText(data.getPenerbit());
        holder.tahunterbit.setText(data.getTahunterbit());
        holder.sinopsis.setText(data.getSinopsis());
        holder.gambar.setImageResource(data.getGambar());

    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id, judul, penulis, penerbit, tahunterbit, sinopsis;
        public ImageView gambar;
        public Button button;

        public ViewHolder(View itemview){
            super(itemview);
            id = (TextView) itemview.findViewById(R.id.id);
            judul = (TextView) itemview.findViewById(R.id.judul);
            penulis = (TextView) itemview.findViewById(R.id.penulis);
            penerbit = (TextView) itemview.findViewById(R.id.penerbit);
            tahunterbit = (TextView) itemview.findViewById(R.id.tahunterbit);
            sinopsis = (TextView) itemview.findViewById(R.id.sinopsis);
            gambar = (ImageView) itemview.findViewById(R.id.gambar);

        }

    }
}
