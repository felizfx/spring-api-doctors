package med.voll.api.domain.medico.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.enderecos.dto.DtoEnderecos;

public record DtoCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp =  "\\d{4,6}")
        String crm,

        @NotNull
        EnumEspecialidade especialidade,
        @NotNull
        @Valid
        DtoEnderecos endereco){
}