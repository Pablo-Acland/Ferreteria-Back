package co.com.sofka.ferreteriaback.repository;

import co.com.sofka.ferreteriaback.model.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VolanteRepository extends ReactiveMongoRepository<Volante,String> {

}
