package com.example.vida1.RecyclerVisitantes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vida1.R;

public class VisitanteViewHolder extends RecyclerView.ViewHolder {
    TextView txtNombreVisitanteLista, txt2;

    public VisitanteViewHolder(@NonNull View v) {
        super(v);

        txtNombreVisitanteLista = v.findViewById(R.id.txtNombreVisitanteLista);
        txt2 = v.findViewById(R.id.txt2);
    }
}
