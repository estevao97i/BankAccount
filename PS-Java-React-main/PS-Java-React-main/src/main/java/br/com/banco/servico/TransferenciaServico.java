package br.com.banco.servico;

import br.com.banco.repositorio.TransferenciaRepositorio;
import br.com.banco.servico.dto.TransferenciaDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TransferenciaServico implements Serializable {

    private final TransferenciaRepositorio repositorio;
    private final ModelMapper modelMapper;

    public List<TransferenciaDto> findAll() {
        var listTransferencia= repositorio.findAll();
        return listTransferencia.stream()
                .map(r -> modelMapper.map(r, TransferenciaDto.class)).collect(Collectors.toList());
    }

    public List<TransferenciaDto> findByDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss"));
        var dateTime = LocalDateTime.parse(data, formatter);
        var listTransferencia= repositorio.listTransferenciaDate(dateTime);
        return listTransferencia.stream()
                .map(r -> modelMapper.map(r, TransferenciaDto.class)).collect(Collectors.toList());
    }

    public List<TransferenciaDto> findByNomeOperador(String nome) {
        var listTransferencia= repositorio.listTransferenciaPorNomeOperadorTransacao(nome);
        return listTransferencia.stream()
                .map(r -> modelMapper.map(r, TransferenciaDto.class)).collect(Collectors.toList());
    }

    public List<TransferenciaDto> findByNomeOperadorAndDate(String nome, String dataInicial, String dataFinal) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyy-MM-dd HH:mm:ss"));
        var dataInic = LocalDateTime.parse(dataInicial, formatter);
        var dataFim = LocalDateTime.parse(dataFinal, formatter);
        if (dataInic.isAfter(dataFim)){
            throw new RuntimeException("A data inicial deve ser anterior a data final");
        }
        var listTransferencia= repositorio.listTransferenciaTodosParametros(nome, dataInic, dataFim);
        return listTransferencia.stream().map(r ->
                modelMapper.map(r, TransferenciaDto.class)).collect(Collectors.toList());
    }

}
