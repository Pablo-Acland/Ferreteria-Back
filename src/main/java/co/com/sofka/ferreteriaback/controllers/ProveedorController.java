package co.com.sofka.ferreteriaback.controllers;

import co.com.sofka.ferreteriaback.model.Proveedor;
import co.com.sofka.ferreteriaback.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "*")
public class ProveedorController {

    @Autowired
    ProveedorService service;

    @PostMapping("/proveedor")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Proveedor> saveProveedor(@RequestBody Proveedor proveedor) {
        return this.service.save(proveedor);
    }

    @GetMapping(value = "/proveedores")
    private Flux<Proveedor> findAll() {
        return this.service.findAll();
    }

    @PutMapping("/proveedor/update/{id}")
    private Mono<ResponseEntity<Proveedor>> updateProveedore(@PathVariable("id") String id, @RequestBody Proveedor proveedor) {
        return this.service.update(id, proveedor).flatMap(proveedor1 -> Mono.just(ResponseEntity.ok(proveedor1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/proveedor/delete/{id}")
    private Mono<ResponseEntity<Proveedor>> deleteProveedor(@PathVariable("id") String id) {
        return this.service.delete(id).flatMap(proveedor1 -> Mono.just(ResponseEntity.ok(proveedor1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }




}
