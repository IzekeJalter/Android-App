package com.example.vida1.RecyclerViewSensor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.InformacionSensor;
import com.example.vida1.Modelos.Sensor;
import com.example.vida1.R;

import java.util.List;

public class SensorAdaptador extends RecyclerView.Adapter<SensorViewHolder> {
    List<Sensor> sensorList;
    Context ctx;

    public SensorAdaptador(List<Sensor> sensorList, Context ctx) {
        this.sensorList = sensorList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public SensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.iconosensorlista, parent, false);

        return new SensorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorViewHolder holder, int position) {
        Sensor sensor = sensorList.get(position);
        holder.nombre.setText(sensor.getNombre_sensor());

        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, InformacionSensor.class);
                intent.putExtra("nombre",sensor.getNombre_sensor());
                intent.putExtra("sensor_key", sensor.getFeed_key());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sensorList.size();
    }
}
