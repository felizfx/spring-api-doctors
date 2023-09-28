package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.enderecos.Endereco;
import med.voll.api.domain.paciente.dto.DtoCadastrarPaciente;
import med.voll.api.domain.paciente.dto.DtoUpdateUser;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private boolean ativo;

    @Embedded
    private Endereco endereco;

    public Paciente(DtoCadastrarPaciente paciente){
        this.id = null;
        this.nome = paciente.nome();
        this.email = paciente.email();
        this.cpf = paciente.cpf();
        this.telefone = paciente.telefone();
        this.endereco = new Endereco(paciente.endereco().logradouro(), paciente.endereco().bairro(), paciente.endereco().cep(), paciente.endereco().numero(), paciente.endereco().complemento(), paciente.endereco().cidade(), paciente.endereco().uf());
        this.ativo = true;
    }

    public void atualizarInformacoes(DtoUpdateUser json) {
        if(json.nome() != null){
            this.nome = json.nome();
        }
        if(json.telefone() != null){
            this.telefone = json.telefone();
        }
        if(json.email() != null){
            this.email = json.email();
        }
        if(json.enderecos() != null){
            this.endereco.atualizarDados(json.enderecos());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
