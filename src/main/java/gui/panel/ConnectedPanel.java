package gui.panel;

import gui.event.LogoutEvent;
import gui.event.LoginEvent;
import gui.listner.LogoutListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectedPanel extends JPanel {
    private JButton btn_logout;
    private JButton emprunt;
    private JButton clients;
    private LogoutListener logoutListener;


    public ConnectedPanel() {
        GridBagConstraints gc = new GridBagConstraints();

        setLayout(new GridBagLayout());

        emprunt = new JButton("Gest. emprunt");
        clients = new JButton("Gest. Client");
        btn_logout = new JButton("Logout");
        btn_logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }

        });
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.EAST;
        add(emprunt, gc);
        gc.gridx = 2;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.EAST;
        add(clients, gc);
        gc.gridx = 4;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.WEST;
        add(btn_logout, gc);
        System.out.println("connectedPanel");


    }

    public void setLogoutListener(LogoutListener loginListener) {
        this.logoutListener = loginListener;
    }

}
