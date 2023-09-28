package med.voll.api.domain.paciente.dto;

import med.voll.api.domain.enderecos.Endereco;
import med.voll.api.domain.paciente.Paciente;

public record DtoDadosListagemPaciente(
        Long id,
        String nome,
        String cpf,
        Endereco enderecos) {
    public DtoDadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEndereco());
    }
}
