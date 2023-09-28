package med.voll.api.domain.medico.dto;

import med.voll.api.domain.enderecos.Endereco;
import med.voll.api.domain.medico.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, EnumEspecialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
