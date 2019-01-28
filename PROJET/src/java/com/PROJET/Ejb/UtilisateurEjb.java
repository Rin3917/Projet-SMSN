/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.Ejb;

import com.PROJET.JavaBeans.Message;
import com.PROJET.JavaBeans.PosteDeSecours;
import com.PROJET.JavaBeans.Utilisateur;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
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
     
     
     public void ajouterPds(PosteDeSecours pds){
          try 
        {
            em.merge(pds);
        } catch (Exception e)
        {
            
        }   
     }
     
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
     public void ajouterMessager(Message m)
     {
            try 
        {
            em.merge(m);
        } catch (Exception e)
        {
            
        }    
     }
     
     public Utilisateur getUtilisateurById(int idUtilisateur)
     {
           Utilisateur user = new Utilisateur();
           Query q = em.createQuery("SELECT u  FROM  Utilisateur u WHERE u.idUtilisateur= :idUtilisateur ");
          q.setParameter("idUtilisateur", idUtilisateur);
       
        try
        {
            user = (Utilisateur) q.getSingleResult();
            System.out.println("çca marche");
         
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
         return user;
     }
     
     public Utilisateur getUtilisateurByMail(String email )
     {
         Utilisateur user = new Utilisateur();
           Query q = em.createQuery("SELECT u  FROM  Utilisateur u WHERE u.Mail= :email ");
          q.setParameter("email", email);
       
        try
        {
            user = (Utilisateur) q.getSingleResult();
            System.out.println("çca marche");
         
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
         return user;
         
     }
     
     public List<Utilisateur> afficherTlm()
     {
         List<Utilisateur> listUser= new ArrayList<Utilisateur>();
         
           Query q = em.createQuery("SELECT u  FROM  Utilisateur u ");
       
        try
        {
            listUser = q.getResultList();
         
        }
        catch(Exception e)
        {
         System.out.println(e);
        }
         
         return listUser;
     }
     
     public List<PosteDeSecours> afficherPds()
     {
         List<PosteDeSecours> lpds = new ArrayList<PosteDeSecours>();
         
           Query q = em.createQuery("SELECT  p FROM PosteDeSecours p ");
        try
        {
            lpds = q.getResultList();
         
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
         return lpds;
     }
     
         public List<Message> afficherMessage(Utilisateur user)
     {
         List<Message> listMessage= new ArrayList<Message>();
         
           Query q = em.createQuery("SELECT  m FROM Message m WHERE  m.destinataire.idUtilisateur = :idUtilisateur ");
        q.setParameter("idUtilisateur", user.getIdUtilisateur());
        try
        {
            listMessage = q.getResultList();
            System.out.println(listMessage.size());
         
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
         
         return listMessage;
     }
         

     public void setNbConnexion(String email)
     {
         Query q = em.createQuery("UPDATE Utilisateur u SET u.NbConnexion = u.NbConnexion+1 WHERE u.Mail= :email ");
          q.setParameter("email", email);
         int res =q.executeUpdate();
     }
      public void setAvatar(String email, String name)
     {
         System.out.println("ses ici");
         Query q = em.createQuery("UPDATE Utilisateur u SET u.Avatar = :name  WHERE u.Mail= :email ");
          q.setParameter("email", email);
          System.out.println(email);
          q.setParameter("name", "img/"+name);
         int res =q.executeUpdate();
         System.out.println("ses ici 2");
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
