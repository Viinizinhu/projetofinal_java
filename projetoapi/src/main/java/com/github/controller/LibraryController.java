package com.github.controller;

import com.github.model.ModeloPersonagem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LibraryController {

    private List<ModeloPersonagem> lista = new ArrayList<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);

    }

    @GetMapping()
    public List<ModeloPersonagem> getAll(){
        return lista;
    }

    @GetMapping("/name")
    public ModeloPersonagem getPersonagemByName(@RequestParam String name){
        for (ModeloPersonagem modeloPersonagem: this.lista){
            if(modeloPersonagem.getName().equals(name))
                return modeloPersonagem;
        }
        return null;
    }


    @PostMapping("/save")
    public ModeloPersonagem save(@RequestBody ModeloPersonagem ModeloPersonagem){
        this.lista.add(ModeloPersonagem);
        return ModeloPersonagem;
    }

}
