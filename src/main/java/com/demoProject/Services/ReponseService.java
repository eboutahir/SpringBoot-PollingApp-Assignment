package com.demoProject.Services;

import com.demoProject.Models.Reponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReponseService {


     List<Reponse> getAllReponses();

     Reponse saveReponse(Reponse reponse);

}