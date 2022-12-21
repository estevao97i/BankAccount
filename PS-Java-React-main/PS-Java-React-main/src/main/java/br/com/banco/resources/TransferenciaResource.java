package br.com.banco.resources;

import br.com.banco.servico.TransferenciaServico;
import br.com.banco.servico.dto.TransferenciaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "transferencias")
public class TransferenciaResource {

    private final TransferenciaServico servico;

    @GetMapping(value = "data")
    public ResponseEntity<List<TransferenciaDto>> findByDate(@RequestParam("data") LocalDateTime data) {
        var listByDate = servico.findByDate(data);

        return ResponseEntity.ok(listByDate);
    }

    @GetMapping()
    public String oi() {
        return "oi";
    }

    @GetMapping(value = "nome-operador")
    public ResponseEntity<List<TransferenciaDto>> findByNomeOperador(@RequestParam("nomeOperadorTransacao") String nome) {
        var listByDate = servico.findByNomeOperador(nome);

        return ResponseEntity.ok(listByDate);
    }

    @GetMapping(value = "data-operador")
    public ResponseEntity<List<TransferenciaDto>> findByNomeOperadorAndDate(@RequestParam("dataInic") LocalDateTime dataInicial,
                                                                            @RequestParam("dataFim") LocalDateTime dataFinal,
                                                                            @RequestParam("nomeOperadorTransacao") String nome) {
        var listByDate = servico.findByNomeOperadorAndDate(nome, dataInicial, dataFinal);

        return ResponseEntity.ok(listByDate);
    }
}
