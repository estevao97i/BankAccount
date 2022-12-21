package br.com.banco.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaDto implements Serializable {

    private LocalDateTime dataTransferencia;
    private String nomeOperadorTransacao;
    private String tipo;
    private BigDecimal valor;

}
