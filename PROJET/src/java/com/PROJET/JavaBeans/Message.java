/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.JavaBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Entity
public class Message implements Serializable {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage;
    
    private String Titre;
    private String Texte;
    private Boolean isRead;
    
    @ManyToOne
    private Utilisateur destinataire;
    
    @ManyToOne
    private Utilisateur expediteur;

    public Message() {
    }

    public Utilisateur getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Utilisateur expediteur) {
        this.expediteur = expediteur;
    }

    
    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getTexte() {
        return Texte;
    }

    public void setTexte(String Texte) {
        this.Texte = Texte;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Utilisateur getDestinataire() {
        System.out.println("ça passe");
        return destinataire;
    }

    public void setDestinataire(Utilisateur destinataire) {
        System.out.println("ça passe");
        
        this.destinataire = destinataire;
    }

  
    
    
    
}
