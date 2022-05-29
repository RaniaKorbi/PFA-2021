package com.jobOffers.recruitment.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "files")
public class Cv {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idCv;
    private String titre;
    private String type;
    private String email;
    @Lob
    private byte[] data;


    public Cv(String titre, String type, byte[] data,String email) {
        this.titre = titre;
        this.type = type;
        this.data = data;
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdCv() {
        return idCv;
    }

    public void setIdCv(String idCv) {
        this.idCv = idCv;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Cv{" +
                "idCv='" + idCv + '\'' +
                ", titre='" + titre + '\'' +
                ", type='" + type + '\'' +
                ", email='" + email + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}