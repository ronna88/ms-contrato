package br.com.ronna.ms.contrato.repositories;

import br.com.ronna.ms.contrato.models.ContratoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<ContratoModel, Long> {
}
