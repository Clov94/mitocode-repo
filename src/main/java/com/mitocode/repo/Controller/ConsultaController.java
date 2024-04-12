package com.mitocode.repo.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mitocode.repo.CommonLibrary.Config;
import com.mitocode.repo.CommonLibrary.JsonReading;
import com.mitocode.repo.Model.Consulta;
import com.mitocode.repo.Service.IConsultaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Validated
@RestController
@RequestMapping("/v1/api/consultorio/consultas")
@Slf4j
public class ConsultaController {
    @Autowired
    private IConsultaService consultaService;

    @PostMapping("/save")
    public HttpEntity<Consulta> guardar(@RequestBody String jsonPayload) throws JsonProcessingException {
        // Convert JSON payload to Consulta object
        Consulta consulta = (Consulta) JsonReading.convertJsonToObject(jsonPayload, Consulta.class);
//        Consulta consultaDto = consultaService.transactionalSave(consulta);
        return ResponseEntity.created(Config.uri(consulta.getIdConsulta())).build();
    }

    @GetMapping("/show-all")
    public HttpEntity<List<Consulta>> getAll() {
        List<Consulta> consultas = consultaService.findAll();
        consultas.forEach(consulta -> {
            consulta.add(linkTo(methodOn(ConsultaController.class).getConsultaByUUID(consulta.getIdConsulta())).withSelfRel());
        });
        return new ResponseEntity<List<Consulta>>(consultas, HttpStatus.FOUND);
    }

    @GetMapping("/show-by")
    public HttpEntity<Optional<Consulta>> getConsultaByUUID(@RequestParam(value = "UUID") String uuid) {
        Optional<Consulta> consultaByUUID = consultaService.findByUUID(uuid);
        consultaByUUID.get().add(linkTo(methodOn(ConsultaController.class).getConsultaByUUID(uuid)).withSelfRel());
        return new ResponseEntity<Optional<Consulta>>(consultaByUUID, HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Consulta> update(@RequestBody Consulta consulta) {
        Consulta consultaToUpdate = consultaService.update(consulta);
        consultaToUpdate.add(linkTo(methodOn(ConsultaController.class).update(consulta)).withSelfRel());
        return new ResponseEntity<Consulta>(consultaToUpdate, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam(value = "UUID") String uuid) {
        consultaService.deleteByUUID(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
