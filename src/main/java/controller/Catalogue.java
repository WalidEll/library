package controller;

import model.document.BibDocument;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private List<BibDocument> catalogue;
    private static Catalogue instance=null;
    private Catalogue() {
        this.catalogue = new ArrayList<BibDocument>();
    }
    public static Catalogue getInstance(){
        if (instance ==null)
            instance=new Catalogue();
        return instance;
    }

    public void add(BibDocument document) {
        this.catalogue.add(document);
    }

    public void replace(List<BibDocument> documents) {
        this.catalogue = documents;
    }
    public  List<BibDocument> getDocuments(){
        return this.catalogue;
    }
    public BibDocument getDocument(int index){
        return catalogue.get(index);
    }
}
