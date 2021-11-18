package br.com.ronna.ms.contrato.models;

import br.com.ronna.ms.contrato.enums.StatusContrato;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_CONTRATO")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ContratoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contratoId;
    private String contratoNome;
    private Double contratoValue;
    private StatusContrato statusContrato;
    private LocalDateTime contratoCreated;
    private LocalDateTime contratoUpdated;
}
