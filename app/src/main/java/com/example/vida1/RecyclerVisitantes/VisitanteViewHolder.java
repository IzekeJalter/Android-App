package com.example.vida1.RecyclerVisitantes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.R;

public class VisitanteViewHolder extends RecyclerView.ViewHolder {
    TextView txtNonmbreParqueLista, txt2;

    public VisitanteViewHolder(@NonNull View v) {
        super(v);

        txtNonmbreParqueLista = v.findViewById(R.id.txtNonmbreParqueLista);
        txt2 = v.findViewById(R.id.txt2);//id
    }
}
