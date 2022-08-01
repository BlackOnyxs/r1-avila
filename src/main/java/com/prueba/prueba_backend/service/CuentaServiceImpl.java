
package com.prueba.prueba_backend.service;

import com.prueba.prueba_backend.models.Cuenta;
import com.prueba.prueba_backend.repositorio.CuentaDao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentaServiceImpl implements CuentaService {
    
    @Autowired
    private CuentaDao cuentaDao;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<Cuenta>> listarCuentas() {
        try{
            List<Cuenta> dbCuentas = new ArrayList();
            cuentaDao.findAll().forEach( c -> {
                if ( c.getEstado() != 0 ) {
                    dbCuentas.add( c );
                }
            });
            if ( dbCuentas.isEmpty() ) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(dbCuentas, HttpStatus.OK);
            }
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<Cuenta> obtenerCuenta(String idCuenta) {
        try {
           return new ResponseEntity<>(cuentaDao.findById(idCuenta).get(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional()
    public ResponseEntity<Cuenta> guardarCuenta(Cuenta cuenta) {
        try {
            cuenta.setIdCuenta(LocalDateTime.now().toString());
            var dbCuenta = cuentaDao.save(cuenta);
            return new ResponseEntity<>(dbCuenta, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<Cuenta> actualizarCuenta(Cuenta cuenta, String cuentaId) {
        try {
            var dbCuenta = cuentaDao.findById(cuentaId).orElse(null);
            if ( dbCuenta != null ) {
                cuenta.setIdCuenta(cuentaId);
                return new ResponseEntity<>(cuentaDao.save(cuenta), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @Override
    @Transactional()
    public ResponseEntity<Cuenta> eliminarCuenta(String idCuenta) {
        try {
            var dbCuenta = cuentaDao.findById(idCuenta).orElse(null);
            if ( dbCuenta != null ) {
                Cuenta.class.cast(dbCuenta).setEstado(0);
                return new ResponseEntity<>(cuentaDao.save(Cuenta.class.cast(dbCuenta)), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch(Exception e) {
             return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
