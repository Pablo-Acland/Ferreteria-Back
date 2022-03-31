package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.Volante;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VolanteService {

    Mono<Volante> save(Volante volanteProveedor);
    Flux<Volante> findAll();
}
