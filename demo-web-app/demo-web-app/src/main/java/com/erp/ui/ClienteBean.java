package com.erp.ui;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Bean para manejar el registro de clientes desde la página regcliente.xhtml
 */
@Component("cliente")
@Scope("session")
public class ClienteBean {

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;

    public String registrarCliente() {
        // Método simple de ejemplo: agrega un mensaje y permanece en la misma página
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Cliente registrado (simulado)"));
        System.out.println("log: cliente: " + nombre);
        System.out.println("log: apellido: " + apellido);
        System.out.println("log: correo: " + correo);

        return null; // quedarse en la misma página
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
