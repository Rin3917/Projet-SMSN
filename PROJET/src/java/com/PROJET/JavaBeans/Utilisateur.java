/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.JavaBeans;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class Utilisateur implements Serializable {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;
    
    private String Nom;
    private String Prenom;
    private String Mail;
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
    
    public static String getEncodedPassword(String key) throws NoSuchAlgorithmException {
byte[] uniqueKey = key.getBytes();
byte[] hash ;
hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
StringBuilder hashString = new StringBuilder();
for ( int i = 0; i < hash.length; ++i ) {
String hex = Integer.toHexString(hash[i]);
if ( hex.length() == 1 ) {
hashString.append('0');
hashString.append(hex.charAt(hex.length()-1));
} else {
hashString.append(hex.substring(hex.length()-2));
}
}
return hashString.toString();
} 

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
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
        
        
        try{
            this.Mdp = getEncodedPassword(Mdp) ;
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
       
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
