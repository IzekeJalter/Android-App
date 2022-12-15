package com.example.vida1.Modelos;

import java.util.List;

public class ListaSensor {
    private String table;
    private List<Sensor> data;

    public ListaSensor(String table, List<Sensor> data) {
        this.table = table;
        this.data = data;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public List<Sensor> getData() {
        return data;
    }

    public void setData(List<Sensor> data) {
        this.data = data;
    }
}
