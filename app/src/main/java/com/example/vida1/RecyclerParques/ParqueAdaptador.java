package com.example.vida1.RecyclerParques;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.InformacionParque;
import com.example.vida1.Modelos.parque;
import com.example.vida1.R;

import java.util.List;

public class ParqueAdaptador extends RecyclerView.Adapter<ParqueViewHolder> {
    List<parque> parqueList;
    Context ctx;

    public ParqueAdaptador(List<parque> parqueList, Context ctx) {
        this.parqueList = parqueList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ParqueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.iconoparquelista, parent, false);
        return new ParqueViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ParqueViewHolder holder, int position) {
        parque parque = parqueList.get(position);
        holder.txtNonmbreParqueLista.setText(parque.getNombre());
        holder.txt2.setText(parque.getClickpor());

        holder.txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, InformacionParque.class);
                intent.putExtra("id", parque.getId());
                intent.putExtra("nombre",parque.getNombre());
                intent.putExtra("reglas",parque.getReglas());
                intent.putExtra("medida_largoTerreno",parque.getMedida_largoTerreno());
                intent.putExtra("medida_anchoTerreno",parque.getMedida_anchoTerreno());
                intent.putExtra("cantidad_entradas",parque.getCantidad_entradas());
                intent.putExtra("cantidad_salidas",parque.getCantidad_salidas());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return parqueList.size();
    }
}
