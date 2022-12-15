package com.example.vida1.RecyclerVisitantes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.Modelos.Visitante;
import com.example.vida1.R;

import java.util.List;

public class VisitanteAdapter extends RecyclerView.Adapter<VisitanteViewHolder> {
    List<Visitante> visitanteList;
    Context ctx;

    public VisitanteAdapter(List<Visitante> visitanteList, Context ctx) {
        this.visitanteList = visitanteList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public VisitanteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.icnonovisitalista, parent, false);

        return new VisitanteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitanteViewHolder holder, int position) {
        Visitante visitante =visitanteList.get(position);
        holder.txtNonmbreParqueLista.setText(visitante.getNombre());
        holder.txt2.setText(visitante.getId());
    }

    @Override
    public int getItemCount() {
        return visitanteList.size();
    }
}
