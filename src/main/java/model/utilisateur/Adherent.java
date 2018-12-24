package model.utilisateur;

import java.util.Date;

public class Adherent {
    private Integer adherent_id;
    private String nom;
    private String prenom;
    private String adress;
    private String telephone;
    private Date dateInscription;
    private Date datePayment;

    public Adherent(Integer adherent_id, String nom, String prenom, String adress, String telephone, Date dateInscription, Date datePayment) {
        this.adherent_id = adherent_id;
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.telephone = telephone;
        this.dateInscription = dateInscription;
        this.datePayment = datePayment;
    }

    public Integer getAdherent_id() {
        return adherent_id;
    }

    public void setAdherent_id(Integer adherent_id) {
        this.adherent_id = adherent_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }
}
