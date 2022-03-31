package co.com.sofka.ferreteriaback.service.Impl;

import co.com.sofka.ferreteriaback.model.Cliente;
import co.com.sofka.ferreteriaback.repository.ClienteRepository;
import co.com.sofka.ferreteriaback.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository repository;

    @Override
    public Mono<Cliente> save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Flux<Cliente> findAll() {
        return this.repository.findAll();
    }

    public Mono<Cliente> update(String id, Cliente cliente) {
        return this.repository.findById(id).flatMap(clienteUpdate -> {
                                                        cliente.setId(id);
                                                        return save(cliente);
                                                    }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Cliente> delete(String id) {
        return this.repository.findById(id).flatMap(clienteDelete -> this.repository.deleteById(clienteDelete.getId())
                .thenReturn(clienteDelete));
    }
}
