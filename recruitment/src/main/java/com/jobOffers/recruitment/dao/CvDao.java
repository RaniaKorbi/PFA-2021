package com.jobOffers.recruitment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobOffers.recruitment.model.Cv;
public interface CvDao extends JpaRepository<Cv, String> {
}
