package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.Services.IVehiculeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/vehicules", "/cehicules"})
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping("/add")
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.addVehicule(vehicule));
    }

    @GetMapping
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        return ResponseEntity.ok(vehiculeService.getAllVehicules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable Long id) {
        return vehiculeService.getVehiculeById(id);
    }
}
