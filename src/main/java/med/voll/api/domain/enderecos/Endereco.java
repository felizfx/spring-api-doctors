package med.voll.api.domain.enderecos;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.domain.enderecos.dto.DtoEnderecos;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public void atualizarDados(DtoEnderecos json) {
        if(json.logradouro() != null){
            this.logradouro = json.logradouro();
        }
        if(json.bairro() != null){
            this.bairro = json.bairro();
        }
        if(json.cep() != null){
            this.cep = json.cep();
        }
        if(json.numero() != null){
            this.numero = json.numero();
        }
        if(json.complemento() != null){
            this.complemento = json.complemento();
        }
        if(json.cidade() != null){
            this.cidade = json.cidade();
        }
        if(json.uf() != null){
            this.uf = json.uf();
        }

    }
}
