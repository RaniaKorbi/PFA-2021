package com.jobOffers.recruitment.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "candidature")
public class Candidature implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String lastName;
        private String email;
        private String phone;
        private String position;
        private String availableStart;
        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="idEmploi")
        private  Emploi emploi;
    public Candidature(String name, String lastName, String email, String phone, String position, String availableStart) {
                this.name = name;
                this.lastName = lastName;
                this.email = email;
                this.phone = phone;
                this.position = position;
                this.availableStart = availableStart;
        }

        public Candidature() {
        }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getPosition() {
                return position;
        }

        public void setPosition(String position) {
                this.position = position;
        }

        public String getAvailableStart() {
                return availableStart;
        }

        public void setAvailableStart(String availableStart) {
                this.availableStart = availableStart;
        }


    public Emploi getEmploi() {
        return emploi;
    }

    public void setEmploi(Emploi emploi) {
        this.emploi = emploi;
    }

    @Override
    public String toString() {
        return "Candidature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", availableStart='" + availableStart + '\'' +
                ", emploi=" + emploi +
                '}';
    }
}
