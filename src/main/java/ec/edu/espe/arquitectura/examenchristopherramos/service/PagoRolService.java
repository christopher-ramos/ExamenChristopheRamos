package ec.edu.espe.arquitectura.examenchristopherramos.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.examenchristopherramos.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examenchristopherramos.controller.dto.PagoRolRQ;
import ec.edu.espe.arquitectura.examenchristopherramos.model.Empresa;
import ec.edu.espe.arquitectura.examenchristopherramos.model.PagoRol;
import ec.edu.espe.arquitectura.examenchristopherramos.repository.EmpresaRepository;
import ec.edu.espe.arquitectura.examenchristopherramos.repository.PagoRolRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoRolService {
    
    private final PagoRolRepository pagoRolRepository;
    private final EmpresaRepository empresaRepository;

    public void realizarPago (PagoRolRQ pagoRolRQ){
        PagoRol pagoRol = this.transformarPagoRol(pagoRolRQ);

        Empresa existsEnterprise = empresaRepository.findByRuc(pagoRol.getRucEmpresa());
        
        if (existsEnterprise == null) {
            throw new RuntimeException("No existe la empresa");
        }

        pagoRolRepository.save(pagoRol);

    }

    private PagoRol transformarPagoRol(PagoRolRQ rq) {
        PagoRol pagoRol = PagoRol.builder()
                .mes(rq.getMes())
                .fechaProceso(new Date())
                .rucEmpresa(rq.getRucEmpresa())
                .cuentaPrincipal(rq.getCuentaPrincipal())
                .valorTotal(null)
                .valorReal(null)
                .build();
        return pagoRol;
    }
}
