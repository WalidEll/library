package model.document;

public abstract class BibDocument {
    private String isbn;
    private String titre;
    private EtatDocument etat;

    BibDocument(String isbn, String titre, EtatDocument etat) {
        this.isbn = isbn;
        this.titre = titre;
        this.etat = etat;
    }

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
