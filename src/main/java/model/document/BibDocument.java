package model.document;

public abstract class BibDocument {
    private String isbn;
    private String titre;
    private EtatDocument etat;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public EtatDocument getEtat() {
        return etat;
    }

    public void setEtat(EtatDocument etat) {
        this.etat = etat;
    }
}
