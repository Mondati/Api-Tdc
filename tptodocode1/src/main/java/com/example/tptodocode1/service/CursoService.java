package com.example.tptodocode1.service;

import com.example.tptodocode1.dto.CursoTemaDTO;
import com.example.tptodocode1.entity.Curso;
import com.example.tptodocode1.repository.ICursoRepository;
import com.example.tptodocode1.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepository;
    private ITemaRepository temaRepository;

    @Override
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public void saveCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso findCursoByid(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void editCurso(Curso curso) {
        this.cursoRepository.save(curso);
    }

    @Override
    public CursoTemaDTO temasPorCurso(Long id_curso) {
        CursoTemaDTO curTemDTO = new CursoTemaDTO();
        Curso curso = this.findCursoByid(id_curso);
        curTemDTO.setNombreCurso(curso.getNombre());
        curTemDTO.setListaTemas(curso.getListaDeTemas());
        return curTemDTO;
    }

    @Override
    public List<Curso> findCursosByString() {

        String palabra = "Java";
        String textoComparar;

        List<Curso> listaCurso = this.getCursos();
        List<Curso> listaCursosJava = new ArrayList<Curso>();

        for (Curso curso : listaCurso) {
            textoComparar = curso.getNombre();
            boolean contieneJava = textoComparar.contains(palabra);
            if (contieneJava) {
                listaCursosJava.add(curso);
            }
        }
        return listaCursosJava;
    }
}
