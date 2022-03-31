package co.com.sofka.ferreteriaback.controllers;

import co.com.sofka.ferreteriaback.model.Proveedor;
import co.com.sofka.ferreteriaback.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private Mono<Proveedor> save(@RequestBody Proveedor proveedor) {
        return this.service.save(proveedor);
    }

    @GetMapping(value = "/proveedores")
    private Flux<Proveedor> findAll() {
        return this.service.findAll();
    }



}
