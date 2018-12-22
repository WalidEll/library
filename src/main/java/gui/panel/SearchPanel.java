package gui.panel;

import gui.event.SearchEvent;
import gui.listner.SearchListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {
    private JLabel lb_lbrary;
    private JTextField tf_search;
    private JButton btn_search;
    private SearchListener searchListener;


    public SearchPanel() {

        setLayout(new GridBagLayout());

        // First Row
        lb_lbrary = new JLabel("Master ISI Biblio");
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(10, 25, 0, 0);
        lb_lbrary.setFont(new Font("Arial", Font.BOLD, 46));

        gc.fill = GridBagConstraints.NONE;
        add(lb_lbrary, gc);
        // Second Row
        tf_search = new JTextField("Chercher un document ...");
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(10, 25, 0, 0);
        tf_search.setPreferredSize(new Dimension(225, 25));
        gc.fill = GridBagConstraints.NONE;
        add(tf_search, gc);
        // Third Row
        btn_search = new JButton("Search");
        btn_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String search = tf_search.getText();
                SearchEvent searchEvent = new SearchEvent(this, search);
                if (searchListener != null)
                    searchListener.searchEventOccurred(searchEvent);
            }
        });
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(10, 25, 0, 0);
        gc.fill = GridBagConstraints.NONE;
        add(btn_search, gc);
    }

    public void setSearchListener(SearchListener searchListener) {
        this.searchListener = searchListener;
    }

}
