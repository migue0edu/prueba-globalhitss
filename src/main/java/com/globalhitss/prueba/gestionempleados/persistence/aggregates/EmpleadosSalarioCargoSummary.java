package com.globalhitss.prueba.gestionempleados.persistence.aggregates;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadosSalarioCargoSummary {
    private String cargo;
    private double salarioTotal;

}
