package one.digitalinnovation.personapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import one.digitalinnovation.personapi.*;

@Controller
@RequestMapping("/v1/pokemon")
public class Controlador {

    @Autowired
    private Repositorio repositorio;

    @PostMapping()
    @ResponseBody()
    public String addNewUser(@RequestParam String nome){
        Pokemon poke = new Pokemon();
        poke.setNome(nome);
        repositorio.save(poke);
        return "Saved";
    }

    /*@GetMapping()
    @ResponseBody()
    public String reposta(){
        System.out.println("TESTE");
        return "OK!";
    }*/

    @GetMapping()
    public @ResponseBody
    Iterable<Pokemon> getAllUsers() {
        return repositorio.findAll();
    }
}
