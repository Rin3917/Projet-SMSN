/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.JavaBeans.Message;
import com.PROJET.JavaBeans.PosteDeSecours;
import javax.annotation.Resource;
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

    PosteDeSecours pds = new PosteDeSecours();
}
