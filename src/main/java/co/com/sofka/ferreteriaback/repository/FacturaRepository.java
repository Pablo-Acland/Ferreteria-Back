package co.com.sofka.ferreteriaback.repository;

import co.com.sofka.ferreteriaback.model.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FacturaRepository extends ReactiveMongoRepository<Factura,String> {

}
