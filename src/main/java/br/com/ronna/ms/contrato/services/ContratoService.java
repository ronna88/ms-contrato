package br.com.ronna.ms.contrato.services;

import br.com.ronna.ms.contrato.enums.StatusContrato;
import br.com.ronna.ms.contrato.models.ContratoModel;
import br.com.ronna.ms.contrato.repositories.ContratoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    public ContratoModel createContrato(ContratoModel contratoModel) {
        contratoModel.setContratoCreated(LocalDateTime.now());
        contratoModel.setContratoUpdated(contratoModel.getContratoCreated());
        if (contratoModel.getStatusContrato() == null) {
            contratoModel.setStatusContrato(StatusContrato.ACTIVE);
        }
        return contratoRepository.save(contratoModel);
    }

    public List<ContratoModel> listContratos() {
        return contratoRepository.findAll();
    }

    public ContratoModel getContrato(Long contratoId) {
        return contratoRepository.getById(contratoId);
    }


    public ContratoModel saveContrato(ContratoModel contratoModel) {
        ContratoModel contratoEdit = contratoRepository.getById(contratoModel.getContratoId());
        BeanUtils.copyProperties(contratoModel, contratoEdit);
        contratoEdit.setContratoUpdated(LocalDateTime.now());
        return contratoRepository.save(contratoEdit);
    }
}

