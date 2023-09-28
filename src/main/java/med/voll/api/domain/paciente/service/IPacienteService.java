package med.voll.api.domain.paciente.service;

import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.dto.DtoCadastrarPaciente;
import med.voll.api.domain.paciente.dto.DtoDadosListagemPaciente;
import med.voll.api.domain.paciente.dto.DtoUpdateUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPacienteService {

    List<Paciente> findAll();

    List<Paciente> findByAtivoTrue();

    List<DtoDadosListagemPaciente> getPacienteResumo();

    Page<DtoDadosListagemPaciente> getPageable(Pageable pageable);

    Paciente createPaciente(DtoCadastrarPaciente data);

    DtoDadosListagemPaciente updatePaciente(DtoUpdateUser data);

    void deletePaciente(Long id);

    boolean verifyUserExists(Long id);
}
