package med.voll.api.domain.medico.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.enderecos.dto.DtoEnderecos;

public record DtoUpdateMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DtoEnderecos enderecos) {
}
