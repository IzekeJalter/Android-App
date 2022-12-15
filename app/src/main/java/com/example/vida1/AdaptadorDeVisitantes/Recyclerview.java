package com.example.vida1.AdaptadorDeVisitantes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.R;
import com.example.vida1.VisitantesT.data;

import java.util.List;

public class Recyclerview extends RecyclerView.Adapter<Recyclerview.ViewHolder> {

    private List<data> datasss;

    public Recyclerview(List<data>datasss)
    {
        this.datasss = datasss;
    }

    @NonNull
    @Override
    public Recyclerview.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewvisitantes,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerview.ViewHolder holder, int position) {
    holder.setData(datasss.get(position));

    }

    @Override
    public int getItemCount() {
        return datasss.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre_user,apellidos,edad,email_user,ids,telefonon,numerodetarjeta;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre_user=(TextView)itemView.findViewById(R.id.use_lista_visitante);
            apellidos=(TextView)itemView.findViewById(R.id.use_lista_visitante1);
            edad=(TextView)itemView.findViewById(R.id.use_lista_visitante2);
            email_user=(TextView)itemView.findViewById(R.id.use_lista_visitante3);
            telefonon=(TextView) itemView.findViewById(R.id.use_lista_visitante4);
            numerodetarjeta=(TextView)itemView.findViewById(R.id.use_lista_visitante5);
        }

        public void setData(data data) {
            nombre_user.setText(data.getNombre());
            apellidos.setText(data.getApellidos());
            edad.setText(data.getEdad());
            email_user.setText(data.getEmail());
            telefonon.setText(data.getTelefono());
            numerodetarjeta.setText(data.getNumero_tarjeta());
        }
    }
}
