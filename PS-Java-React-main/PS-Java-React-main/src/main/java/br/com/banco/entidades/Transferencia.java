package br.com.banco.entidades;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Transferencia {

    @Id
    private Long id;

    @Column(name = "data_transferencia")
    private LocalDateTime dataTransferencia;

    private BigDecimal valor;
    private String tipo;

    @Column(name = "nome_operador_transacao")
    private String nomeOperadorTransacao;

    @ManyToOne()
    @JoinColumn(name = "id_conta")
    private Conta conta;

}
