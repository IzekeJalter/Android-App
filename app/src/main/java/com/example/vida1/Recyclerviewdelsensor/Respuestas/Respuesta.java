package com.example.vida1.Recyclerviewdelsensor.Respuestas;

import  com.example.vida1.Recyclerviewdelsensor.Respuestas.sensores;

import java.util.List;

public class Respuesta {
    private String tabla;
    private  List<sensores> data;

    public Respuesta(String tabla, List<sensores> data) {
        this.tabla = tabla;
        this.data = data;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public List<sensores> getData() {
        return data;
    }

    public void setData(List<sensores> data) {
        this.data = data;
    }
}
