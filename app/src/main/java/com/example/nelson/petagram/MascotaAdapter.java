package com.example.nelson.petagram;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nelson on 5/14/2016.
 */
public class MascotaAdapter extends  RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    /* Constructor de la clase */
    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity)
    {
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Le da vida a nuestro layout.. Asocia el layout al recycler view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvTotalLikeCV.setText(String.valueOf(mascota.getTotalLikes()));
        holder.imgFotoCV.setImageResource(mascota.getFoto());

        holder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor = mascota.getTotalLikes()+1;
                mascota.setTotalLikes(valor);
                Toast.makeText(activity, String.valueOf(valor), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mascotas.size();
    }

    ///La clase view holder
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvTotalLikeCV;
        private ImageButton btnLikeCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV        = (ImageView) itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV       = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTotalLikeCV    = (TextView) itemView.findViewById(R.id.tvTotalLikeCV);
            btnLikeCV        = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
        }
    }

}
