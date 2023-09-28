package med.voll.api.domain.consultas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.domain.consultas.dto.DtoCadastrarConsulta;

@Entity(name = "Consulta")
@Table(name = "consulta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long medicoId;
    private String tipo;

    public Consultas(DtoCadastrarConsulta data){
        this.id = null;
        this.medicoId = data.medicoId();
        this.tipo = data.tipo();
    }
}
