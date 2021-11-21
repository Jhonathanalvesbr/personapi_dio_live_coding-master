package one.digitalinnovation.personapi;

import one.digitalinnovation.personapi.Exception.PersonagemNaoExiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpConstraint;
import javax.validation.Valid;

@Controller
@RequestMapping("api/v1/pokemon")
public class Controlador {
    @Autowired
    private Repositorio repositorio;

    @PostMapping
    @ResponseBody
    public String adicionar(@Valid @RequestBody PokemonDTO pok) {
        Pokemon poke = new Pokemon();
        poke.setNome(pok.getNome());
        repositorio.save(poke);
        return "Criado!";
    }

    @GetMapping
    @ResponseBody
    public Iterable<Pokemon> getAllUsers() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Pokemon procruarPokemon(@PathVariable Integer id) throws PersonagemNaoExiste {
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
    public String atualizar(@PathVariable Integer id, @RequestBody @Valid PokemonDTO pok) throws PersonagemNaoExiste {
        Pokemon poke = procurarID(id);
        poke.setNome(pok.getNome());
        repositorio.save(poke);
        return "Alterado!";
    }

    public Pokemon procurarID(Integer id) throws PersonagemNaoExiste {
        return repositorio.findById(id).orElseThrow(() -> new PersonagemNaoExiste(id));
    }

}