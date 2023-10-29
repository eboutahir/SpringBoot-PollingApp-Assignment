package com.demoProject.Controllers;

import com.demoProject.Models.Reponse;
import com.demoProject.Services.ReponseService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reponses")
public class ReponseController {

    @Autowired
    private ReponseService reponseService;

    @GetMapping
    public List<Reponse> getAllReponses() {
        return reponseService.getAllReponses();
    }

    @PostMapping("/create")
    public ResponseEntity<Reponse> createReponse(@RequestBody Reponse reponse) {

        Reponse createdReponse = reponseService.saveReponse(reponse);
        return ResponseEntity.ok(createdReponse);
    }

}