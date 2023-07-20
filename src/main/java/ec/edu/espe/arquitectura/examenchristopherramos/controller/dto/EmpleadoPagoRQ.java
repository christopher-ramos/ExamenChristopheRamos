package ec.edu.espe.arquitectura.examenchristopherramos.controller.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpleadoPagoRQ {
    private String cuenta;
    private BigDecimal valor;
}
