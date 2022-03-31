package co.com.sofka.ferreteriaback.service.Impl;


import co.com.sofka.ferreteriaback.model.Producto;
import co.com.sofka.ferreteriaback.repository.ProductoRepository;
import co.com.sofka.ferreteriaback.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository repository;

    @Override
    public Mono<Producto> save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Flux<Producto> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Mono<Producto> update(String id, Producto producto) {
        return this.repository.findById(id).flatMap(producto1 -> {
                                                producto.setId(id);
                                                return save(producto);
                                            }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Producto> delete(String id) {
        return this.repository.findById(id)
                .flatMap(producto -> this.repository.deleteById(producto.getId()).thenReturn(producto));
    }


}
