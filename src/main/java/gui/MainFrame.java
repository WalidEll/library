package gui;

import controller.Catalogue;
import controller.SearchController;
import gui.listner.MainFramePanelSwitchListener;
import gui.panel.HomePanel;
import gui.panel.document.DocumentPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements MainFramePanelSwitchListener {

    public static final String HOME_PANEL = "home_panel";
    public static final String DOCUMENT_PANEL = "document_panel";
    private HomePanel homePanel;
    private DocumentPanel documentPanel;
    private JPanel cards;

    MainFrame() {
        super("Bibliotheque");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // TODO center panel
        homePanel = new HomePanel();
        documentPanel=new DocumentPanel();
        cards=new JPanel(new CardLayout());
        cards.add(homePanel, HOME_PANEL);
        homePanel.setMainFramePanelSwitchListener(this);
        cards.add(documentPanel, DOCUMENT_PANEL);
        add(cards, BorderLayout.CENTER);
        // TODO bottom panel
    }
    public void onCenterChangeListener(String panel) {
        if (panel.equals(DOCUMENT_PANEL))
            documentPanel.setData(Catalogue.getInstance().getDocuments());
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, panel);
    }

    public void onSouthChangeListener(String panel) {

    }
}
