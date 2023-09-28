package med.voll.api.domain.paciente.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.enderecos.dto.DtoEnderecos;

public record DtoUpdateUser(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DtoEnderecos enderecos) {
}
