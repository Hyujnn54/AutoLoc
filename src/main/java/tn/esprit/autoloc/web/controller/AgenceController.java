package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.Services.IAgenceService;
import tn.esprit.autoloc.domain.Agence;

@Tag(name = "Agence", description = "Operations related to agencies")
@RestController
@RequiredArgsConstructor
@RequestMapping("/agences")
public class AgenceController {

    private final IAgenceService agenceService;

    @Operation(summary = "Ajouter une agence", description = "Ajoute une nouvelle agence à la base de données.")
    @PostMapping("/add")
    public ResponseEntity<Agence> addAgence(@RequestBody Agence agence) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.addAgence(agence));
    }
}
