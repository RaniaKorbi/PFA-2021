package com.jobOffers.recruitment.controller;
import com.jobOffers.recruitment.model.Emploi;
import com.jobOffers.recruitment.service.EmploiService;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/emploi")
public class EmploiController {
    private final EmploiService emploiService;

    @Autowired
    public EmploiController(EmploiService emploiService) {
        this.emploiService = emploiService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Emploi>> getEmplois() {
        List<Emploi> emplois = emploiService.findAll();
        return new ResponseEntity<>(emplois, HttpStatus.OK);
    }

    @GetMapping("/find/{idEmploi}")
    public ResponseEntity<Emploi> getEmploi(@PathVariable("idEmploi") Long idEmploi) {
        Emploi emploi = emploiService.findById(idEmploi);
        return new ResponseEntity<>(emploi, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{idEmploi}")
    public ResponseEntity<?> deleteEmploi(@PathVariable("idEmploi") Long idEmploi) {
        emploiService.delete(idEmploi);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Emploi> addEmploi(@RequestBody Emploi emploi){
        Emploi newEmploi= emploiService.save(emploi);
        return new ResponseEntity<>(newEmploi, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Emploi> updateEmploi(@RequestBody Emploi emploi) {
        Emploi updateEmploi = emploiService.update(emploi);
        return new ResponseEntity<>(updateEmploi, HttpStatus.OK);
    }


}
