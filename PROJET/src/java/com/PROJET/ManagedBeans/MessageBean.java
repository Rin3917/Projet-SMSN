/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.Ejb.UtilisateurEjb;
import com.PROJET.JavaBeans.Article;
import com.PROJET.JavaBeans.Message;
import com.PROJET.JavaBeans.Utilisateur;
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
public class MessageBean {
    
     @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private UtilisateurEjb monejb = new UtilisateurEjb();

    public UtilisateurEjb getMonejb() {
        return monejb;
    }

    public void setMonejb(UtilisateurEjb monejb) {
        this.monejb = monejb;
    }

    
    int mondestinataire =0;
    Message m = new Message();

    public int getMondestinataire() {
        return mondestinataire;
    }

    public void setMondestinataire(int mondestinataire) {
        this.mondestinataire = mondestinataire;
    }

    

    public Message getM() {
        return m;
    }

    public void setM(Message m) {
        
        this.m = m;
    }
    
    public void envoyerMessage(Utilisateur expediteur){
        try{
           
      this.m.setExpediteur(expediteur);
      this.m.setDestinataire(this.monejb.getUtilisateurById(mondestinataire));
        System.out.println("destinataire : " + this.m.getDestinataire().getNom());
      System.out.println("expediteur : " +this.m.getExpediteur().getNom());
      this.monejb.ajouterMessager(this.m);
      
    
        }
        catch(Exception e){
           
         
            System.out.println(e+"salut");
        }
    }
    
}
