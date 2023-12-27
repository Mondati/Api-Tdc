package com.example.tptodocode1.controller;

import com.example.tptodocode1.dto.CursoTemaDTO;
import com.example.tptodocode1.entity.Curso;
import com.example.tptodocode1.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("curso/crear")
    public ResponseEntity<String> saveCurso(@RequestBody Curso curso) {
        cursoService.saveCurso(curso);
        return new ResponseEntity<>("Curso creado con éxito", HttpStatus.OK);
    }

    @GetMapping ("/cursos/traer")
    @ResponseBody
    public List<Curso> traerCursos () {
        return cursoService.getCursos();
    }

    @GetMapping ("/cursos/temas/{id_curso}")
    @ResponseBody
    public CursoTemaDTO temasPorCurso (@PathVariable Long id_curso) {
        return cursoService.temasPorCurso(id_curso);
    }

    @GetMapping("/cursos/id")
    public Curso findCurso(@RequestParam Long id) {
        return cursoService.findCursoByid(id);
    }

    @GetMapping ("/cursos/java")
    @ResponseBody
    public List<Curso> getCursosJava () {
        return cursoService.findCursosByString();
    }

    @PutMapping("/curso/edit")
    public String editCurso(@RequestBody Curso curso) {
        cursoService.editCurso(curso);
        return "Curso editado correctamente";
    }
}
