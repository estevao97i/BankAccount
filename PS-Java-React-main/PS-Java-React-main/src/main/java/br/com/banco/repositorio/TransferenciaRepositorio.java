package br.com.banco.repositorio;

import br.com.banco.entidades.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransferenciaRepositorio extends JpaRepository<Transferencia,Long> {

    @Query(" Select obj FROM Transferencia obj WHERE (obj.dataTransferencia = :data) ")
    List<Transferencia> listTransferenciaDate(LocalDateTime data);

    @Query(" SELECT obj FROM Transferencia obj WHERE obj.nomeOperadorTransacao = :nomeOperadorTransacao ")
    List<Transferencia> listTransferenciaPorNomeOperadorTransacao(String nomeOperadorTransacao);

    @Query(" SELECT obj FROM Transferencia obj WHERE" +
            " obj.nomeOperadorTransacao = :nomeOperadorTransacao" +
            " AND (obj.dataTransferencia >= :dataInic AND obj.dataTransferencia <= :dataFim)")
    List<Transferencia> listTransferenciaTodosParametros(String nomeOperadorTransacao, LocalDateTime dataInic, LocalDateTime dataFim);
}
