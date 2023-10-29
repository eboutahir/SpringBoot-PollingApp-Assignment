package com.demoProject.Repository;

import com.demoProject.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long  idTache);
    User findByUsername(String username);
}











