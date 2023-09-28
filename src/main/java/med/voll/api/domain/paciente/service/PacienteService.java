package med.voll.api.domain.paciente.service;

import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.paciente.dto.DtoCadastrarPaciente;
import med.voll.api.domain.paciente.dto.DtoDadosListagemPaciente;
import med.voll.api.domain.paciente.dto.DtoUpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private PacienteRepository pacienteRepository;
    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAllByAtivoTrue();
    }

    @Override
    public List<Paciente> findByAtivoTrue() {
        return pacienteRepository.findAllByAtivoTrue();
    }

    @Override
    public List<DtoDadosListagemPaciente> getPacienteResumo() {
        return this.findByAtivoTrue().stream().map(DtoDadosListagemPaciente::new).toList();
    }

    @Override
    public Page<DtoDadosListagemPaciente> getPageable(Pageable pageable) {
        return pacienteRepository.findAll(pageable).map(DtoDadosListagemPaciente::new);
    }

    @Override
    public Paciente createPaciente(DtoCadastrarPaciente data) {
        var paciente = new Paciente(data);
        pacienteRepository.save(paciente);
        return paciente;
    }

    @Override
    public DtoDadosListagemPaciente updatePaciente(DtoUpdateUser data) {
        var paciente = pacienteRepository.getReferenceById(data.id());
        paciente.atualizarInformacoes(data);
        return new DtoDadosListagemPaciente(paciente);
    }

    @Override
    public void deletePaciente(Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }

    @Override
    public boolean verifyUserExists(Long id) {
        return pacienteRepository.existsById(id);
    }
}
