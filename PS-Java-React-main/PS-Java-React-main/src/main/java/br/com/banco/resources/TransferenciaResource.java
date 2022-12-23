package br.com.banco.resources;

import br.com.banco.servico.TransferenciaServico;
import br.com.banco.servico.dto.TransferenciaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "transferencias")
public class TransferenciaResource {

    private final TransferenciaServico servico;

    @GetMapping()
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<TransferenciaDto>> findall() {
        List<TransferenciaDto> listByDate = servico.findAll();

        return ResponseEntity.ok(listByDate);
    }

    @GetMapping(value = "data")
    public ResponseEntity<List<TransferenciaDto>> findByDate(@RequestParam("data") String data) {
        List<TransferenciaDto> listByDate = servico.findByDate(data);

        return ResponseEntity.ok(listByDate);
    }

    @GetMapping(value = "nome-operador")
    public ResponseEntity<List<TransferenciaDto>> findByNomeOperador(@RequestParam("nomeOperadorTransacao") String nome) {
        var listByDate = servico.findByNomeOperador(nome);

        return ResponseEntity.ok(listByDate);
    }

    @GetMapping(value = "data-operador")
    public ResponseEntity<List<TransferenciaDto>> findByNomeOperadorAndDate(@RequestParam("dataInic") String dataInicial,
                                                                            @RequestParam("dataFim") String dataFinal,
                                                                            @RequestParam("nomeOperadorTransacao") String nome) {

        List<TransferenciaDto> listByDate = servico.findByNomeOperadorAndDate(nome, dataInicial, dataFinal);

        return ResponseEntity.ok(listByDate);
    }
}
