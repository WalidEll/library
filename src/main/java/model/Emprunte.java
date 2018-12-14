package model;

import model.utilisateur.Adherent;

import java.util.Date;

public class Emprunte {
    private Adherent adherent;
    private StatutDocument statut;
    private Date dateEmprunt;

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public StatutDocument getStatut() {
        return statut;
    }

    public void setStatut(StatutDocument statut) {
        this.statut = statut;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }
}
