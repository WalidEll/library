package gui.panel.document;

import model.document.BibDocument;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class DocumentTableModel extends AbstractTableModel {
    private List<BibDocument> documents;

    private String[] columnsName={"ISBN","TITRE"};

    public DocumentTableModel() {
        documents=new ArrayList<BibDocument>();
    }

    public int getRowCount() {
        return documents.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnsName[column];
    }

    public int getColumnCount() {
        return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        BibDocument document = documents.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return document.getIsbn();
            case 1:
                return document.getTitre();
        }
        return null;
    }

    public void setData(List<BibDocument> data) {
        documents = data;
    }
}
