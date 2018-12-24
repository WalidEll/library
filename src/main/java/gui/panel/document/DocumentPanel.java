package gui.panel.document;

import controller.Catalogue;
import controller.SearchController;
import gui.event.SearchEvent;
import gui.listner.SearchListener;
import gui.panel.AdvencedSearchPanel;
import model.document.BibDocument;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;


public class DocumentPanel extends JPanel {

    private JTable docmentsTable;
    private DocumentTableModel tableModel;
    private AdvencedSearchPanel searchPanel;
    public DocumentPanel() {

        tableModel = new DocumentTableModel();
        docmentsTable = new JTable(tableModel);
        docmentsTable.getColumnModel().getColumn(0).setMinWidth(100);
        docmentsTable.getColumnModel().getColumn(0).setMaxWidth(100);
        docmentsTable.getColumnModel().getColumn(2).setMinWidth(75);
        docmentsTable.getColumnModel().getColumn(2).setMaxWidth(75);
        setLayout(new BorderLayout());
        JScrollPane jScrollPane=new JScrollPane(docmentsTable);
        jScrollPane.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10),BorderFactory.createTitledBorder("Catalogue")));
        add(jScrollPane, BorderLayout.CENTER);
        searchPanel=new AdvencedSearchPanel();
        add(searchPanel,BorderLayout.NORTH);
        searchPanel.setSearchListener(new SearchListener() {

            public void searchEventOccurred(SearchEvent e) {
                //TODO implement search from database
                //TODO replace homePanel with search results panel
                String search = e.getSearch();
                String type = e.getDocument_type();
                System.out.println(search + "Document panel"  + type);
                SearchController.getDocuments(search,type);
                setData(Catalogue.getInstance().getDocuments());

            }
        });
    }

    public void setData(List<BibDocument> data) {
        tableModel.setData(data);
        tableModel.fireTableDataChanged();
    }
}
