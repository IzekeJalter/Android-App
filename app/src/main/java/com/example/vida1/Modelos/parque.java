package com.example.vida1.Modelos;

import java.io.Serializable;

public class parque implements Serializable {
    private String id;
    private String nombre;
    private String dueño_id;
    private String reglas;
    private String medida_largoTerreno;
    private String medida_anchoTerreno;
    private String cantidad_entradas;
    private String cantidad_salidas;
    private String status;
    private String created_at;
    private String updated_at;

    public parque(String id, String nombre, String dueño_id, String reglas, String medida_largoTerreno, String medida_anchoTerreno, String cantidad_entradas, String cantidad_salidas, String status, String created_at, String updated_at) {
        this.id = id;
        this.nombre = nombre;
        this.dueño_id = dueño_id;
        this.reglas = reglas;
        this.medida_largoTerreno = medida_largoTerreno;
        this.medida_anchoTerreno = medida_anchoTerreno;
        this.cantidad_entradas = cantidad_entradas;
        this.cantidad_salidas = cantidad_salidas;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDueño_id() {
        return dueño_id;
    }

    public void setDueño_id(String dueño_id) {
        this.dueño_id = dueño_id;
    }

    public String getReglas() {
        return reglas;
    }

    public void setReglas(String reglas) {
        this.reglas = reglas;
    }

    public String getMedida_largoTerreno() {
        return medida_largoTerreno;
    }

    public void setMedida_largoTerreno(String medida_largoTerreno) {
        this.medida_largoTerreno = medida_largoTerreno;
    }

    public String getMedida_anchoTerreno() {
        return medida_anchoTerreno;
    }

    public void setMedida_anchoTerreno(String medida_anchoTerreno) {
        this.medida_anchoTerreno = medida_anchoTerreno;
    }

    public String getCantidad_entradas() {
        return cantidad_entradas;
    }

    public void setCantidad_entradas(String cantidad_entradas) {
        this.cantidad_entradas = cantidad_entradas;
    }

    public String getCantidad_salidas() {
        return cantidad_salidas;
    }

    public void setCantidad_salidas(String cantidad_salidas) {
        this.cantidad_salidas = cantidad_salidas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getClickpor(){
        return "Click para ver informacion.";
    }
}
