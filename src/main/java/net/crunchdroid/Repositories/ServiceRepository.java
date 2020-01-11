package net.crunchdroid.Repositories;


import net.crunchdroid.Entities.Entreprise;
import net.crunchdroid.Entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
      List<Service> findByEntreprise(Entreprise entreprise);
}
