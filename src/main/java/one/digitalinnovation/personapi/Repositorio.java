package com.digitaloneinovation.dio;

import org.springframework.data.repository.CrudRepository;
import com.digitaloneinovation.dio.Pokemon;

public interface Repositorio extends CrudRepository<Pokemon, Integer> {
}
