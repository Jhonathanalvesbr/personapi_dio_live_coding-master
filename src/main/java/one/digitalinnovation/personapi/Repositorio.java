package one.digitalinnovation.personapi;

import org.springframework.data.repository.CrudRepository;
import one.digitalinnovation.personapi.Pokemon;

public interface Repositorio extends CrudRepository<Pokemon, Integer> {
}
