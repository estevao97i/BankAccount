package br.com.banco.entidades;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Conta {

    @Id
    @Column(name = "id_conta")
    private Long id;

    private String nomeResponsavel;

    @OneToMany(mappedBy = "conta")
    private List<Transferencia> transferencias;

}
