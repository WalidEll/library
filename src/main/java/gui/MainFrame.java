package gui;

import gui.event.SearchEvent;
import gui.listner.SearchListener;
import gui.panel.SearchPanel;

import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {

    private SearchPanel searchPanel = new SearchPanel();

    MainFrame() {
        super("Bibliotheque");
        setSize(500, 400);
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

        // TODO create authentication panel
    }
}
