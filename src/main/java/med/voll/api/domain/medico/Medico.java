package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.enderecos.Endereco;
import med.voll.api.domain.medico.dto.DtoCadastroMedico;
import med.voll.api.domain.medico.dto.DtoUpdateMedico;
import med.voll.api.domain.medico.dto.EnumEspecialidade;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private EnumEspecialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Medico(DtoCadastroMedico medico) {
        this.id = null;
        this.nome = medico.nome();
        this.email = medico.email();
        this.telefone = medico.telefone();
        this.crm = medico.crm();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(medico.endereco().logradouro(), medico.endereco().bairro(), medico.endereco().cep(), medico.endereco().numero(), medico.endereco().complemento(), medico.endereco().cidade(), medico.endereco().uf());
        this.ativo = true;
    }

    public void atualizarInformacoes(DtoUpdateMedico json) {
        if(json.nome() != null){
            this.nome = json.nome();
        }
        if(json.telefone() != null){
            this.telefone = json.telefone();
        }
        if(json.enderecos() != null){
            this.endereco.atualizarDados(json.enderecos());
        }
    }

    public void excluir() {
        this.setAtivo(false);
    }
}
