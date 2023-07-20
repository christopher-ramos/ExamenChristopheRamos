package ec.edu.espe.arquitectura.examenchristopherramos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.examenchristopherramos.controller.dto.EmpresaRQ;
import ec.edu.espe.arquitectura.examenchristopherramos.service.EmpresaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/empresa")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody EmpresaRQ empresaRQ) {
        try {
            empresaService.crear(empresaRQ);
            return ResponseEntity.ok().body("Empresa creada");
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().body(rte.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
