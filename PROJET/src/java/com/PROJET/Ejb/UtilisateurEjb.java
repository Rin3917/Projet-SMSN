/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.Ejb;

import com.PROJET.JavaBeans.Utilisateur;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Stateless @LocalBean
public class UtilisateurEjb {
    
     @PersistenceContext
    private EntityManager em;
     
     public void ajouter(Utilisateur user) 
     {

        //Classe newclass = new Classe(c);
        //maList.add(newclass);
        try 
        {
            em.merge(user);
        } catch (Exception e)
        {
            
        }    
     }

     public Boolean isPresent(String Mail,String mdp) 
     {
        Utilisateur user ;
        Query q = em.createQuery("SELECT u  FROM  Utilisateur u WHERE u.Mdp= :param1 AND u.Mail= :param2" );
         try {
             q.setParameter("param1", Utilisateur.getEncodedPassword(mdp));
         } catch (NoSuchAlgorithmException ex) {
             ex.printStackTrace();
         }
        q.setParameter("param2", Mail);
        try
        {
            user = (Utilisateur) q.getSingleResult();
            System.out.println("çca marche");
            return true;
        }
        catch(Exception e)
        {
            return false; 
        }
     }
     

     
    
}
