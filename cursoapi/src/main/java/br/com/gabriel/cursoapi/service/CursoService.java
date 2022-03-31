package br.com.gabriel.cursoapi.service;

import br.com.gabriel.cursoapi.model.Curso;
import br.com.gabriel.cursoapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodosCursos() {
        return cursoRepository.findAll();
    }
}
