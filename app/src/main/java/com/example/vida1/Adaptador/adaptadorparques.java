package com.example.vida1.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.Modelos.parque;
import com.example.vida1.R;

import java.util.ArrayList;
import java.util.List;

public class adaptadorparques extends RecyclerView.Adapter<adaptadorparques.ViewHolder> {
    private List<parque> parquelis;
    private Context context;
    final adaptadorparques.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(parque item);
    }

    public adaptadorparques(Context context, OnItemClickListener listener){
        this.context = context;
        this.listener = listener;
        parquelis = new ArrayList<>();
    }
    public adaptadorparques(List<parque> parque1,adaptadorparques.OnItemClickListener listener){
        this.parquelis = parque1;
        this.listener = listener;
    }


    @NonNull
    @Override
    public adaptadorparques.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.iconoparquelista,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptadorparques.ViewHolder holder,final int position) {
        holder.setData(parquelis.get(position));
        parque p = parquelis.get(position);


    }

    @Override
    public int getItemCount() {
        return parquelis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;

        ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtNonmbreParqueLista);

        }
        public void setData(parque item) {
            nombre.setText(item.getNombre());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
