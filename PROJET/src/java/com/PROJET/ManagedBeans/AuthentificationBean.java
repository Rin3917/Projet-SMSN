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

UtilisateurBean userBean = new UtilisateurBean();
// valider l'authentification
public String validerAuthentification()
{
    FacesMessage message=null;
    String redirection="authentification";
    userBean.user.setMail(mail);
    userBean.user.setMdp(motdepasse);
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

// getters et setters
    public String getIdentifiant() {
        return mail;
    }

    public void setIdentifiant(String mail) {
        this.mail = mail;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    
}

