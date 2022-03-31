package co.com.sofka.ferreteriaback.service.Impl;

import co.com.sofka.ferreteriaback.model.Proveedor;
import co.com.sofka.ferreteriaback.repository.ProveedorRepository;
import co.com.sofka.ferreteriaback.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    ProveedorRepository repository;

    @Override
    public Mono<Proveedor> save(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public Flux<Proveedor> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Mono<Proveedor> update(String id, Proveedor proveedor) {
        return this.repository.findById(id).flatMap(proveedor1 -> {
                                                proveedor.setId(id);
                                                return save(proveedor);
                                            }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Proveedor> delete(String id) {
        return this.repository.findById(id)
                .flatMap(proveedor -> this.repository.deleteById(proveedor.getId()).thenReturn(proveedor));
    }


}
