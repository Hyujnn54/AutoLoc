package tn.esprit.autoloc.Services.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Services.IAgenceService;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }
}
