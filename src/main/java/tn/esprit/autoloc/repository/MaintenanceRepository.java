package tn.esprit.autoloc.repository;

import tn.esprit.autoloc.domain.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {

    /** Maintenances encore en cours (pas de date de fin). */
    List<Maintenance> findByDateFinIsNull();
}
