package br.com.banco.servico;

import br.com.banco.repositorio.TransferenciaRepositorio;
import br.com.banco.servico.dto.TransferenciaDto;
import br.com.banco.servico.mapper.TransferenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TransferenciaServico implements Serializable {

    private final TransferenciaRepositorio repositorio;
    private final TransferenciaMapper mapper;

    public List<TransferenciaDto> findByDate(LocalDateTime data) {
        var listTransferencia= repositorio.listTransferenciaDate(data);
        return mapper.toDto(listTransferencia);
    }

    public List<TransferenciaDto> findByNomeOperador(String nome) {
        var listTransferencia= repositorio.listTransferenciaPorNomeOperadorTransacao(nome);
        return mapper.toDto(listTransferencia);
    }

    public List<TransferenciaDto> findByNomeOperadorAndDate(String nome, LocalDateTime dataInic, LocalDateTime dataFim) {
        if (dataInic.isAfter(dataFim)){
            throw new RuntimeException("A data inicial deve ser anterior a data final");
        }
        var listTransferencia= repositorio.listTransferenciaTodosParametros(nome, dataInic, dataFim);
        return mapper.toDto(listTransferencia);
    }

}
