package med.voll.api.domain.consultas.service;

import med.voll.api.domain.consultas.Consultas;
import med.voll.api.domain.consultas.ConsultasRespository;
import med.voll.api.domain.consultas.dto.DtoCadastrarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultasService implements IConsultasService{

    @Autowired
    private ConsultasRespository consultasRepository;
    @Override
    public List<Consultas> findAll() {
        return consultasRepository.findAll();
    }

    @Override
    public Consultas createConsulta(DtoCadastrarConsulta json) {
        var consulta = new Consultas(json);
        consultasRepository.save(consulta);
        return consulta;
    }
}
