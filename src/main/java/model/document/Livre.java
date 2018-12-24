package model.document;

public class Livre extends BibDocument {
    private String auteur;
    private String editeur;

    public Livre(Integer id,String isbn, String titre, EtatDocument etat, String auteur, String editeur) {
        super(id,isbn, titre, etat);
        this.auteur = auteur;
        this.editeur = editeur;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }
}
