package com.erp.ui;

import com.erp.srv.UsuarioService;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author gisistemas
 */
@Component("registro")
public class RegistrarUI {

    private String usuario;
    private String clave;

    @Autowired
    private UsuarioService userSrv;

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    /**
     * metodo que registra el usuario nuevo.
     * @return 
     */
    public String registrarUsuario() {
        System.out.println("Usuario recibido: " + usuario);
        try {
            userSrv.insertarUsuario(usuario, clave);
            FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Nuevo usuario"));
            
        } catch (Exception e) {
            System.err.println("Error during login process: " + e.toString());  
        }
        FacesContext.getCurrentInstance().
                                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "al crar usuario"));

        return "login?faces-redirect=true"; 
    }
}
