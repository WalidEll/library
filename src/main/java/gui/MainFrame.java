package gui;

import controller.Catalogue;
import controller.Session;
import gui.event.LoginEvent;
import gui.listner.LoginListener;
import gui.listner.MainFramePanelSwitchListener;
import gui.panel.ConnectedPanel;
import gui.panel.HomePanel;
import gui.panel.LoginPanel;
import gui.panel.document.DocumentPanel;
import model.utilisateur.Utilisateur;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements MainFramePanelSwitchListener {

    public static final String HOME_PANEL = "home_panel";
    public static final String DOCUMENT_PANEL = "document_panel";
    public static final String LOGIN_PANEL = "login_panel";
    public static final String CONNECTED_PANEL = "connected_panel";
    private ConnectedPanel connectedPanel;
    private HomePanel homePanel;
    private DocumentPanel documentPanel;
    private LoginPanel loginPanel;
    private JPanel center_cards, south_cards;

    MainFrame() {
        super("Bibliotheque");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // TODO center panel
        homePanel = new HomePanel();
        documentPanel = new DocumentPanel();
        center_cards = new JPanel(new CardLayout());
        center_cards.add(homePanel, HOME_PANEL);
        homePanel.setMainFramePanelSwitchListener(this);
        center_cards.add(documentPanel, DOCUMENT_PANEL);
        add(center_cards, BorderLayout.CENTER);
        // TODO bottom panel
        south_cards = new JPanel(new CardLayout());
        loginPanel = new LoginPanel();
        south_cards.add(loginPanel, LOGIN_PANEL);
        connectedPanel = new ConnectedPanel();
        south_cards.add(connectedPanel, CONNECTED_PANEL);
        loginPanel.setLoginListener(e -> {
            Session.getInstance().setUtilisateur(e.getUsername());
            connectedPanel.updateContent();

            CardLayout cl = (CardLayout) (south_cards.getLayout());
            cl.show(south_cards, CONNECTED_PANEL);
        });
        connectedPanel.setLogoutListener(() -> {
            Session.getInstance().destroy();
            CardLayout cl = (CardLayout) (south_cards.getLayout());
            cl.show(south_cards, LOGIN_PANEL);
        });
        add(south_cards, BorderLayout.SOUTH);

    }

    public void onCenterChangeListener(String panel) {
        if (panel.equals(DOCUMENT_PANEL))
            documentPanel.setData(Catalogue.getInstance().getDocuments());
        CardLayout cl = (CardLayout) (center_cards.getLayout());
        cl.show(center_cards, panel);
    }

    public void onSouthChangeListener(String panel) {

    }
}
