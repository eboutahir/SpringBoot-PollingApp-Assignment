package com.demoProject.ServiceImpl;

import com.demoProject.Models.Reponse;
import com.demoProject.Repository.ReponseRepository;
import com.demoProject.Services.ReponseService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class ReponseServiceImpl implements ReponseService {

    @Autowired
    private ReponseRepository reponseRepository;

    public List<Reponse> getAllReponses() {
        return reponseRepository.findAll();
    }

    public Reponse saveReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }
}
