/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.JavaBeans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Entity
public class Article implements Serializable {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArticle;
    
    private String TitreArticle;
    private String TexteArticle;
    private String Illustration;
    
    @ManyToOne
    private Utilisateur auteur;

    public Article() {
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getTitreArticle() {
        return TitreArticle;
    }

    public void setTitreArticle(String TitreArticle) {
        this.TitreArticle = TitreArticle;
    }

    public String getTexteArticle() {
        return TexteArticle;
    }

    public void setTexteArticle(String TexteArticle) {
        this.TexteArticle = TexteArticle;
    }

    public String getIllustration() {
        return Illustration;
    }

    public void setIllustration(String Illustration) {
        this.Illustration = Illustration;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }
    
    
    
}
