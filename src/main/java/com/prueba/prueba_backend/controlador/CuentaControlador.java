
package com.prueba.prueba_backend.controlador;

import com.prueba.prueba_backend.models.Cuenta;
import com.prueba.prueba_backend.service.CuentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class CuentaControlador {
    
    @Autowired
    private CuentaService cuentaService;
    
    @GetMapping("/accounts")
    public ResponseEntity<List<Cuenta>> cuentas(){
        return cuentaService.listarCuentas();
    }
    
    @GetMapping("/accounts/{idCuenta}")
    private ResponseEntity<Cuenta> obtenerCuenta(@PathVariable("idCuenta") String idCuenta){
        return cuentaService.obtenerCuenta(idCuenta);
    }
    
    @PostMapping("/accounts")
    private ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaService.guardarCuenta(cuenta);
    }
    
    @PutMapping("/accounts/{idCuenta}")
    private ResponseEntity<Cuenta> actualizarCuenta(@RequestBody Cuenta cuenta, @PathVariable("idCuenta") String idCuenta){
        return cuentaService.actualizarCuenta(cuenta, idCuenta);
    }
    
    @DeleteMapping("/accounts/{idCuenta}")
    private ResponseEntity<Cuenta> eliminarCuenta(@PathVariable("idCuenta") String idCuenta){
        return cuentaService.eliminarCuenta(idCuenta);
    }
    
}
