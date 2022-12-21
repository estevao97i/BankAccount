package br.com.banco.servico.mapper;


import br.com.banco.entidades.Transferencia;
import br.com.banco.servico.dto.TransferenciaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransferenciaMapper extends EntityMapper<TransferenciaDto, Transferencia> {
}
