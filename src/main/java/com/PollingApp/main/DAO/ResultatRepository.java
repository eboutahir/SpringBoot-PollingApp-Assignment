package com.PollingApp.main.DAO;

import com.PollingApp.main.models.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat, Integer> {

}
