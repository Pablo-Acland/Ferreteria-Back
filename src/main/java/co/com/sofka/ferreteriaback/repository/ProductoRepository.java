package co.com.sofka.ferreteriaback.repository;

import co.com.sofka.ferreteriaback.model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoRepository extends ReactiveMongoRepository<Producto,String> {

}
