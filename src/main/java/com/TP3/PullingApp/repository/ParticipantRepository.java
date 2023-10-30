package com.TP3.PullingApp.repository;

import com.TP3.PullingApp.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
}
