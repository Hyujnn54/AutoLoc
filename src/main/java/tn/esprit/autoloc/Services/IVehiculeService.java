package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;
import java.util.Optional;

public interface IVehiculeService {

    Vehicule addVehicule(Vehicule vehicule);

    List<Vehicule> getAllVehicules();

    Optional<Vehicule> getVehiculeById(Long id);

    Vehicule modifierVehicule(Vehicule vehicule, Long id);

    void supprimerVehicule(Long id);
}
