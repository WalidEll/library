package gui.event;

import model.utilisateur.Utilisateur;

import java.util.EventObject;

public class LoginEvent {

    private Utilisateur username;

    public LoginEvent(Utilisateur username) {
        this.username = username;
    }
    public Utilisateur getUsername() {
        return username;
    }


}
