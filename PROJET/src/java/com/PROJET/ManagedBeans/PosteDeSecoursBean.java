/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.Ejb.UtilisateurEjb;
import com.PROJET.JavaBeans.Message;
import com.PROJET.JavaBeans.PosteDeSecours;
import com.PROJET.JavaBeans.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Named @RequestScoped
public class PosteDeSecoursBean {
    
     @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;
    
     @EJB
    private UtilisateurEjb monejb = new UtilisateurEjb();

    PosteDeSecours pds = new PosteDeSecours();
    List<Utilisateur> participant = new ArrayList<Utilisateur>();

    public PosteDeSecours getPds() {
        return pds;
    }

    public void setPds(PosteDeSecours pds) {
        this.pds = pds;
    }
    public List<PosteDeSecours> afficherPds(){
        return this.monejb.afficherPds();
       
    }
     public List<PosteDeSecours> afficherAncienPds(){
        return this.monejb.afficherAncienPds();
       
    }
 
    
    public String ajouterPds(){
        this.pds.setIsTerminer(false);
        this.monejb.ajouterPds(this.pds);
         return"prochainPoste.jsf?faces-redirect=true";
    }
   
    public void updatePds(PosteDeSecours pds){
        this.monejb.TerminerPds(pds);
    }

    public List<Utilisateur> getParticipant() {
        return participant;
    }

    public void setParticipant(List<Utilisateur> participant) {
        this.participant = participant;
    }
    
    public void supprimerPds(){
        
    }
    
    
}
