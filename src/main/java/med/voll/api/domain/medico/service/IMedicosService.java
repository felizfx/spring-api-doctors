package med.voll.api.domain.medico.service;



import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.dto.DtoCadastroMedico;
import med.voll.api.domain.medico.dto.DtoDadosListagemMedico;
import med.voll.api.domain.medico.dto.DtoUpdateMedico;
import org.hibernate.engine.spi.Resolution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface IMedicosService {
   List<Medico> getAllMedics();

   List<DtoDadosListagemMedico> getAllMedicsResume();

   Page<DtoDadosListagemMedico> getPagableMedics(Pageable pageable);

   List<DtoDadosListagemMedico> getContentPagableMedcis(Pageable pageable);

   ResponseEntity createMedic(DtoCadastroMedico data, UriComponentsBuilder uriBuilder);

   Medico updateMedic(DtoUpdateMedico data);

   void deleteById(Long id);

   void softDeleteById(Long id);

   boolean verifyUserExists(Long id);

   DtoDadosListagemMedico getMedicById(Long id);
}
