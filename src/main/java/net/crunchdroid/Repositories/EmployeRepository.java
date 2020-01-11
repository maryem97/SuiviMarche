package net.crunchdroid.Repositories;


import net.crunchdroid.Entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository <Employe, Long> {
}
