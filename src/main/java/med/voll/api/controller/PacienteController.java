package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.dto.DtoCadastrarPaciente;
import med.voll.api.domain.paciente.dto.DtoDadosListagemPaciente;
import med.voll.api.domain.paciente.dto.DtoUpdateUser;
import med.voll.api.domain.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes(){
        return ResponseEntity.ok(pacienteService.findByAtivoTrue());
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<DtoDadosListagemPaciente>> getPacienteResumo(){
        return ResponseEntity.ok(pacienteService.getPacienteResumo());
    }

    @GetMapping("/resumo/paginado")
    public ResponseEntity<Page<DtoDadosListagemPaciente>> getPaciente(Pageable paginacao){
        return ResponseEntity.ok(pacienteService.getPageable(paginacao));
    }
    @PostMapping
    @Transactional
    public ResponseEntity createPacient(@RequestBody @Valid DtoCadastrarPaciente json, UriComponentsBuilder uriBuilder){
        Paciente paciente = pacienteService.createPaciente(json);
        var uri = uriBuilder.path("/medicos/{id").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePacient(@RequestBody @Valid DtoUpdateUser json){
        var paciente = pacienteService.updatePaciente(json);
        return ResponseEntity.ok(paciente);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePaciente(@PathVariable("id") Long id){
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }
}
