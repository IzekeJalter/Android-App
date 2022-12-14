package com.example.vida1.Modelos;

import java.util.List;

public class parqueRespuesta {
    private List<parque> results;

    public parqueRespuesta(List<parque>results){
        this.results= results;
    }

    public List<parque> getResults() {
        return results;
    }

    public void setResults(List<parque> results) {
        this.results = results;
    }
}
