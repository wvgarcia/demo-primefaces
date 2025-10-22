/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erp.ui;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.erp.srv.UsuarioService;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author wvgarcia
 */
@Component("loginBean")
@Scope("session")
public class LoginBean {

    private static final Logger logger = LoggerFactory.getLogger(LoginBean.class);

//    inyeccion de depencias  IoC
    @Autowired
    private UsuarioService userSrv;
    
    private String username;
    private String password;
    private boolean loggedIn;

    public String login() {

        try {
            String vResult = "error login";
            if (username != null && password != null) {
                List<String> pv = userSrv.selectByUser(this.getUsername());
                if (!pv.isEmpty()) {
                    if (this.getPassword().equals(pv.get(0))) {
                        System.out.println("logeado correctamente " + pv.get(0));
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Login correcto"));
                        //aqui debe ir la logica de recuperar los roles del usuario.
                        loggedIn = true;
                        vResult = "true";
                    } else {
                        System.out.println("logeo incorrecto.");
                        loggedIn = false;
                        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en credenciales", "Las credenciales no son correctas."));
    
                    }
                }

            } else {
                loggedIn = false;
                System.out.println("fallo en login debe ingresar password o login");
                logger.debug("Error en realizar inicio de session.");
                FacesContext.getCurrentInstance().
                        addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en credenciales", "Las credenciales no son correctas."));
                return "login?faces-redirect=true";
            }
            return vResult;
        } catch (Exception e) {
            // Handle exceptions here, e.g., log the error and redirect to a specific error page
            System.out.println("Error during login process: " + e.toString());
            logger.error("An error occurred during login: " + e.getMessage());
            return "error?faces-redirect=true"; // Redirect to error page
        }
    }
    
    /**
     * 
     */
    public void nuevoUsuario(){
        
        try {
            
        } catch (Exception e) {
        }
        
    }

    public String logout() {
        username = null;
        password = null;
        loggedIn = false;
        return "login?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
    
}
