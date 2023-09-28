package med.voll.api.domain.consultas.service;

import med.voll.api.domain.consultas.Consultas;
import med.voll.api.domain.consultas.dto.DtoCadastrarConsulta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IConsultasService {

    List<Consultas> findAll();

    Consultas createConsulta(DtoCadastrarConsulta data);

}
