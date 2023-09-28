package med.voll.api.domain.consultas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DtoCadastrarConsulta(
        @NotNull
        Long medicoId,
        @NotEmpty
        String tipo

) {
}
