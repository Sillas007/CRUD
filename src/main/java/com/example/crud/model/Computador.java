package com.example.crud.model;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("computadores")
public class Computador extends Model {

    public String getProcessador() {
        return getString("processador");
    }

    public void setProcessador(String processador) {
        set("processador", processador);
    }

    public String getRam() {
        return getString("ram");
    }

    public void setRam(String ram) {
        set("ram", ram);
    }

    public String getArmazenamento() {
        return getString("armazenamento");
    }

    public void setArmazenamento(String armazenamento) {
        set("armazenamento", armazenamento);
    }
}
