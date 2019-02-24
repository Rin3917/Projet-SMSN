/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.Ejb.UtilisateurEjb;
import com.PROJET.JavaBeans.Article;
import com.PROJET.JavaBeans.Utilisateur;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Named
@RequestScoped
public class ArticleBean {

    @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    private UploadedFile file;
    @EJB
    private UtilisateurEjb monejb = new UtilisateurEjb();

    Article a = new Article();

    public void ajouterArticle(Utilisateur u) {
        this.a.setAuteur(u);
        if (this.a.getIllustration() != null) {
             this.upload();

        } 

        this.monejb.ajouterArticle(this.a);
    }

    public void supprimerArticle(Article a) {
        this.monejb.supprimerArticle(a);

    }

    public void upload() {
        if (file != null) {
            byte[] tab = file.getContents();
            try {
                Random randnum = new Random();
                String name = file.getFileName() + "" + randnum.nextDouble() + ".jpg";
                FileOutputStream out = new FileOutputStream("C:\\Users\\mathieu\\Documents\\NetBeansProjects\\Projet-SMSN\\PROJET\\web\\img\\" + name);
                out.write(tab);
                out.flush();
                out.close();
                this.a.setIllustration(name);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(tab[0] + " " + tab[1] + " tab.lenght : " + tab.length);
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<Article> listArticles() {
        return this.monejb.getListArticle();
    }

    public Article getA() {
        return a;
    }

    public void setA(Article a) {
        this.a = a;
    }

}
