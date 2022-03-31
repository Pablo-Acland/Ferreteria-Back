package co.com.sofka.ferreteriaback.service;

import co.com.sofka.ferreteriaback.model.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteService {
    Mono<Cliente> save(Cliente cliente);
    Flux<Cliente> findAll();
    Mono<Cliente> update(String id, Cliente cliente);
    Mono<Cliente> delete(String id);
}
