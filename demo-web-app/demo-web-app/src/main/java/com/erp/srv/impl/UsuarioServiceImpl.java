package com.erp.srv.impl;

import com.erp.srv.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.erp.config.DataSourceConfig;

import java.util.List;
import org.springframework.dao.DataAccessException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final JdbcTemplate jdbcTemplate;

    //esto reemplaza el getConexion()
    @Autowired
    public UsuarioServiceImpl(DataSourceConfig dataSource) {
        System.out.println("Ingresa al Constructor UsuarioServiceImpl ");
        this.jdbcTemplate = new JdbcTemplate(dataSource.dataSource());
    }

    @Override
    public List<String> selectAll() {
        try {
            System.out.println("ingresa metodo selectAll");
            String sql = "SELECT passwd FROM PUBLIC.usuarios_sistemas";
            System.out.println("ingresa a realizar la query del sistema.");
            return jdbcTemplate.query(sql, (rs, rowNum) -> rs.getString("passwd"));
        } catch (DataAccessException e) {
            // Handle exceptions here, e.g., log the error or throw a more specific exception
            System.out.println("Error executing query: " + e.getMessage());
            throw new RuntimeException(e); // Or throw a more specific exception
        }
    }

    /**
     * metodo que devuelve el password de un login del sistema.
     *
     * @param pUser
     * @return
     */
    @Override
    public List<String> selectByUser(String pUser) {
        try {
            System.out.println("Ingresa al metodo selectByUser");
            String sql = "select passwd  from PUBLIC.usuarios_sistemas where login = ?";
            System.out.println("ingresa a realizar la query del sistema.");
            return jdbcTemplate.query(sql, new Object[]{pUser}, (rs, rowNum) -> rs.getString("passwd"));
        } catch (DataAccessException e) {
            System.out.println("Error executing query: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * metodo para insert usuarios en la db.
     * @param login
     * @param passwd 
     */
    @Override
    public void insertarUsuario(String login, String passwd) {

        try {
            String sql = "INSERT INTO public.usuarios_sistemas (login,passwd) VALUES (?, ?)";
            jdbcTemplate.update(sql, login,passwd);

        } catch (DataAccessException e) {
            System.out.println("Error executing query: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
