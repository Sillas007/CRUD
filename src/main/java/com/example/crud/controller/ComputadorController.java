package com.example.crud.controller;

import com.example.crud.model.Computador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/computadores")
public class ComputadorController {

    @GetMapping
    public String listarComputadores(Model model) {
        List<Computador> computadores = new ArrayList<>(Computador.findAll());
        model.addAttribute("computadores", computadores);
        return "computadores/lista";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        model.addAttribute("computador", new Computador());
        return "computadores/form";
    }

    @PostMapping("/salvar")
    public String salvarComputador(@RequestParam(required = false) String id,
                                   @RequestParam String processador,
                                   @RequestParam String ram,
                                   @RequestParam String armazenamento) {
        if (id == null || id.isBlank()) {
            Computador computador = new Computador();
            computador.setProcessador(processador);
            computador.setRam(ram);
            computador.setArmazenamento(armazenamento);
            computador.saveIt();
        } else {
            Computador computador = Computador.findById(Integer.parseInt(id));
            if (computador != null) {
                computador.setProcessador(processador);
                computador.setRam(ram);
                computador.setArmazenamento(armazenamento);
                computador.saveIt();
            }
        }
        return "redirect:/computadores";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Integer id, Model model) {
        Computador computadorEncontrado = Computador.findById(id);
        if (computadorEncontrado != null) {
            model.addAttribute("computador", computadorEncontrado);
            return "computadores/form";
        }
        return "redirect:/computadores";
    }

    @GetMapping("/deletar/{id}")
    public String deletarComputador(@PathVariable Integer id) {
        Computador computador = Computador.findById(id);
        if (computador != null) {
            computador.delete();
        }
        return "redirect:/computadores";
    }
}
