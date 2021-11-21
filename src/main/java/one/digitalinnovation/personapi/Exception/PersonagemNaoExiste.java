package one.digitalinnovation.personapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonagemNaoExiste extends Exception {
    public PersonagemNaoExiste(Integer id) {
        super("Personagem não encontrado com esse id: " + id);
    }
}
