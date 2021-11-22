package one.digitalinnovation.personapi;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private Integer id;
    private String pais, estado, cidade;
    private Integer ddd;
    private String telefone;
    private String nome;
    private LocalDate dataNascimento;
    private String logradouro, endereco;
    private Integer numeroCasa;
    private String cep, email;
}
