package br.com.banco.Entidades;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dados;
    private BigDecimal valentia;
    private TipoConta tipo;

    @OneToMany
    private List<Pessoa> clientes;

    private BigDecimal saldo;

}
