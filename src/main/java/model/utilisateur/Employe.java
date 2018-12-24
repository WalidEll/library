package model.utilisateur;

public class Employe extends Utilisateur{
    private Integer id;
    private RoleEmploye roleEmploye;

    public Employe(String username, Integer id, RoleEmploye roleEmploye) {
        super(username);
        this.id = id;
        this.roleEmploye = roleEmploye;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleEmploye getRoleEmploye() {
        return roleEmploye;
    }

    public void setRoleEmploye(RoleEmploye roleEmploye) {
        this.roleEmploye = roleEmploye;
    }
}
