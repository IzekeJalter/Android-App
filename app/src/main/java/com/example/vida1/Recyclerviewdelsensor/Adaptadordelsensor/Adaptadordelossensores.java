package com.example.vida1.Recyclerviewdelsensor.Adaptadordelsensor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.InformacionSensor;
import com.example.vida1.InformacionVisitante;
import com.example.vida1.R;
import com.example.vida1.Recyclerviewdelsensor.Respuestas.sensores;

import java.util.List;

public class Adaptadordelossensores extends RecyclerView.Adapter<Adaptadordelossensores.Viewholder> {
    List<sensores> sensoresList;

     Context context;

    public Adaptadordelossensores(Context context) {
        this.context = context;
    }

    public Adaptadordelossensores(List<sensores> sensoresList) {
        this.sensoresList = sensoresList;
    }

    @NonNull
    @Override
    public Adaptadordelossensores.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.iconosensorlista, parent, false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptadordelossensores.Viewholder holder, int position) {
holder.Nombresensorfeed.setText(sensoresList.get(position).getNombre_sensor());
holder.s=sensoresList.get(position);
    }

    @Override
    public int getItemCount() {
        return sensoresList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView Nombresensorfeed,elclick;
        sensores s;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Nombresensorfeed=(TextView) itemView.findViewById(R.id.txtNonmbreSensorlista);
            elclick=(TextView) itemView.findViewById(R.id.txt2);

            elclick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Nombresensorfeed.getText()=="viyda.gas-co")
                    {

                        Intent intent = new Intent(context, InformacionSensor.class);
                        intent.putExtra("id",s.getId());
                        itemView.getContext().startActivity(intent);
                    }
                }
            });


        }
    }
}
