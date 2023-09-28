package med.voll.api.domain.paciente.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.enderecos.dto.DtoEnderecos;

public record DtoCadastrarPaciente(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone,
        @NotNull
        @Valid
        DtoEnderecos endereco) {
}
