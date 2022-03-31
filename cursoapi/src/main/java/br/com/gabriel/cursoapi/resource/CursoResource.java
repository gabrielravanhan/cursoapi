package br.com.gabriel.cursoapi.resource;

import br.com.gabriel.cursoapi.model.Curso;
import br.com.gabriel.cursoapi.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/todos")
    public List<Curso> listarTodosCursos() {
        return cursoService.listarTodosCursos();
    }
}
