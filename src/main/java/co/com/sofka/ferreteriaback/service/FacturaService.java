package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.Factura;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FacturaService {

    Mono<Factura> save(Factura factura);
    Flux<Factura> findAll();
    Mono<Factura> update(String id, Factura factura);
    Mono<Factura> delete(String id);

}
