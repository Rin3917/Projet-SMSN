/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.JavaBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Entity
public class PosteDeSecours implements Serializable {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosteDeSecours;
    
    private String NomPoste;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateDebut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateFin;
    private String HeureDebut;
    private String HeureFin;
    private String Lieu;
    private int SauveteurMinRequis;
    private String Commentaire;
    
    @OneToMany
    private List<Participation> Participations = new ArrayList<Participation>();
    
 
    

    public PosteDeSecours() {
    }

    public Long getIdPosteDeSecours() {
        return idPosteDeSecours;
    }

    public void setIdPosteDeSecours(Long idPosteDeSecours) {
        this.idPosteDeSecours = idPosteDeSecours;
    }

    public String getNomPoste() {
        return NomPoste;
    }

    public void setNomPoste(String NomPoste) {
        this.NomPoste = NomPoste;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

    public String getHeureDebut() {
        return HeureDebut;
    }

    public void setHeureDebut(String HeureDebut) {
        this.HeureDebut = HeureDebut;
    }

    public String getHeureFin() {
        return HeureFin;
    }

    public void setHeureFin(String HeureFin) {
        this.HeureFin = HeureFin;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public int getSauveteurMinRequis() {
        return SauveteurMinRequis;
    }

    public void setSauveteurMinRequis(int SauveteurMinRequis) {
        this.SauveteurMinRequis = SauveteurMinRequis;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public List<Participation> getParticipations() {
        return Participations;
    }

    public void setParticipations(List<Participation> Participations) {
        this.Participations = Participations;
    }


    
    
}
