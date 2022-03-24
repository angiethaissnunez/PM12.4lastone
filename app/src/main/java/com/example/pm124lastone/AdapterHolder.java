package com.example.pm124lastone;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterHolder extends RecyclerView.Adapter<AdapterHolder.MyViewHolder> {

    ArrayList<Descripcion> desc;


    public AdapterHolder(ArrayList<Descripcion> sign){
        this.desc = sign;
    }

    @NonNull
    @Override
    public AdapterHolder.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType){

        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.activity_test,
                parent,
                false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder.MyViewHolder holder, final int position) {

        holder.show(desc.get(position));
    }

    @Override
    public int getItemCount() {
        return desc.size();
    }

    private static Bitmap getSignaturessImage(String encodedImage){
        byte[] bytes = android.util.Base64.decode(encodedImage, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewIcon;

        TextView textViewName;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);

            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);


        }

        void show(Descripcion firm){
            textViewName.setText(firm.getDescripcion());
            imageViewIcon.setImageBitmap(getSignaturessImage(firm.getImagen()));
        }
    }

}




