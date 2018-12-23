package gui.panel;

import controller.SearchController;
import gui.event.SearchEvent;
import gui.listner.SearchListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvencedSearchPanel extends JPanel {
    private JTextField tf_search;
    private JButton btn_search;
    private JRadioButton rd_roman;
    private JRadioButton rd_bd;
    private JRadioButton rd_livre;
    private JRadioButton rd_gvoyage;
    private JRadioButton rd_revue;
    private ButtonGroup documentGroup;
    private SearchListener searchListener;

    public AdvencedSearchPanel() {
        setBorder(new CompoundBorder(new EmptyBorder(10, 10, 0, 10), BorderFactory.createTitledBorder("Chercher")));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        tf_search = new JTextField("");
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridwidth = 6;
        gc.gridx = 0;
        gc.gridy = 0;
        add(tf_search, gc);

        //buttons
        rd_roman = new JRadioButton("Roman");
        rd_bd = new JRadioButton("Band Dessinee");
        rd_livre = new JRadioButton("Livre");
        rd_gvoyage = new JRadioButton("Guide Voyage");
        rd_revue = new JRadioButton("Revue");
        documentGroup = new ButtonGroup();
        documentGroup.add(rd_roman);
        documentGroup.add(rd_bd);
        documentGroup.add(rd_livre);
        documentGroup.add(rd_gvoyage);
        documentGroup.add(rd_revue);

        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 1;
        add(rd_roman, gc);
        rd_roman.setActionCommand("roman");

        gc = new GridBagConstraints();
        gc.gridx = 1;
        gc.gridy = 1;
        add(rd_bd, gc);

        gc = new GridBagConstraints();
        gc.gridx = 2;
        gc.gridy = 1;
        add(rd_livre, gc);

        gc = new GridBagConstraints();
        gc.gridx = 3;
        gc.gridy = 1;
        add(rd_gvoyage, gc);

        gc = new GridBagConstraints();
        gc.gridx = 4;
        gc.gridy = 1;
        add(rd_revue, gc);


        gc = new GridBagConstraints();
        btn_search = new JButton("Chercher");
        gc.gridx = 5;
        gc.gridy = 1;
        add(btn_search, gc);
        btn_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String search = tf_search.getText();
                String document_type = documentGroup.getSelection().getActionCommand();
                SearchEvent searchEvent = new SearchEvent(this, search, document_type);
                if (searchListener != null)
                    searchListener.searchEventOccurred(searchEvent);
            }
        });
    }

    public void setSearchListener(SearchListener searchListener) {
        this.searchListener = searchListener;
    }

}
