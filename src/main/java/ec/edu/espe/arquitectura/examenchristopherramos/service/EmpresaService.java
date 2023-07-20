package ec.edu.espe.arquitectura.examenchristopherramos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examenchristopherramos.controller.dto.EmpleadoRQ;
import ec.edu.espe.arquitectura.examenchristopherramos.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examenchristopherramos.model.Empleado;
import ec.edu.espe.arquitectura.examenchristopherramos.model.Empresa;
import ec.edu.espe.arquitectura.examenchristopherramos.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public void crear(EmpresaRQ empresaRQ) {

        Empresa empresa = this.transformarEmpresa(empresaRQ);

        Empresa existsEnterprise = empresaRepository.findByRuc(
                empresa.getRuc());

        if (existsEnterprise != null) {
            throw new RuntimeException("El ruc ya esta registrado");
        }

        empresaRepository.save(empresa);

    }

    private Empresa transformarEmpresa(EmpresaRQ rq) {
        Empresa empresa = Empresa.builder()
                .ruc(rq.getRuc())
                .razonSocial(rq.getRazonSocial())
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .empleados(this.transformarEmpleados(rq.getEmpleados()))
                .build();
        return empresa;
    }

    private List<Empleado> transformarEmpleados(List<EmpleadoRQ> empleadosRQ) {
        List<Empleado> empleados = new ArrayList<>();

        for (EmpleadoRQ rqEmpleado : empleadosRQ) {
            Empleado empleado = Empleado.builder()
                    .cedula(rqEmpleado.getCedula())
                    .apellidos(rqEmpleado.getApellidos())
                    .nombres(rqEmpleado.getNombres())
                    .cuenta(rqEmpleado.getCuenta())
                    .build();

            empleados.add(empleado);
        }

        return empleados;
    }
}
