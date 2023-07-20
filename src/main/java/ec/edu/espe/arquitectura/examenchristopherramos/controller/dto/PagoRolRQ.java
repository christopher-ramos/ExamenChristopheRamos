package ec.edu.espe.arquitectura.examenchristopherramos.controller.dto;

import java.util.List;

import ec.edu.espe.arquitectura.examenchristopherramos.model.EmpleadoPago;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PagoRolRQ {

    private Integer mes;
    private String rucEmpresa;
    private String cuentaPrincipal;
    private List<EmpleadoPago> empleadosPagos;

}
