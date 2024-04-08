package com.mitocode.repo.consultorio.Controller;

import com.mitocode.repo.consultorio.CommonLibrary.Config;
import com.mitocode.repo.consultorio.Model.Paciente;
import com.mitocode.repo.consultorio.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/v1/api/consultorio/pacientes")
public class PacienteController {
    @Autowired
    private IPacienteService pacienteService;

    @PostMapping("/save")
    public ResponseEntity<Paciente> guardar(@Valid @RequestBody Paciente paciente) {
        Paciente savedPaciente = pacienteService.save(paciente);
        return ResponseEntity.created(Config.uri(savedPaciente.getId_paciente())).build();
    }

    @GetMapping("/show-all")
    public ResponseEntity<List<Paciente>> getAll() {
        return new ResponseEntity<List<Paciente>>(pacienteService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/show-by-uuid")
    public ResponseEntity<Optional<Paciente>> getPacienteByUUID(@RequestParam(value = "UUID") String uuid) {
        return new ResponseEntity<Optional<Paciente>>(pacienteService.findByUUID(uuid), HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) {
        return new ResponseEntity<Paciente>(pacienteService.update(paciente), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam(value = "UUID") String uuid) {
        pacienteService.deleteByUUID(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
