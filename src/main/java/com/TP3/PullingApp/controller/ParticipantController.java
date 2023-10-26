package com.TP3.PullingApp.controller;


import com.TP3.PullingApp.entity.Participant;
import com.TP3.PullingApp.service.ParticipantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ParticipantController {

    @Autowired
    private ParticipantServices participantServices;

    @GetMapping("/ListPaticipant")
    public List<Participant> getAllParticipants() {
        return participantServices.GetAllParticipants();
    }

    @GetMapping("/Delete/{id}")
    public void deletParticipant(@PathVariable Long id) {
        participantServices.DeletParticipant(id);
    }

    @PostMapping("/Add")
    public void addParticipant1() {
        Participant participant = new Participant();
        participant.setEmail("younsstokim@gmail.com");
        participant.setName("younis tatot");
        participant.setNumber("0649156518");
        participantServices.AddParticipant(participant);
    }

}
