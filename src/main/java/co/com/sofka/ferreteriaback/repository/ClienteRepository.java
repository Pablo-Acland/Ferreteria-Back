package co.com.sofka.ferreteriaback.repository;

import co.com.sofka.ferreteriaback.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
}
