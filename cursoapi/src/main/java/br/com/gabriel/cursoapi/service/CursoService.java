package br.com.gabriel.cursoapi.service;

import br.com.gabriel.cursoapi.model.Curso;
import br.com.gabriel.cursoapi.repository.CursoRepository;
import br.com.gabriel.cursoapi.service.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodosCursos() {
        return cursoRepository.findAll();
    }

    public Curso findCurso(Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);

        return curso.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado!!! id: "
                        + id + " Tipo: " + Curso.class.getName()
        ));
    }

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }
}
