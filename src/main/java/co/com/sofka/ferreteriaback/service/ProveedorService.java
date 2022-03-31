package co.com.sofka.ferreteriaback.service;


import co.com.sofka.ferreteriaback.model.Proveedor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProveedorService{

    Mono<Proveedor> save(Proveedor proveedor);
    Flux<Proveedor> findAll();
    Mono<Proveedor> update(String id, Proveedor proveedor);
    Mono<Proveedor> delete(String id);

}
