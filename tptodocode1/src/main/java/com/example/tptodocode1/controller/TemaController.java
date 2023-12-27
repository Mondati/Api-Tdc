package com.example.tptodocode1.controller;

import com.example.tptodocode1.entity.Tema;
import com.example.tptodocode1.service.ITemaService;
import com.example.tptodocode1.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {

    @Autowired
    private ITemaService temaServ;

    @PostMapping("/temas/crear")
    public String crearCurso(@RequestBody Tema tema) {
        temaServ.saveTema(tema);

        return "Tema creado correctamente";
    }

    @PutMapping("/tema/edit")
    public String editTema(@RequestBody Tema tema) {
        temaServ.editTema(tema);
        return "Tema editado correctamente";
    }

}
