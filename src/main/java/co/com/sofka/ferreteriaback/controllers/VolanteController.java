package co.com.sofka.ferreteriaback.controllers;

import co.com.sofka.ferreteriaback.model.Volante;
import co.com.sofka.ferreteriaback.service.Impl.VolanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/volante/update/{id}")
    private Mono<ResponseEntity<Volante>> updateVolante
            (@PathVariable("id") String id, @RequestBody Volante volante) {
        return this.service.update(id, volante).flatMap(volante1 -> Mono.just(ResponseEntity.ok(volante1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/volante/delete/{id}")
    private Mono<ResponseEntity<Volante>> deleteVolante(@PathVariable("id") String id) {
        return this.service.delete(id).flatMap(volante -> Mono.just(ResponseEntity.ok(volante)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
