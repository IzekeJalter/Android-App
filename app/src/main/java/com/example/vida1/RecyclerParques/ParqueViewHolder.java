package com.example.vida1.RecyclerParques;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.R;

public class ParqueViewHolder extends RecyclerView.ViewHolder {
    TextView txtNonmbreParqueLista, txt2;

    public ParqueViewHolder(@NonNull View v) {
        super(v);
        txtNonmbreParqueLista = v.findViewById(R.id.txtNonmbreParqueLista);
        txt2 = v.findViewById(R.id.txt2);
    }
}
