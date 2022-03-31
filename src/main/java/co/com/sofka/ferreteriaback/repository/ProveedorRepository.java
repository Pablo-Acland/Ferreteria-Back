package co.com.sofka.ferreteriaback.repository;

import co.com.sofka.ferreteriaback.model.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor,String> {
}
