package com.example.tptodocode1.service;

import com.example.tptodocode1.entity.Tema;
import com.example.tptodocode1.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemaService implements ITemaService {

    @Autowired
    private ITemaRepository temaRepository;


    @Override
    public List<Tema> getTemas() {
       return temaRepository.findAll();
    }

    @Override
    public void saveTema(Tema tema) {
        temaRepository.save(tema);
    }

    @Override
    public void deleteTema(Long id) {
        temaRepository.deleteById(id);
    }

    @Override
    public Tema findTema(Long id) {
        return temaRepository.findById(id).orElse(null);
    }

    @Override
    public void editTema(Tema tema) {
        this.temaRepository.save(tema);
    }
}

