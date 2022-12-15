package com.example.vida1.Modelos;

public class Sensor {
    private String id;
    private String nombre_sensor;
    private String feed_key;
    private String informacion;
    private String status;
    private String created_at;
    private String updated_at;

    public Sensor(String id, String nombre_sensor, String feed_key, String informacion, String status, String created_at, String updated_at) {
        this.id = id;
        this.nombre_sensor = nombre_sensor;
        this.feed_key = feed_key;
        this.informacion = informacion;
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

    public String getNombre_sensor() {
        return nombre_sensor;
    }

    public void setNombre_sensor(String nombre_sensor) {
        this.nombre_sensor = nombre_sensor;
    }

    public String getFeed_key() {
        return feed_key;
    }

    public void setFeed_key(String feed_key) {
        this.feed_key = feed_key;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
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
}
