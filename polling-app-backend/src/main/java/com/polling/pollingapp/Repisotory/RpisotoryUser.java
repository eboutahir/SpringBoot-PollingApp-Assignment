package com.polling.pollingapp.Repisotory;

import com.polling.pollingapp.Entity.Usersondage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RpisotoryUser extends JpaRepository<Usersondage,Long> {
    Usersondage findByEmail(String email);
}
