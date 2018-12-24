package model.document;

public class BandDessinee extends BibDocument {
    private String collection;
    private String dessin;
    private String senario;
    private String editeur;


    public BandDessinee(Integer id,String isbn, String titre, EtatDocument etat, String collection, String dessin, String senario, String editeur) {
        super(id,isbn, titre, etat);
        this.collection = collection;
        this.dessin = dessin;
        this.senario = senario;
        this.editeur = editeur;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getDessin() {
        return dessin;
    }

    public void setDessin(String dessin) {
        this.dessin = dessin;
    }

    public String getSenario() {
        return senario;
    }

    public void setSenario(String senario) {
        this.senario = senario;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }
}
