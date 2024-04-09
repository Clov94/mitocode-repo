package com.mitocode.repo.Controller;

import com.mitocode.repo.Model.Medico;
import com.mitocode.repo.Service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/consultorio/medicos")
public class MedicoController {
    @Autowired
    private IMedicoService medicoService;

    @PostMapping("/save")
    public Medico guardar(@RequestBody Medico medico) {
        return medicoService.save(medico);
    }

    @GetMapping("/show-all")
    public List<Medico> getAll() {
        return medicoService.findAll();
    }

    @GetMapping("/medico")
    public Optional<Medico> getMedico(@RequestParam(value = "UUID") String uuid) {
        return medicoService.findByUUID(uuid);
    }

    @PutMapping("/update")
    public void update(@RequestBody Medico medico) {
        medicoService.update(medico);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "UUID") String uuid) {
        medicoService.deleteByUUID(uuid);
    }
}
