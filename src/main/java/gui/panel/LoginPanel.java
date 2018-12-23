package gui.panel;

import gui.event.LoginEvent;
import gui.listner.LoginListener;
import gui.listner.LoginListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JButton btn_login;
    private LoginListener loginListener;


    public LoginPanel() {
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(new GridBagLayout());


        btn_login = new JButton("Login");
        btn_login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField username = new JTextField();
                JTextField password = new JPasswordField();
                Object[] message = {
                        "Username:", username,
                        "Password:", password
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    if (username.getText().equals("walid") && password.getText().equals("1234")) {
                        System.out.println("Login successful");
                        String user = username.getText();
                        String pass = password.getText();
                        LoginEvent loginEvent = new LoginEvent(this, user, pass);
                        if (loginListener != null)
                            loginListener.loginEventOccurred(loginEvent);
                    } else {
                        System.out.println("login failed");
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
