package br.com.ronna.ms.contrato.controllers;

import br.com.ronna.ms.contrato.dtos.ContratoDto;
import br.com.ronna.ms.contrato.models.ContratoModel;
import br.com.ronna.ms.contrato.services.ContratoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping("/contrato/create-contrato")
    public ResponseEntity<ContratoModel> createContrato(@RequestBody @Valid ContratoDto contratoDto) {
        ContratoModel contratoModel = new ContratoModel();
        BeanUtils.copyProperties(contratoDto, contratoModel);
        contratoService.createContrato(contratoModel);
        return new ResponseEntity<>(contratoModel, HttpStatus.CREATED);
    }

    @GetMapping("/contrato/list-contrato")
    public List<ContratoModel> listContratos() {
        return contratoService.listContratos();
    }

    @GetMapping("/contrato/{id}")
    public ContratoModel getContrato(@PathVariable("id") Long contratoId){
        return contratoService.getContrato(contratoId);
    }

    @PutMapping("/contrato/edit-contrato/{id}")
    public ContratoModel updateContrato(@RequestBody ContratoModel contratoModel) {
        return contratoService.saveContrato(contratoModel);
    }
}
