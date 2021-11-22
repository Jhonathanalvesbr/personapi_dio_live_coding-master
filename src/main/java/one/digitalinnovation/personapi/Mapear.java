package one.digitalinnovation.personapi;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Mapear {
    Mapear INSTANCE = Mappers.getMapper(Mapear.class);

    Pessoa toPessoa(PessoaDTO Pessoa);
}
