package com.example.crud.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("carros")
public class Carro extends Model {

    public String getModelo() {
        return getString("modelo");
    }

    public void setModelo(String modelo) {
        set("modelo", modelo);
    }

    public Integer getAno() {
        return getInteger("ano");
    }

    public void setAno(Integer ano) {
        set("ano", ano);
    }

    public String getFaixaPreco() {
        return getString("faixa_preco");
    }

    public void setFaixaPreco(String faixaPreco) {
        set("faixa_preco", faixaPreco);
    }
}
