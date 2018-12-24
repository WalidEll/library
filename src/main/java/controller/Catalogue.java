package controller;

import model.document.*;

import java.util.*;

public class Catalogue {
    public static Map<String,String> tables=new HashMap<>();
    static {
        Map<String, String> aMap = new HashMap<>();
        aMap.put(Livre.class.toString(), "livre");
        aMap.put(BandDessinee.class.toString(), "bande_dessine");
        aMap.put(GuideVoyage.class.toString(), "guide_voyage");
        aMap.put(Revue.class.toString(), "revue");
        aMap.put(Roman.class.toString(), "roman");
        tables = Collections.unmodifiableMap(aMap);
    }
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
