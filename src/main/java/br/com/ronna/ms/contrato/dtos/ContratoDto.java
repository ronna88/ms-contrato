package br.com.ronna.ms.contrato.dtos;

import br.com.ronna.ms.contrato.enums.StatusContrato;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ContratoDto {

    @NotBlank
    private String contratoNome;
    @NotNull
    private Double contratoValue;
    @NotNull
    private StatusContrato statusContrato;
}
