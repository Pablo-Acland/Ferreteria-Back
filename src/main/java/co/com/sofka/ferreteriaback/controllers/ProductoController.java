package co.com.sofka.ferreteriaback.controllers;

import co.com.sofka.ferreteriaback.model.Producto;
import co.com.sofka.ferreteriaback.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/producto/update/{id}")
    private Mono<ResponseEntity<Producto>> updateProducto(@PathVariable("id") String id, @RequestBody Producto producto) {
        return this.service.update(id, producto).flatMap(producto1 -> Mono.just(ResponseEntity.ok(producto1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/producto/delete/{id}")
    private Mono<ResponseEntity<Producto>> deleteProducto(@PathVariable("id") String id) {
        return this.service.delete(id).flatMap(producto1 -> Mono.just(ResponseEntity.ok(producto1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }



}
