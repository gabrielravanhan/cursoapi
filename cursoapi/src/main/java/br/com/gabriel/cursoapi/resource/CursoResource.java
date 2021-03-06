package br.com.gabriel.cursoapi.resource;

import br.com.gabriel.cursoapi.model.Curso;
import br.com.gabriel.cursoapi.repository.CursoRepository;
import br.com.gabriel.cursoapi.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/todos")
    public List<Curso> listarTodosCursos() {
        return cursoService.listarTodosCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPeloId(@PathVariable Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.isPresent() ? ResponseEntity.ok(curso.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        cursoRepository.deleteById(id);
    }

    @PostMapping()
    public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
        Curso cursoSalvo = cursoService.salvar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
    }
}
