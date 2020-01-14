package net.crunchdroid.Repositories;

import net.crunchdroid.Entities.Projet;
import net.crunchdroid.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
