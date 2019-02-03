/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.Ejb.UtilisateurEjb;
import com.PROJET.JavaBeans.Participation;
import com.PROJET.JavaBeans.PosteDeSecours;
import com.PROJET.JavaBeans.Utilisateur;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Named
@RequestScoped
public class ParticipationBean {

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    @EJB
    private UtilisateurEjb monejb = new UtilisateurEjb();

    private Participation participation = new Participation();

    public Participation getParticipation() {
        return participation;
    }

    public void setParticipation(Participation participation) {
        this.participation = participation;
    }

    public String ajouterParticipation(PosteDeSecours pds, Utilisateur user) {

        if (this.monejb.isParticipe(pds, user) == false) {
            this.participation.setParticipant(user);
            this.participation.setPds(pds);
            System.out.println(this.participation.getHeureDebut());
            this.monejb.ajouterParticipation(participation);
        }
        else{
            this.monejb.updateParticipation(pds, user, participation);
        }
        return"prochainPoste.jsf?faces-redirect=true";
       

    }

}
