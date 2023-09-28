package med.voll.api.domain.enderecos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DtoEnderecos(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro, String cidade,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String uf,
        @NotBlank
        String complemento,
        String numero) {
}
