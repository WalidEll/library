package controller;

import database.DBSingleton;
import model.document.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchController {


    public static void getDocuments(String search, String type) {
        List<BibDocument> bibDocuments = new ArrayList<BibDocument>();

        try (Statement statement = DBSingleton.getInstance().getConnection().createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM " + Catalogue.tables.get(type) + " WHERE isbn like '%" + search + "%' OR titre LIKE '%" + search + "%'")) {

            while (rs.next()) {
                BibDocument document = null;
                if (type.equals(Roman.class.toString())) {
                    document = new Roman(rs.getInt("id"),rs.getString("isbn"),
                            rs.getString("titre"),
                            EtatDocument.valueOf(rs.getString("etat")),
                            rs.getString("auteur"),
                            rs.getString("editeur"));
                }else if (type.equals(Livre.class.toString())){
                    document=new Livre(rs.getInt("id"),rs.getString("isbn"),
                            rs.getString("titre"),
                            EtatDocument.valueOf(rs.getString("etat")),
                            rs.getString("auteur"),
                            rs.getString("editeur"));
                }else if (type.equals(GuideVoyage.class.toString())){
                    document=new GuideVoyage(rs.getInt("id"),rs.getString("isbn"),
                            rs.getString("titre"),
                            EtatDocument.valueOf(rs.getString("etat")));
                }else if (type.equals(BandDessinee.class.toString())){
                    document=new BandDessinee(rs.getInt("id"),rs.getString("isbn"),
                            rs.getString("titre"),
                            EtatDocument.valueOf(rs.getString("etat")),rs.getString("collection"),
                            rs.getString("dessin"),
                            rs.getString("senario"),
                            rs.getString("editeur"));
                }
                bibDocuments.add(document);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Catalogue.getInstance().replace(bibDocuments);
    }

}
