package com.globalhitss.prueba.gestionempleados.service;

import com.globalhitss.prueba.gestionempleados.persistence.entity.Empleado;
import com.globalhitss.prueba.gestionempleados.persistence.aggregates.EmpleadosSalarioCargoSummary;
import com.globalhitss.prueba.gestionempleados.persistence.aggregates.EmpleadoSalarioSummary;
import com.globalhitss.prueba.gestionempleados.persistence.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getAll( ){
         List<Empleado> employees = this.empleadoRepository.findAll();
         return  employees;
    }

    public Empleado save(Empleado employee){
       return this.empleadoRepository.save(employee);
    }

    public List<EmpleadoSalarioSummary> getSummary( ){
        return this.empleadoRepository.getSalarioTotal();
    }

    public List<EmpleadosSalarioCargoSummary> getSalaryByJobPosition( ){
        return this.empleadoRepository.getSalarioTotalByJobPosition();
    }


}
