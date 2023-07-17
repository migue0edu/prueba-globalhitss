package com.globalhitss.prueba.gestionempleados.controller;

import com.globalhitss.prueba.gestionempleados.persistence.entity.Empleado;
import com.globalhitss.prueba.gestionempleados.persistence.aggregates.EmpleadosSalarioCargoSummary;
import com.globalhitss.prueba.gestionempleados.persistence.aggregates.EmpleadoSalarioSummary;
import com.globalhitss.prueba.gestionempleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> getAll(){
        return ResponseEntity.ok(this.empleadoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado){
        if( empleado.getNombre() != "" && empleado.getCargo() != "" ){
            System.out.println(empleado.getNombre() + "; " + empleado.getCargo());
            return ResponseEntity.ok(this.empleadoService.save(empleado));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/salarioTotal")
    public ResponseEntity<List<EmpleadoSalarioSummary>> getSalarySummary(){
        return ResponseEntity.ok(this.empleadoService.getSummary());
    }

    @GetMapping("/salarioPorPuesto")
    public ResponseEntity<List<EmpleadosSalarioCargoSummary>> getSalaryByJobSummary(){
        return ResponseEntity.ok(this.empleadoService.getSalaryByJobPosition());
    }


}
