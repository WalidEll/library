package model.document;

public abstract class BibDocument {
    private Integer id;
    private String isbn;
    private String titre;
    private EtatDocument etat;

    BibDocument(Integer id,String isbn, String titre, EtatDocument etat) {
        this.id=id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
