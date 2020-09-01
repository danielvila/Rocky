package com.dalda.rocky;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    public Mascota mascota;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascotao = mascotas.get(position);
        holder.imgFoto.setImageResource(mascotao.getFoto());
        holder.tvNombreCV.setText(mascotao.getNombre());
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rating = mascotao.getRating();
                mascotao.setRating( rating + 1);
                holder.tvRating.setText(mascotao.getRating() + "");
                Toast.makeText(activity, "Diste like a " + mascotao.getNombre() + "Rating: " + mascotao.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLike;
        private TextView tvRating;
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFotoCVM);
            tvNombreCV  = (TextView)  itemView.findViewById(R.id.tvNombreCVM);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLikeCVM);
            tvRating    = (TextView) itemView.findViewById(R.id.tvRatingCVM);
        }
    }
}
