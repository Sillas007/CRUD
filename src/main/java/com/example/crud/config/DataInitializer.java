package com.example.crud.config;

import org.javalite.activejdbc.Base;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ligar à base de dados SQLite...");
        try {
            Base.open("org.sqlite.JDBC", "jdbc:sqlite:concessionaria.db", "", "");

            String sqlCarros = "CREATE TABLE IF NOT EXISTS carros (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "modelo VARCHAR(100), " +
                    "ano INTEGER, " +
                    "faixa_preco VARCHAR(100))";
            Base.exec(sqlCarros);

            String sqlComputadores = "CREATE TABLE IF NOT EXISTS computadores (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "processador VARCHAR(100), " +
                    "ram VARCHAR(50), " +
                    "armazenamento VARCHAR(100))";
            Base.exec(sqlComputadores);

            System.out.println("Tabelas criadas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Base.close();
            System.out.println("Ligação encerrada.");
        }
    }
}
