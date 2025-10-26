package com.erp.srv.impl;

import com.erp.srv.ClienteService;
import com.erp.dto.ClienteDto;
import com.erp.config.DataSourceConfig;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final JdbcTemplate jdbcTemplate;

    /*
     * Constructor que recibe el DataSourceConfig para inicializar JdbcTemplate
     */
    public ClienteServiceImpl(DataSourceConfig datasource) {
        System.out.println("Ingresa al Constructor ClienteServiceImpl ");
        this.jdbcTemplate = new JdbcTemplate(datasource.dataSource());
    }



    @Override
    public void registrarCliente(ClienteDto cliente) {
        // Aquí iría la lógica para registrar el cliente en la base de datos
        System.out.println("Registrando cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        // Lógica de persistencia simulada
    }   

}
