package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

    Mono<Producto> save(Producto producto);
    Flux<Producto> findAll();
}

