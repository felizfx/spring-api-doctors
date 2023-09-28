package med.voll.api.domain.medico.dto;

import med.voll.api.domain.medico.Medico;

public record DtoDadosListagemMedico (
        Long id,
        String nome,
        String email,
        String crm,
        EnumEspecialidade especialidade
) {
    public DtoDadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
