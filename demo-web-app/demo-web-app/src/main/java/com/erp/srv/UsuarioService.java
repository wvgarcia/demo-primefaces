
package com.erp.srv;

import java.util.List;


public interface UsuarioService {
    List<String> selectAll();
    List<String> selectByUser(String pUser);
    public void insertarUsuario(String login, String passwd);
}