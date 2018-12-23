package gui;

import gui.event.SearchEvent;
import gui.listner.SearchListener;
import gui.event.LoginEvent;
import gui.listner.LoginListener;
import gui.panel.SearchPanel;
import gui.panel.LoginPanel;
import gui.panel.ConnectedPanel;

import controller.Catalogue;
import controller.SearchController;
import gui.listner.MainFramePanelSwitchListener;
import gui.panel.HomePanel;
import gui.panel.document.DocumentPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements MainFramePanelSwitchListener {

    private SearchPanel searchPanel = new SearchPanel();
    private LoginPanel loginPanel = new LoginPanel();
    private ConnectedPanel ConnectedPanel = new ConnectedPanel();
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

        // adding search Panel
        add(searchPanel, BorderLayout.CENTER);
        searchPanel.setSearchListener(new SearchListener() {

            public void searchEventOccurred(SearchEvent e) {
                //TODO implement search from database
                //TODO replace searchPanel with search results panel
                String search = e.getSearch();
                System.out.println(search);
                remove(searchPanel);
                repaint();
                // Todo : remove this block for test purposes only
                // start
                System.out.println("Started....");
                final long requested = System.currentTimeMillis();


                new Thread(new Runnable() {
                    public void run() {
                        while (true) {
                            try {
                                long leftToSleep = requested + 1000 - System.currentTimeMillis();
                                if (leftToSleep > 0) {
                                    Thread.sleep(leftToSleep);
                                }
                                add(searchPanel);
                                repaint();
                                break;
                            } catch (InterruptedException ignored) {
                            }
                        }
                    }
                }).start();

            }
            // end

        });
        add(loginPanel, BorderLayout.SOUTH);
        loginPanel.setLoginListener(new LoginListener() {
            public void loginEventOccurred(LoginEvent e) {
                //TODO implement login from database
                String username = e.getUsername();
                String password = e.getPassword();
                remove(loginPanel);
                JLabel userlabel = new JLabel();
                userlabel.setText("-" +username+ "-");
                add(ConnectedPanel, BorderLayout.SOUTH);
                ConnectedPanel.add(userlabel);
                invalidate();
                validate();
            }

        });

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
