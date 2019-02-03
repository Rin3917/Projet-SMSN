/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.Ejb.UtilisateurEjb;
import com.PROJET.JavaBeans.Message;
import com.PROJET.JavaBeans.PosteDeSecours;
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

    public PosteDeSecours getPds() {
        return pds;
    }

    public void setPds(PosteDeSecours pds) {
        this.pds = pds;
    }
    public List<PosteDeSecours> afficherPds(){
        return this.monejb.afficherPds();
       
    }
    
    public String ajouterPds(){
        this.monejb.ajouterPds(this.pds);
         return"prochainPoste.jsf?faces-redirect=true";
    }
    
    public void supprimerPds(){
        
    }
    
    
}
