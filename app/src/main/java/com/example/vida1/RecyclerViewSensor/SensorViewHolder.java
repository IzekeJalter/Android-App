package com.example.vida1.RecyclerViewSensor;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.R;

public class SensorViewHolder extends RecyclerView.ViewHolder {
    TextView nombre;

    public SensorViewHolder(@NonNull View v) {
        super(v);
        nombre = v.findViewById(R.id.txtNonmbreSensorlista);
    }
}
