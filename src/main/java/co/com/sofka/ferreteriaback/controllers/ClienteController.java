package co.com.sofka.ferreteriaback.controllers;

import co.com.sofka.ferreteriaback.model.Cliente;
import co.com.sofka.ferreteriaback.service.Impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired
    ClienteServiceImpl service;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Cliente> saveCliente(@RequestBody Cliente cliente) {
        return this.service.save(cliente);
    }

    @GetMapping(value = "/clientes")
    private Flux<Cliente> findAll() {
        return this.service.findAll();
    }

    @PutMapping("/cliente/update/{id}")
    private Mono<ResponseEntity<Cliente>> updateCliente(@PathVariable("id") String id, @RequestBody Cliente cliente) {
        return this.service.update(id, cliente)
                .flatMap(cliente1 -> Mono.just(ResponseEntity.ok(cliente1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/cliente/delete/{id}")
    private Mono<ResponseEntity<Cliente>> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(cliente1 -> Mono.just(ResponseEntity.ok(cliente1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
