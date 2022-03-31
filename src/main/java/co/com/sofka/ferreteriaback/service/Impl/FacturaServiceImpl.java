package co.com.sofka.ferreteriaback.service.Impl;

import co.com.sofka.ferreteriaback.model.Factura;
import co.com.sofka.ferreteriaback.repository.FacturaRepository;
import co.com.sofka.ferreteriaback.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    FacturaRepository repository;

    @Override
    public Mono<Factura> save(Factura factura) {
        return repository.save(factura);
    }

    @Override
    public Flux<Factura> findAll() {
        return this.repository.findAll();
    }

}
