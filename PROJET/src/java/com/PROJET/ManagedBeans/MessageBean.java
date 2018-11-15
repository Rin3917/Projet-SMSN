/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.JavaBeans.Article;
import com.PROJET.JavaBeans.Message;
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
public class MessageBean {
    
     @Resource
    private UserTransaction utx;

    @PersistenceContext
    private EntityManager em;

    Message m = new Message();
    
}
