package med.voll.api.domain.medico.service;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.medico.dto.DtoCadastroMedico;
import med.voll.api.domain.medico.dto.DtoDadosListagemMedico;
import med.voll.api.domain.medico.dto.DtoUpdateMedico;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.util.UriComponentsBuilder;


import java.sql.SQLException;
import java.util.List;

@Service
public class MedicoService implements IMedicosService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> getAllMedics() {
        return medicoRepository.findAll();
    }

    @Override
    public List<DtoDadosListagemMedico> getAllMedicsResume() {
    //        medicoRepository.findAll().stream().map(x -> {
    //        return x.getEspecialidade().getClass().getName();
    //    }).forEach(System.out::println);
        return medicoRepository.findAll().stream().map(DtoDadosListagemMedico::new).toList();
    }

    @Override
    public Page<DtoDadosListagemMedico> getPagableMedics(Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(DtoDadosListagemMedico::new);
    }

    @Override
    public List<DtoDadosListagemMedico> getContentPagableMedcis(Pageable pageable) {
        return medicoRepository.findAll(pageable).map(DtoDadosListagemMedico::new).getContent();
    }

    @Override
    public ResponseEntity createMedic(DtoCadastroMedico data, UriComponentsBuilder uriBuilder) {
        var medic = new Medico(data);
        System.out.println("chegou");
        medicoRepository.save(medic);
        var uri = uriBuilder.path("/medico/{id}").buildAndExpand(medic.getId()).toUri();
        return ResponseEntity.created(uri).body(medic);

    }


    @Override
    public Medico updateMedic(DtoUpdateMedico data) {
        var medico = medicoRepository.getReferenceById(data.id());
        medico.atualizarInformacoes(data);
        return medico;
    }

    @Override
    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public void softDeleteById(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
    }

    @Override
    public boolean verifyUserExists(Long id) {
        return medicoRepository.existsById(id);
    }

    @Override
    public DtoDadosListagemMedico getMedicById(Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return new DtoDadosListagemMedico(medico);
    }

}
