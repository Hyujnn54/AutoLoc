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
}
