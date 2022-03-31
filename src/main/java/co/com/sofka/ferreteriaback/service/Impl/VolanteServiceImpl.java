package co.com.sofka.ferreteriaback.service.Impl;


import co.com.sofka.ferreteriaback.model.Volante;
import co.com.sofka.ferreteriaback.repository.VolanteRepository;
import co.com.sofka.ferreteriaback.service.VolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteServiceImpl implements VolanteService {

    @Autowired
    VolanteRepository repository;

    @Override
    public Mono<Volante> save(Volante volante) {
        return repository.save(volante);
    }

    @Override
    public Flux<Volante> findAll() {
        return this.repository.findAll();
    }


}
