package com.example.vida1.Modelos;

import java.util.List;

public class ListaVisitante {
    private String status;
    private String msg;
    private String error;
    private List<Visitante> data;

    public ListaVisitante(String status, String msg, String error, List<Visitante> data) {
        this.status = status;
        this.msg = msg;
        this.error = error;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Visitante> getData() {
        return data;
    }

    public void setData(List<Visitante> data) {
        this.data = data;
    }
}
