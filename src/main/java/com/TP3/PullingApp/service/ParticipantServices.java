package com.TP3.PullingApp.service;

import com.TP3.PullingApp.entity.Participant;
import com.TP3.PullingApp.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipantServices {
    @Autowired
    private ParticipantRepository participantRepository;

    public void AddParticipant(Participant participant){
        participantRepository.save(participant);
    }

    public Participant GetParticipantById(Long Id){
        return participantRepository.getById(Id);
    }

    public List<Participant> GetAllParticipants(){
        List<Participant> participants = new ArrayList<>();
        participantRepository.findAll().forEach(participants::add);

        return participants;
    }

    public void UpdateParticipant(Long id,Participant participant){
        participantRepository.save(participant);
    }

    public void DeletParticipant(Long id){
        participantRepository.deleteById(id);
    }

}
