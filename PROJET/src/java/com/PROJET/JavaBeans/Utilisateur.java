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
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Entity
public class Utilisateur implements Serializable {
    
    @Id
    private Long idUtilisateur;
    
    private String Nom;
    private String Prenom;
    private int Telephone;
    private String Mdp;
    private int NbConnexion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DerniereConnexion ;
    private String Avatar;
    private Boolean isAdmin;
    private Boolean isConfirmed;
    
    @OneToMany
    private List<Article> mesArticle = new ArrayList<Article>();
    @ManyToMany
    private List<PosteDeSecours> mesParticipations = new ArrayList <PosteDeSecours>();
    @ManyToMany
    private List<Message> mesMessage = new ArrayList<Message>();

    public Utilisateur() {
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int Telephone) {
        this.Telephone = Telephone;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String Mdp) {
        this.Mdp = Mdp;
    }

    public int getNbConnexion() {
        return NbConnexion;
    }

    public void setNbConnexion(int NbConnexion) {
        this.NbConnexion = NbConnexion;
    }

    public Date getDerniereConnexion() {
        return DerniereConnexion;
    }

    public void setDerniereConnexion(Date DerniereConnexion) {
        this.DerniereConnexion = DerniereConnexion;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public List<Article> getMesArticle() {
        return mesArticle;
    }

    public void setMesArticle(List<Article> mesArticle) {
        this.mesArticle = mesArticle;
    }

    public List<PosteDeSecours> getMesParticipations() {
        return mesParticipations;
    }

    public void setMesParticipations(List<PosteDeSecours> mesParticipations) {
        this.mesParticipations = mesParticipations;
    }

    public List<Message> getMesMessage() {
        return mesMessage;
    }

    public void setMesMessage(List<Message> mesMessage) {
        this.mesMessage = mesMessage;
    }
    
    
}
