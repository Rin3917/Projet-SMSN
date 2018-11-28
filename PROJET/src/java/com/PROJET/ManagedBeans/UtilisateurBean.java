/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.Ejb.UtilisateurEjb;
import com.PROJET.JavaBeans.Utilisateur;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Named @SessionScoped
public class UtilisateurBean implements Serializable {

    @EJB
    private UtilisateurEjb utilisateurEjb;
    
      @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;
    

   private Utilisateur user = new Utilisateur();
   
   private List<Utilisateur> listUtilisateur;
   
   public String inscrireUtilisateur()
   {
       FacesMessage message;
       String redirection = "authentification.jsf";
       try{
           if(isValidEmailAddress(user.getMail()))
           {
            this.user.setAvatar("img/Dolphin.jpg");
            utilisateurEjb.ajouter(user);
               message = new FacesMessage("Vous vous ètes inscrit avec succès,vous pouvez maintenant vous connecter");
           }
           else{
               message = new FacesMessage("Veuillez entrez un E-mail correct");
               redirection = "inscription.jsf";
           }
 
       }catch(Exception e)
       {
             message = new FacesMessage("Erreur lors de l'authentification");
              redirection = "inscription.jsf";
           e.printStackTrace();
           
       }
       FacesContext.getCurrentInstance().addMessage(null, message);
       return redirection;
   }

    public List<Utilisateur> getListUtilisateur() {
        this.listUtilisateur=this.utilisateurEjb.afficherTlm();
        return listUtilisateur;
    }
   

   
public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
      InternetAddress emailAddr = new InternetAddress(email);
      emailAddr.validate();
   } catch (AddressException ex) {
      result = false;
   }
   return result;
}

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
    
    
    
    
}