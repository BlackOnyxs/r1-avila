
package com.prueba.prueba_backend.service;

import com.prueba.prueba_backend.models.Cuenta;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface CuentaService {
    public ResponseEntity<List<Cuenta>> listarCuentas();
    
    public ResponseEntity<Cuenta> obtenerCuenta(String idCuenta);
    
    public ResponseEntity<Cuenta> guardarCuenta(Cuenta cuenta);
    
    public ResponseEntity<Cuenta> actualizarCuenta(Cuenta cuenta, String cuentaId);
    
    public ResponseEntity<Cuenta> eliminarCuenta(String idCuenta);
    
    
    
}
