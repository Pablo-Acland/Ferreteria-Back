package co.com.sofka.ferreteriaback.repository;

import co.com.sofka.ferreteriaback.model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
}
