package br.com.banco.servico;

import br.com.banco.repositorio.TransferenciaRepositorio;
import br.com.banco.servico.dto.TransferenciaDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TransferenciaServico implements Serializable {

    private final TransferenciaRepositorio repositorio;
    private final ModelMapper modelMapper;

    public List<TransferenciaDto> findByDate(LocalDateTime data) {
        var listTransferencia= repositorio.listTransferenciaDate(data);
        return listTransferencia.stream()
                .map(r -> modelMapper.map(r, TransferenciaDto.class)).collect(Collectors.toList());
    }

    public List<TransferenciaDto> findByNomeOperador(String nome) {
        var listTransferencia= repositorio.listTransferenciaPorNomeOperadorTransacao(nome);
        return listTransferencia.stream()
                .map(r -> modelMapper.map(r, TransferenciaDto.class)).collect(Collectors.toList());
    }

    public List<TransferenciaDto> findByNomeOperadorAndDate(String nome, LocalDateTime dataInic, LocalDateTime dataFim) {
        if (dataInic.isAfter(dataFim)){
            throw new RuntimeException("A data inicial deve ser anterior a data final");
        }
        var listTransferencia= repositorio.listTransferenciaTodosParametros(nome, dataInic, dataFim);
        return listTransferencia.stream().map(r ->
                modelMapper.map(r, TransferenciaDto.class)).collect(Collectors.toList());
    }

}
