package com.globalhitss.prueba.gestionempleados.persistence.repository;

import com.globalhitss.prueba.gestionempleados.persistence.entity.Empleado;
import com.globalhitss.prueba.gestionempleados.persistence.aggregates.EmpleadosSalarioCargoSummary;
import com.globalhitss.prueba.gestionempleados.persistence.aggregates.EmpleadoSalarioSummary;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface EmpleadoRepository extends MongoRepository<Empleado, String> {

//    @Query("db.Empleado.aggregate(" +
//            "[" +
//            "  { $group: { _id: null, sum_val: { $sum: \"$salario\" } } }" +
//            "]" +
//            ")")
//    EmpleadoSummary findSummary( );

    @Aggregation(pipeline = "{ $group: { _id: null, salarioTotal: { $sum: \"$salario\" } } }")
    List<EmpleadoSalarioSummary> getSalarioTotal();

    @Aggregation(pipeline = {
        "{ $group: { _id: \"$cargo\", salarioTotal: { $sum: \"$salario\" } } }",
        "{ $addFields: { cargo: \"$_id\" }}",
        "{ $project: { _id: 0 } }" })
    List<EmpleadosSalarioCargoSummary> getSalarioTotalByJobPosition();

}
