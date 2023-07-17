package com.globalhitss.prueba.gestionempleados.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "Empleado")
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private String cargo;
    private double salario;

}
