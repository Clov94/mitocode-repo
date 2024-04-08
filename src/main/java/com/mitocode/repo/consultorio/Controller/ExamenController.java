package com.mitocode.repo.consultorio.Controller;

import com.mitocode.repo.consultorio.Model.Especialidad;
import com.mitocode.repo.consultorio.Model.Examen;
import com.mitocode.repo.consultorio.Service.IEspecialidadService;
import com.mitocode.repo.consultorio.Service.IExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/consultorio/examenes")
public class ExamenController {
    @Autowired
    private IExamenService examenService;

    @PostMapping("/save")
    public Examen guardar(@RequestBody Examen examen) {
        return examenService.save(examen);
    }

    @GetMapping("/show-all")
    public List<Examen> getAll() {
        return examenService.findAll();
    }

    @GetMapping("/examen")
    public Optional<Examen> getExamen(@RequestParam(value = "UUID") String uuid) {
        return examenService.findByUUID(uuid);
    }

    @PutMapping("/update")
    public void update(@RequestBody Examen examen) {
        examenService.update(examen);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "UUID") String uuid) {
        examenService.deleteByUUID(uuid);
    }
}
