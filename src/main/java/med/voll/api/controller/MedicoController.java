package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.dto.DadosDetalhamentoMedico;
import med.voll.api.domain.medico.dto.DtoCadastroMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.dto.DtoDadosListagemMedico;
import med.voll.api.domain.medico.dto.DtoUpdateMedico;
import med.voll.api.domain.medico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity getMedicos(){
        return ResponseEntity.ok(medicoService.getAllMedics());
    }

    @GetMapping("/{id}")
    public ResponseEntity getMedicoById(@PathVariable Long id){
        return ResponseEntity.ok(medicoService.getMedicById(id));
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<DtoDadosListagemMedico>> getMedic(){
        return ResponseEntity.ok(medicoService.getAllMedicsResume());
    }

    //mandando toda a classe de Page, contendo inforamções sobre a paginação
    @GetMapping("/resumo/paginado")
    public ResponseEntity<Page<DtoDadosListagemMedico>> getPage(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pageable){
        return ResponseEntity.ok(medicoService.getPagableMedics(pageable));
    }

    //mandando apenas o conteudo (os dados do banco de dados) paginados
    @GetMapping("/resumo/paginado/content")
    public ResponseEntity<List<DtoDadosListagemMedico>> getPageContent(Pageable pageable){
        return ResponseEntity.ok(medicoService.getContentPagableMedcis(pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity createMedic(@RequestBody @Valid DtoCadastroMedico json, UriComponentsBuilder uriBuilder){
        return medicoService.createMedic(json, uriBuilder);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Object> atualizar(@RequestBody @Valid DtoUpdateMedico json){
        Medico medic = medicoService.updateMedic(json);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable("id") Long id){
        if(!medicoService.verifyUserExists(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
        }
        medicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/soft/{id}")
    @Transactional
    public ResponseEntity softDelete(@PathVariable("id") Long id){
        medicoService.softDeleteById(id);
        return ResponseEntity.noContent().build();
    }
}
