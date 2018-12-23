package controller;

import model.document.BibDocument;
import model.document.EtatDocument;
import model.document.Livre;

import java.util.ArrayList;
import java.util.List;

public class SearchController {


    public static void getDocuments(String search, String type) {
        List<BibDocument> bibDocuments = new ArrayList<BibDocument>();
        if (Catalogue.getInstance().getDocuments().isEmpty()) {

            //Todo get data from database
            bibDocuments.add(new Livre("9782070584628", "Harry Potter, I : Harry Potter à l'école des sorciers", EtatDocument.Bon, "J. K. Rowling", "Folio Junior"));
            bibDocuments.add(new Livre("9782070584628", "Harry Potter, I : Harry Potter à l'école des sorciers", EtatDocument.Bon, "J. K. Rowling", "Folio Junior"));
            bibDocuments.add(new Livre("9782070584628", "Harry Potter, I : Harry Potter à l'école des sorciers", EtatDocument.Bon, "J. K. Rowling", "Folio Junior"));
            bibDocuments.add(new Livre("9782070584628", "Harry Potter, I : Harry Potter à l'école des sorciers", EtatDocument.Bon, "J. K. Rowling", "Folio Junior"));
            bibDocuments.add(new Livre("9782070584628", "Harry Potter, I : Harry Potter à l'école des sorciers", EtatDocument.Bon, "J. K. Rowling", "Folio Junior"));
            bibDocuments.add(new Livre("9782070584628", "Harry Potter, I : Harry Potter à l'école des sorciers", EtatDocument.Bon, "J. K. Rowling", "Folio Junior"));
            bibDocuments.add(new Livre("9782070584628", "Harry Potter, I : Harry Potter à l'école des sorciers", EtatDocument.Bon, "J. K. Rowling", "Folio Junior"));
            bibDocuments.add(new Livre("9782070584628", "Harry Potter, I : Harry Potter à l'école des sorciers", EtatDocument.Bon, "J. K. Rowling", "Folio Junior"));
            Catalogue.getInstance().replace(bibDocuments);

        } else {
            Catalogue.getInstance().add(new Livre("9782070534638", "Harry Potter, II ", EtatDocument.Bon, "J. K. Rowling", "Folio Junior"));

        }

    }
}
