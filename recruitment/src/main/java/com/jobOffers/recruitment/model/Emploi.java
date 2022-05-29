package com.jobOffers.recruitment.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Emploi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploi;
    private String titre;
    private String type;
    private String salaire;
    private String experience;
    private String adresse;
    private String societe;
    private String siteWeb;
    @OneToMany(mappedBy = "emploi")
    private List<Candidature> candidatures;
    public Emploi() {
    }



    public Emploi(String titre, String type, String salaire, String experience, String adresse, String societe, String siteWeb) {
        this.titre = titre;
        this.type = type;
        this.salaire = salaire;
        this.experience = experience;
        this.adresse = adresse;
        this.societe = societe;
        this.siteWeb = siteWeb;
    }

    public Long getIdEmploi() {
        return idEmploi;
    }

    public void setIdEmploi(Long idEmploi) {
        this.idEmploi = idEmploi;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    @Override
    public String toString() {
        return "Emploi{" +
                "idEmploi=" + idEmploi +
                ", titre='" + titre + '\'' +
                ", type='" + type + '\'' +
                ", salaire='" + salaire + '\'' +
                ", experience='" + experience + '\'' +
                ", adresse='" + adresse + '\'' +
                ", societe='" + societe + '\'' +
                ", siteWeb='" + siteWeb + '\'' +
                ", candidatures=" + candidatures +
                '}';
    }
}