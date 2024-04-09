package com.mitocode.repo.Controller;

import com.mitocode.repo.Model.Paciente;
import com.mitocode.repo.CommonLibrary.Config;
import com.mitocode.repo.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Validated
@RestController
@RequestMapping("/v1/api/consultorio/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService pacienteService;

    @PostMapping("/save")
    public HttpEntity<Paciente> guardar(@Valid @RequestBody Paciente paciente) {
        Paciente savedPaciente = pacienteService.save(paciente);
        return ResponseEntity.created(Config.uri(savedPaciente.getId_paciente())).build();
    }

    @GetMapping("/show-all")
    public HttpEntity<List<Paciente>> getAll() {
        List<Paciente> pacientes = pacienteService.findAll();
        pacientes.forEach(paciente -> {
            paciente.add(linkTo(methodOn(PacienteController.class).getPacienteByUUID(paciente.getId_paciente())).withSelfRel());
        });
        return new ResponseEntity<List<Paciente>>(pacientes, HttpStatus.FOUND);
    }

    @GetMapping("/show-by")
    public HttpEntity<Optional<Paciente>> getPacienteByUUID(@RequestParam(value = "UUID") String uuid) {
        Optional<Paciente> pacienteByUUID = pacienteService.findByUUID(uuid);
        pacienteByUUID.get().add(linkTo(methodOn(PacienteController.class).getPacienteByUUID(uuid)).withSelfRel());
        return new ResponseEntity<Optional<Paciente>>(pacienteByUUID, HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) {
        Paciente pacienteToUpdate = pacienteService.update(paciente);
        pacienteToUpdate.add(linkTo(methodOn(PacienteController.class).update(paciente)).withSelfRel());
        return new ResponseEntity<Paciente>(pacienteToUpdate, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam(value = "UUID") String uuid) {
        pacienteService.deleteByUUID(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
