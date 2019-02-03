/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.JavaBeans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Mathieu CHARRIERE
 */

@Entity
public class Participation implements Serializable {
    
      @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParticipation;
      
      private String heureDebut;
      private String heureFin;
      
      @ManyToOne
      private Utilisateur Participant;
      
      @ManyToOne
      private PosteDeSecours pds;

    public Participation() {
    }

    public Participation(PosteDeSecours pds) {
        this.pds = pds;
    }

    public Long getIdParticipation() {
        return idParticipation;
    }

    public void setIdParticipation(Long idParticipation) {
        this.idParticipation = idParticipation;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public Utilisateur getParticipant() {
        return Participant;
    }

    public void setParticipant(Utilisateur Participant) {
        this.Participant = Participant;
    }

    public PosteDeSecours getPds() {
        return pds;
    }

    public void setPds(PosteDeSecours pds) {
        this.pds = pds;
    }
      
    
}
