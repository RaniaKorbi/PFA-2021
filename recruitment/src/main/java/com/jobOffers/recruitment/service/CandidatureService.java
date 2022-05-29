package com.jobOffers.recruitment.service;

import com.jobOffers.recruitment.dao.CandidatureDao;
import com.jobOffers.recruitment.exceptions.UserNotFoundException;
import com.jobOffers.recruitment.model.Candidature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jobOffers.recruitment.model.Emploi;
import javax.transaction.Transactional;
import java.util.List;
@Service("CandidatureService")
@Transactional
public class CandidatureService {

    private CandidatureDao candidatureDao;
    @Autowired
    public CandidatureService(CandidatureDao candidatureDao) {
        this.candidatureDao = candidatureDao;
    }

    public Candidature findById(Long idCandidature) {
        return  candidatureDao.findById(idCandidature).orElseThrow(() -> new UserNotFoundException("Candidature not found"));
    }



    public List<Candidature> findAll() {
        return candidatureDao.findAll();
    }

    public List<Candidature> findByEmploi(Emploi emploi) {
        return candidatureDao.findByEmploi(emploi);
    }
    /*public List<Candidature> findByCandidat(Candidat candidat) {
        return candidatureDao.findByCandidat(candidat);
    }
*/
    public Candidature save(Candidature candidature) {
        return candidatureDao.save(candidature);
    }


    public void delete(Long idCandidature) {
        candidatureDao.deleteById(idCandidature);
    }


    public Candidature update(Candidature candidature) {return candidatureDao.save(candidature);
    }
}
