package com.example.crud.controller;

import com.example.crud.model.Carro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carros")
public class CarroController {

    @GetMapping
    public String listarCarros(Model model) {
        List<Carro> carros = new ArrayList<>(Carro.findAll());
        model.addAttribute("carros", carros);
        return "carros/lista";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        model.addAttribute("carro", new Carro());
        return "carros/form";
    }

    @PostMapping("/salvar")
    public String salvarCarro(@RequestParam(required = false) String id,
                              @RequestParam String modelo,
                              @RequestParam Integer ano,
                              @RequestParam String faixaPreco) {
        if (id == null || id.isBlank()) {
            Carro carro = new Carro();
            carro.setModelo(modelo);
            carro.setAno(ano);
            carro.setFaixaPreco(faixaPreco);
            carro.saveIt();
        } else {
            Carro carro = Carro.findById(Integer.parseInt(id));
            if (carro != null) {
                carro.setModelo(modelo);
                carro.setAno(ano);
                carro.setFaixaPreco(faixaPreco);
                carro.saveIt();
            }
        }
        return "redirect:/carros";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Integer id, Model model) {
        Carro carroEncontrado = Carro.findById(id);
        if (carroEncontrado != null) {
            model.addAttribute("carro", carroEncontrado);
            return "carros/form";
        }
        return "redirect:/carros";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCarro(@PathVariable Integer id) {
        Carro carro = Carro.findById(id);
        if (carro != null) {
            carro.delete();
        }
        return "redirect:/carros";
    }
}
