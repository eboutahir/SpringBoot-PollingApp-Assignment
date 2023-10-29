package com.devrezaur.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devrezaur.main.models.Resultat;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat, Integer> {

}
