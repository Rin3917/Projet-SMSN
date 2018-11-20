/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.Ejb.UtilisateurEjb;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Mathieu CHARRIERE
 */

@Named @SessionScoped
public class AuthentificationBean implements Serializable{

private String mail;
private String motdepasse;

@EJB
private UtilisateurEjb monejb = new UtilisateurEjb();

// valider l'authentification
public String validerAuthentification()
{
    FacesMessage message=null;
    String redirection="authentification";
 
       if(monejb.isPresent(mail, motdepasse))
       { 
           redirection="succes.jsf?faces-redirect=true";
         
       }
       else
       {
           message=new FacesMessage("Erreur lors de l'authentification");
           FacesContext.getCurrentInstance().addMessage(null, message);
       }
    //ajouter le message JSF
    
    
    return redirection;
}


public String deconnexion()
{
    this.mail = null;
    return "authentification.jsf?faces-redirect=true";
}
// getters et setters

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
 

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    
}

