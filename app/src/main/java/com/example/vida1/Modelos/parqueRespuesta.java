package com.example.vida1.Modelos;

import java.util.List;

public class parqueRespuesta {
    private String status;
    private String msg;
    private String error;
    private List<parque> data;

    public parqueRespuesta(String status, String msg, String error, List<parque> data) {
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

    public List<parque> getData() {
        return data;
    }

    public void setData(List<parque> data) {
        this.data = data;
    }
}
