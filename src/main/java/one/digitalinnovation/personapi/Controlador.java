package one.digitalinnovation.personapi;

import one.digitalinnovation.personapi.Exception.PersonagemNaoExiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Calendar;

@Controller
@RequestMapping("api/v1/pessoa")
public class Controlador {
    @Autowired
    private Repositorio repositorio;

    @PostMapping
    @ResponseBody
    public String adicionar(@Valid @RequestBody PessoaDTO pessoa) {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa = Mapear.INSTANCE.toPessoa(pessoa);
        repositorio.save(novaPessoa);
        return "Criado!";
    }

    @GetMapping
    @ResponseBody
    public Iterable<Pessoa> getAllUsers() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Pessoa procurarPessoa(@PathVariable Integer id) throws PersonagemNaoExiste {
        return procurarID(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String excluir(@PathVariable Integer id) throws PersonagemNaoExiste {
        procurarID(id);
        repositorio.deleteById(id);
        return "Deletado!";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String atualizar(@PathVariable Integer id, @RequestBody PessoaDTO pessoa) throws PersonagemNaoExiste {
        Pessoa novaPessoa = procurarID(id);
        novaPessoa = Mapear.INSTANCE.toPessoa(pessoa);
        repositorio.save(novaPessoa);
        return "Alterado!";
    }

    public Pessoa procurarID(Integer id) throws PersonagemNaoExiste {
        return repositorio.findById(id).orElseThrow(() -> new PersonagemNaoExiste(id));
    }

}