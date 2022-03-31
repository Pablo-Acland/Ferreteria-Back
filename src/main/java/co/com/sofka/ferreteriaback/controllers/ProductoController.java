package co.com.sofka.ferreteriaback.controllers;

import co.com.sofka.ferreteriaback.model.Producto;
import co.com.sofka.ferreteriaback.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    ProductoService service;

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Producto> save(@RequestBody Producto producto) {
        return this.service.save(producto);
    }

    @GetMapping(value = "/productos")
    private Flux<Producto> findAll() {
        return this.service.findAll();
    }



}
