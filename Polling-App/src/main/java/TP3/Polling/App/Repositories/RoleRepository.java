package TP3.Polling.App.Repositories;

import TP3.Polling.App.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
    Role findByName(String name);
}
