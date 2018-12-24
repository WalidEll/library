package gui.panel;

import controller.LoginController;
import gui.event.LoginEvent;
import gui.listner.LoginListener;
import model.utilisateur.Utilisateur;

import javax.security.auth.login.FailedLoginException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JButton btn_login;
    private LoginListener loginListener;


    public LoginPanel() {
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));

        btn_login = new JButton("Login");
        btn_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField username = new JTextField();
                JTextField password = new JPasswordField();
                Object[] message = {
                        "Username:", username,
                        "Password:", password
                };

                int option = JOptionPane.
                        showConfirmDialog(null,
                                message,
                                "Login",
                                JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    Utilisateur utilisateur = null;
                    try {

                        utilisateur = LoginController.login(username.getText(), password.getText());
                        System.out.println("Login successful");
                        LoginEvent loginEvent = new LoginEvent(utilisateur);

                        if (loginListener != null)
                            loginListener.loginEventOccurred(loginEvent);

                    } catch (FailedLoginException e1) {
                        JOptionPane.showMessageDialog(null,
                                e1.getMessage(),
                                "Login error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("Login canceled");
                }
            }

        });
        gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0, 400, 0, 0);
        gc.fill = GridBagConstraints.NONE;
        add(btn_login, gc);
    }

    public void setLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

}
