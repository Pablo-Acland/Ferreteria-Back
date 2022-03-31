package co.com.sofka.ferreteriaback.controllers;

import co.com.sofka.ferreteriaback.model.Volante;
import co.com.sofka.ferreteriaback.service.Impl.VolanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "*")
public class VolanteController {

    @Autowired
    VolanteServiceImpl service;

    @PostMapping("/volante")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Volante> saveVolante(@RequestBody Volante volante) {
        return this.service.save(volante);
    }

    @GetMapping(value = "/volantes")
    private Flux<Volante> findAll() {
        return this.service.findAll();
    }

}
