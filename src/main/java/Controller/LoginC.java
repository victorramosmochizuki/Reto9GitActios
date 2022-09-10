package Controller;

import dao.LoginImpl;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Login;


@Named(value = "loginCon")
@SessionScoped
public class LoginC implements Serializable {

    private boolean admin;
    private boolean users;
    private boolean admin2;

    private Login usuario = new Login();

    //Variables de Logeo
    private String User;
    private String Pass;
    private String block;
    private int intentos, number;

    public void increment() {
        number++;
        if (number > 5) {
            number = 0;
            intentos = 0;
        }
    }

    public void startSession() throws Exception {
        LoginImpl dao;
        try {
            dao = new LoginImpl();
            usuario = dao.starEdition(User, Pass);
            if (usuario != null) {
                intentos = 0;
                block = "PF('bloc').hide()";
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", usuario);
                switch (usuario.getTIPPER()) {
                    case "3":
                        users = true;
                        admin = false;
                        admin2 = false;
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/SistIsoptec_Maven/faces/vista/adquisicion/adquisicionV.xhtml"); ///Fractal/faces/vistas/notas/notas.xhtml
                        break;
                    case "2":
                        users = false;
                        admin2 = false;
                        admin = true;
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/SistIsoptec_Maven/faces/vistas/equipo/equipoT.xhtml");
                        break;
                    case "1":
                        users = false;
                        admin = false;
                        admin2 = true;
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/SistIsoptec_Maven/faces/vista/dequipo/dequipoV.xhtml");
                        break;
                }
            } else {
                setPass(null);
                usuario = new Login();
                intentos++;
                if (intentos == 3) {
                    block = "PF('bloc').show()";
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contraseña/Usuario Incorrecto"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void finishSession() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear(); //Cierra la Session
        FacesContext.getCurrentInstance().getExternalContext().redirect("/H19_07"); // Mandamos al Login
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isUsers() {
        return users;
    }

    public void setUsers(boolean users) {
        this.users = users;
    }

    public boolean isAdmin2() {
        return admin2;
    }

    public void setAdmin2(boolean admin2) {
        this.admin2 = admin2;
    }

    public Login getUsuario() {
        return usuario;
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
