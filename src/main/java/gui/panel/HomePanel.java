package gui.panel;

import gui.MainFrame;
import gui.listner.MainFramePanelSwitchListener;
import gui.event.SearchEvent;
import gui.listner.SearchListener;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    private JLabel lb_lbrary;
    private AdvencedSearchPanel searchPanel;
    private MainFramePanelSwitchListener mainFramePanelSwitchListener;
    public HomePanel() {

        setLayout(new GridBagLayout());

        // First Row
        lb_lbrary = new JLabel("Master ISI Biblio");
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        lb_lbrary.setFont(new Font("Arial", Font.BOLD, 46));

        gc.fill = GridBagConstraints.NONE;
        add(lb_lbrary, gc);
        // Second Row
        searchPanel = new AdvencedSearchPanel();
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 1;
        gc.fill = GridBagConstraints.NONE;
        add(searchPanel, gc);
        searchPanel.setSearchListener(new SearchListener() {
            public void searchEventOccurred(SearchEvent e) {
                //TODO implement search from database
                //TODO replace homePanel with search results panel
                String search = e.getSearch();
                String type = e.getDocument_type();
                System.out.println(search + "Home Panel" + type);
                mainFramePanelSwitchListener.onCenterChangeListener(MainFrame.DOCUMENT_PANEL);
            }
        });

    }

    public void setMainFramePanelSwitchListener(MainFramePanelSwitchListener mainFrame) {
        mainFramePanelSwitchListener=mainFrame;
    }
}
