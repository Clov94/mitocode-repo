package com.mitocode.repo.consultorio.Controller;

import com.mitocode.repo.consultorio.Model.Especialidad;
import com.mitocode.repo.consultorio.Model.Paciente;
import com.mitocode.repo.consultorio.Service.IEspecialidadService;
import com.mitocode.repo.consultorio.Service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/consultorio/especialidades")
public class EspecialidadController {
    @Autowired
    private IEspecialidadService especialidadService;

    @PostMapping("/save")
    public Especialidad guardar(@RequestBody Especialidad paciente) {
        return especialidadService.save(paciente);
    }

    @GetMapping("/show-all")
    public List<Especialidad> getAll() {
        return especialidadService.findAll();
    }

    @GetMapping("/especialidad")
    public Optional<Especialidad> getEspecialidad(@RequestParam(value = "UUID") String uuid) {
        return especialidadService.findByUUID(uuid);
    }

    @PutMapping("/update")
    public void update(@RequestBody Especialidad persona) {
        especialidadService.update(persona);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "UUID") String uuid) {
        especialidadService.deleteByUUID(uuid);
    }
}
