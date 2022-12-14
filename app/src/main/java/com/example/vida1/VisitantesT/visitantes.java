package com.example.vida1.VisitantesT;

import java.util.List;

public class visitantes {
    private int status;
    private String msg;
    private String error;
    private List<data> datas;

    public visitantes(int status, String msg, String error, List<data> datas) {
        this.status = status;
        this.msg = msg;
        this.error = error;
        this.datas = datas;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public List<data> getDatas() {
        return datas;
    }

    public void setDatas(List<data> datas) {
        this.datas = datas;
    }
}
