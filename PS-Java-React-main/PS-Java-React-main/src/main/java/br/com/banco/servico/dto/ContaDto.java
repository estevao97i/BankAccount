package br.com.banco.servico.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ContaDto implements Serializable {

    private Long id;
    private String nomeResponsavel;
}
