package med.voll.api.domain.user.dto;

import jakarta.validation.constraints.NotEmpty;

public record DtoDadosAuthUser(
        @NotEmpty
        String login,
        @NotEmpty
        String password) {
}
