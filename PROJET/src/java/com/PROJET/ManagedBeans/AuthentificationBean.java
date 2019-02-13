/*
 * Licence pro informatique 2018/2019
 * Université de Franche-Comté
 * and open the template in the editor.
 */
package com.PROJET.ManagedBeans;

import com.PROJET.Ejb.UtilisateurEjb;
import com.PROJET.JavaBeans.Message;
import com.PROJET.JavaBeans.Participation;
import com.PROJET.JavaBeans.PosteDeSecours;
import com.PROJET.JavaBeans.Utilisateur;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Mathieu CHARRIERE
 */
@Named
@SessionScoped
public class AuthentificationBean implements Serializable {

    private String mail;
    private String motdepasse;
    private String redirection;
    private UploadedFile file;

    @EJB
    private UtilisateurEjb monejb = new UtilisateurEjb();
    private Utilisateur user;
    private PosteDeSecours pds = new PosteDeSecours();

    public UtilisateurEjb getMonejb() {
        return monejb;
    }

    public void setMonejb(UtilisateurEjb monejb) {
        this.monejb = monejb;
    }

    public PosteDeSecours getPds() {
        return pds;
    }

    public void setPds(PosteDeSecours pds) {
        this.pds = pds;
    }

    public String supprimerPds(PosteDeSecours pds) {

        if (this.user.getIsAdmin() == false) {
            return this.deconnexion();

        } else {
            this.monejb.supprimerPds(pds);
            return "prochainPoste.jsf?faces-redirect=true";
        }

    }

    public String supprimerMessage(Message msg) {

        if (this.user.getIsAdmin() == false) {
            this.monejb.supprimerMessage(msg);
            return "message.jsf?faces-redirect=true";

        } else {
            this.monejb.supprimerMessage(msg);
            return "messageAdmin.jsf?faces-redirect=true";
        }

    }

    public String ajouterPds() {
        if (this.user.getIsAdmin() == false) {
            return this.deconnexion();

        } else {
            this.monejb.ajouterPds(this.pds);
            return "prochainPosteAdmin.jsf?faces-redirect=true";

        }

    }

    public String DeleteUser(Utilisateur u) {
        if (this.user.getIsAdmin() == false) {
            return this.deconnexion();

        } else {
            this.monejb.supprimerUser(u);
            return "ajoutSauveteurAdmin.jsf?faces-redirect=true";
        }
    }

    public String ConfirmerUtilisateur(Utilisateur u) {

        if (this.user.getIsAdmin() == false) {
            return this.deconnexion();

        } else {
            this.monejb.ConfirmUser(u);
            return "ajoutSauveteurAdmin.jsf?faces-redirect=true";
        }

    }

    public List<Utilisateur> getNonConfirmedUser() {
        return this.monejb.getNonConfirmedUsers();
    }

    public String Participe(PosteDeSecours pds, Utilisateur user) {
        Boolean test = this.monejb.isParticipe(pds, user);

        if (test == true) {
            return "Modifier ma participation";
        } else {
            return "Participer a ce poste";
        }

    }

    public String RenvoiFormParticipation(PosteDeSecours pds) {

        if (this.user.getIsAdmin() == false) {
            this.pds = pds;
            return "inscriptionPoste.jsf";

        } else {
            this.pds = pds;
            return "inscriptionPosteAdmin.jsf";
        }
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<Message> afficherMail() {
        List<Message> malist = this.monejb.afficherMessage(user);
        for (Message m : malist) {
            System.out.println(m.getTitre());
        }
        return malist;
    }

    public String upload() {
        if (file != null) {
            byte[] tab = file.getContents();
            try {
                Random randnum = new Random();
                String name = file.getFileName() + "" + randnum.nextDouble() + ".jpg";
                FileOutputStream out = new FileOutputStream("C:\\Users\\mathieu\\Documents\\NetBeansProjects\\Projet-SMSN\\PROJET\\web\\img\\" + name);
                out.write(tab);
                out.flush();
                out.close();
                this.user.setAvatar(name);
                this.monejb.setAvatar(user.getMail(), user.getAvatar());
                File f = new File(".");
                System.out.println(f.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(tab[0] + " " + tab[1] + " tab.lenght : " + tab.length);
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "ListeSauveteur";
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String validerAuthentification() {

        FacesMessage message = null;
        String redirection = "authentification";

        if (monejb.isPresent(mail, motdepasse)) {
            this.user = monejb.getUtilisateurByMail(mail);
            this.monejb.setNbConnexion(mail);
            if (this.user.getIsAdmin() == true) {
                redirection = "adminWebPage/succesAdmin.jsf";
            } else {
                redirection = "succes.jsf";
            }

        } else {
            message = new FacesMessage("Erreur lors de l'authentification");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        //ajouter le message JSF

        return redirection + "?faces-redirect=true";
    }

    public String redirection() {
        if (!this.mail.equals("") && !this.motdepasse.equals("")) {
            return redirection;
        } else {
            return "authentification.jsf?faces-redirect=true";
        }
    }

    public String deconnexion() {
        this.mail = null;
        this.user = null;
        return "/authentification.jsf?faces-redirect=true";
    }
// getters et setters

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getRedirection() {
        return redirection;
    }

    public void setRedirection(String redirection) {
        this.redirection = redirection;
    }

}
