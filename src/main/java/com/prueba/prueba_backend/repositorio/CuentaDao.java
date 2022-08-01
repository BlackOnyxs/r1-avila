/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prueba.prueba_backend.repositorio;

import com.prueba.prueba_backend.models.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BlackOnyxs
 */

public interface CuentaDao extends CrudRepository<Cuenta, String>{
    
}
