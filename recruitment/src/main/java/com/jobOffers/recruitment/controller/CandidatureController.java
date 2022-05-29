package com.jobOffers.recruitment.controller;

import com.jobOffers.recruitment.model.Candidature;
import com.jobOffers.recruitment.model.Emploi;
import com.jobOffers.recruitment.service.CandidatureService;
import com.jobOffers.recruitment.service.EmploiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.jobOffers.recruitment.controller.EmploiController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/candidature")
public class CandidatureController {
    private final CandidatureService candidatureService;
    private final EmploiService emploiService;

    @Autowired
    public CandidatureController(CandidatureService candidatureService , EmploiService emploiService) {
        this.candidatureService = candidatureService;
        this.emploiService = emploiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Candidature>> getCandidatures() {
        List<Candidature> candidatures = candidatureService.findAll();
        return new ResponseEntity<>(candidatures, HttpStatus.OK);
    }
    @GetMapping("/findByEmploi/{idEmploi}")
    public ResponseEntity<List<Candidature>> getCandidaturesByEmploi(@PathVariable("idEmploi") Long idEmploi) {
        Emploi emploi=emploiService.findById(idEmploi);
        List<Candidature> candidatures = candidatureService.findByEmploi(emploi);
        return new ResponseEntity<>(candidatures, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Candidature> getCandidature(@PathVariable("id") Long idCandidature) {

        Candidature candidature = candidatureService.findById(idCandidature);
        return new ResponseEntity<>(candidature, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCandidature(@PathVariable("id") Long idCandidature) {
        candidatureService.delete(idCandidature);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/{idEmploi}")
    public ResponseEntity<Candidature> addCandidature(@RequestBody Candidature candidature , @PathVariable("idEmploi") Long idEmploi) {
        Emploi emploi=emploiService.findById(idEmploi);
        candidature.setEmploi(emploi);
        Candidature newCandidature = candidatureService.save(candidature);
        return new ResponseEntity<>(newCandidature, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/update")
    public ResponseEntity<Candidature> updateCandidature(@RequestBody Candidature candidature) {
        Candidature UpdateCandidature = candidatureService.update(candidature);
        return new ResponseEntity<>(UpdateCandidature, HttpStatus.OK);
    }
}