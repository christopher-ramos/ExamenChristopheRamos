package ec.edu.espe.arquitectura.examenchristopherramos.repository;

import ec.edu.espe.arquitectura.examenchristopherramos.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpresaRepository extends MongoRepository<Empresa, Integer> {

    Empresa findByRuc(String ruc);

}