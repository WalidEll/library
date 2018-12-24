package controller;

import model.utilisateur.Utilisateur;

public class Session {
    private static Session instance = null;
    private Utilisateur utilisateur;

    public static Session getInstance() {
        if (instance == null)
            instance = new Session();
        return instance;
    }


    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    public void destroy(){
        instance=null;
    }
}
