package com.jobOffers.recruitment.service;

import com.jobOffers.recruitment.dao.EmploiDao;
import com.jobOffers.recruitment.exceptions.EmploiNotFoundException;
import com.jobOffers.recruitment.model.Emploi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service("EmploiService")
@Transactional
public class EmploiService  {
    private EmploiDao emploiDao;

    @Autowired
    public EmploiService(EmploiDao emploiDao) {
        this.emploiDao = emploiDao;
    }


    public Emploi findById(Long id) {
        return
                emploiDao.findById(id).orElseThrow(() -> new EmploiNotFoundException("Emploi not found"));
    }

    public List<Emploi> findAll() {
        return emploiDao.findAll();
    }


  /*  public List<Emploi> findBySociete(Societe societe) {
        return emploiDao.findBySociete(societe);
    }*/


    public Emploi save(Emploi emploi) {
        return emploiDao.save(emploi);
    }


    public void delete(Long idEmploi) {
        emploiDao.deleteById(idEmploi);
    }

    public Emploi update(Emploi emploi) {
        return emploiDao.save(emploi);
    }

}
