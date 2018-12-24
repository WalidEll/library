package gui.panel;

import controller.Session;
import gui.listner.LogoutListener;
import model.utilisateur.Employe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectedPanel extends JPanel {
    private JButton btn_logout;
    private JButton emprunt;
    private JButton clients;
    private JLabel lb_user;
    private LogoutListener logoutListener;


    public ConnectedPanel() {

        setLayout(new GridBagLayout());

        lb_user = new JLabel();
        emprunt = new JButton("Gest. emprunt");
        clients = new JButton("Gest. Client");
        btn_logout = new JButton("Logout");
        btn_logout.addActionListener(e -> logoutListener.logoutEventOccurred());


    }

    public void setLogoutListener(LogoutListener loginListener) {
        this.logoutListener = loginListener;
    }

    public void updateContent() {
        if (Session.getInstance().getUtilisateur() instanceof Employe) {
            lb_user.setText("["+((Employe)Session.getInstance().getUtilisateur()).getRoleEmploye()+"] "+((Employe)Session.getInstance().getUtilisateur()).getUsername());
            GridBagConstraints gc = new GridBagConstraints();
            gc.gridx = 0;
            gc.gridy = 0;
            gc.insets = new Insets(0, 10, 0, 10);
            this.add(lb_user, gc);
            gc = new GridBagConstraints();
            gc.gridx = 1;
            gc.gridy = 0;
            gc.insets = new Insets(0, 10, 0, 10);
            this.add(emprunt, gc);
            gc = new GridBagConstraints();
            gc.gridx = 2;
            gc.gridy = 0;
            gc.insets = new Insets(0, 10, 0, 10);
            this.add(clients, gc);
            gc = new GridBagConstraints();
            gc.gridx = 3;
            gc.gridy = 0;
            gc.insets = new Insets(0, 10, 0, 10);
            this.add(btn_logout, gc);
        }
    }
}
