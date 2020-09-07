package com.dalda.rocky.adapter;

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

import com.dalda.rocky.R;
import com.dalda.rocky.pojo.Mascota;

import java.util.ArrayList;

public class PerfilDogAdapter extends RecyclerView.Adapter<PerfilDogAdapter.PerfilDogViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;
    public Mascota mascota;

    public PerfilDogAdapter(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PerfilDogAdapter.PerfilDogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfildog, parent, false);
        return new PerfilDogAdapter.PerfilDogViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PerfilDogViewHolder holder, int position) {
        final Mascota mascotao = mascotas.get(position);
        holder.imgFoto.setImageResource(mascotao.getFoto());
        holder.tvRating.setText(mascotao.getRating() + "");
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rating = mascotao.getRating();
                mascotao.setRating( ++rating);
                holder.tvRating.setText(String.valueOf(rating));
                Toast.makeText(activity, "Diste like a " + mascotao.getNombre() + "Rating: " + mascotao.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilDogViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private ImageButton btnLike;
        private TextView tvRating;
        public PerfilDogViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFotoCVM);
            btnLike     = (ImageButton) itemView.findViewById(R.id.btnLikeCVM);
            tvRating    = (TextView) itemView.findViewById(R.id.tvRatingCVM);
        }
    }
}
