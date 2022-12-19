package br.com.banco.servico;

import br.com.banco.entidades.Transferencia;
import br.com.banco.repositorio.TransferenciaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class TransferenciaServico {

    private final TransferenciaRepositorio repositorio;

    public List<Transferencia> findByDate(LocalDateTime data) {
        var listTransferencia= repositorio.listTransferenciaDate(data);
        return listTransferencia;
    }

    public List<Transferencia> findByNomeOperador(String nome) {
        var listTransferencia= repositorio.listTransferenciaPorNomeOperadorTransacao(nome);
        return listTransferencia;
    }

    public List<Transferencia> findByNomeOperadorAndDate(String nome, LocalDateTime dataInic, LocalDateTime dataFim) {
        var listTransferencia= repositorio.listTransferenciaTodosParametros(nome, dataInic, dataFim);
        return listTransferencia;
    }

}
