package controller;

import database.DBSingleton;
import model.utilisateur.Employe;
import model.utilisateur.RoleEmploye;
import model.utilisateur.Utilisateur;

import javax.security.auth.login.FailedLoginException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    public static Utilisateur login(String username, String password) throws FailedLoginException {
        Utilisateur utilisateur = null;
        try (Statement statement = DBSingleton.getInstance().getConnection().createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM EMPLOYE WHERE username like '" + username + "'")) {

            while (rs.next()) {

                if (password.equals(rs.getString("password"))) {
                    RoleEmploye role = null;
                    switch (rs.getInt("role_emp")) {
                        case 1:
                            role = RoleEmploye.ASSISTANT;
                            break;
                        case 2:
                            role = RoleEmploye.BIBLIOTHECAIRE;
                            break;
                    }
                    utilisateur = new Employe(
                            rs.getString("username"), rs.getInt("ID_Emp"), role);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (utilisateur==null)
            throw new FailedLoginException("username or password error try again.");
        return utilisateur;
    }
}
