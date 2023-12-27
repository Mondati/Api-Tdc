package com.example.tptodocode1.service;


import com.example.tptodocode1.dto.CursoTemaDTO;
import com.example.tptodocode1.entity.Curso;
import com.example.tptodocode1.entity.Tema;

import java.util.List;

public interface ICursoService {
    public List<Curso> getCursos();

    public void saveCurso(Curso curso);

    public void deleteCurso(Long id);

    public Curso findCursoByid(Long id);

    public void editCurso(Curso curso);

    public CursoTemaDTO temasPorCurso(Long id_curso);

    public List<Curso> findCursosByString();






}
