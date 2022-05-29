package com.jobOffers.recruitment.dao;

import com.jobOffers.recruitment.model.Candidature;
import com.jobOffers.recruitment.model.Emploi;
import com.jobOffers.recruitment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CandidatureDao extends JpaRepository<Candidature, Long> {

    List<Candidature> findByEmploi(Emploi emploi);

}
