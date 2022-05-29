package com.jobOffers.recruitment.dao;

import com.jobOffers.recruitment.model.Emploi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploiDao extends JpaRepository<Emploi, Long> {
    @Modifying
    @Query("delete from Emploi where titre=?1")
    void deleteEmploiByTitre(String Titre);
}
