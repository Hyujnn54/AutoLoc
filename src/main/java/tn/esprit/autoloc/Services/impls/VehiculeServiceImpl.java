package tn.esprit.autoloc.Services.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Services.IVehiculeService;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        if (vehiculeRepository.existsByImmatriculation(vehicule.getImmatriculation())) {
            throw new IllegalArgumentException(
                    "Un véhicule avec l'immatriculation " + vehicule.getImmatriculation() + " existe déjà");
        }

        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Optional<Vehicule> getVehiculeById(Long id) {
        return vehiculeRepository.findById(id);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule, Long id) {
        Vehicule existingVehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule introuvable avec l'id " + id));

        vehiculeRepository.findByImmatriculation(vehicule.getImmatriculation())
                .filter(found -> !found.getIdVehicule().equals(id))
                .ifPresent(found -> {
                    throw new IllegalArgumentException(
                            "Un véhicule avec l'immatriculation "
                                    + vehicule.getImmatriculation() + " existe déjà");
                });

        existingVehicule.setImmatriculation(vehicule.getImmatriculation());
        existingVehicule.setMarque(vehicule.getMarque());
        existingVehicule.setModele(vehicule.getModele());
        existingVehicule.setCategorie(vehicule.getCategorie());
        existingVehicule.setTarifJournalier(vehicule.getTarifJournalier());
        existingVehicule.setStatut(vehicule.getStatut());
        existingVehicule.setAgence(vehicule.getAgence());
        existingVehicule.setEquipements(vehicule.getEquipements());

        return vehiculeRepository.save(existingVehicule);
    }

    @Override
    public void supprimerVehicule(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Véhicule introuvable avec l'id " + id));

        vehiculeRepository.delete(vehicule);
    }
}
