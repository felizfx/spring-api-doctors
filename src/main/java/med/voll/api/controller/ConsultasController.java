package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.consultas.dto.DtoCadastrarConsulta;
import med.voll.api.domain.consultas.service.ConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {
    @Autowired
    private ConsultasService consultasService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(consultasService.findAll());
    }

    @PostMapping
    public ResponseEntity postConsulta(@RequestBody @Valid DtoCadastrarConsulta json, UriComponentsBuilder uriBuilder){
        var consulta = consultasService.createConsulta(json);
        var uri = uriBuilder.path("/consultas/{id}").buildAndExpand(consulta.getId()).toUri();
        return ResponseEntity.created(uri).body(consulta);
    }
}
