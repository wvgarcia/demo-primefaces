package com.erp.ui;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.erp.srv.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import com.erp.dto.ClienteDto;

/**
 * Bean para manejar el registro de clientes desde la página regcliente.xhtml
 */
@Component("cliente")
@Scope("session")
public class ClienteBean {

    @Autowired
    private ClienteService clienteSrv;

    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;

    /*
     * metodo que sirve para registrar un cliente en el sistema.
     * grega un mensaje y permanece en la misma página
     */
    public String registrarCliente() {
        ClienteDto cliente = new ClienteDto();

        try {
            cliente.setApellido(apellido);
            cliente.setNombre(nombre);
            cliente.setCorreo(correo);
            cliente.setTelefono(telefono);
            cliente.setDireccion(direccion);

            clienteSrv.registrarCliente(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Cliente registrado (simulado)"));

        } catch (Exception e) {
            System.err.println("Error during registro cliente process: " + e.toString());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "al crar usuario"));

        }

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
