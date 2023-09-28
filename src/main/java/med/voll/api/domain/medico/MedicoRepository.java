package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

//    @Query(nativeQuery = true,value = "select * from Transaction a where a.tipo_transacao = :tipoTransacao")
//    List<Transaction> findAllByTipo__transacao(@Param("tipoTransacao") String tipoTrasancao);
}
