package one.digitalinnovation.personapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Pessoa {
    @Id
    private Integer id;
    private Integer ddd;
    private String telefone;
    private String nome;
    private LocalDate dataNascimento;
    private String logradouro, endereco;
    private Integer numeroCasa;
    private String cep, email;

}

