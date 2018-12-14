package model;

import model.document.BibDocument;
import model.utilisateur.Adherent;

import java.util.Date;

public class Emprunte {
    private Adherent adherent;
    private StatutDocument statut;
    private BibDocument document;
    private Date dateEmprunt;
    private Date dateRouteur;

    public Emprunte(Adherent adherent) {
        this.adherent = adherent;
    }

    public BibDocument getDocument() {
        return document;
    }

    public void setDocument(BibDocument document) {
        this.document = document;
    }

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

    public Date getDateRouteur() {
        return dateRouteur;
    }

    public void setDateRouteur(Date dateRouteur) {
        this.dateRouteur = dateRouteur;
    }
}
