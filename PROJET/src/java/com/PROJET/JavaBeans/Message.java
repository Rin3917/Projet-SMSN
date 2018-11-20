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
    
    @ManyToMany
    private List<Utilisateur> Contact = new ArrayList<Utilisateur>();

    public Message() {
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

    public List<Utilisateur> getContact() {
        return Contact;
    }

    public void setContact(List<Utilisateur> Contact) {
        this.Contact = Contact;
    }
    
    
    
}
