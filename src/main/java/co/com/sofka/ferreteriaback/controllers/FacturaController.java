package co.com.sofka.ferreteriaback.controllers;

import co.com.sofka.ferreteriaback.model.Factura;
import co.com.sofka.ferreteriaback.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    FacturaService service;

    @PostMapping("/factura")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Factura> save(@RequestBody Factura factura) {
        return this.service.save(factura);
    }

    @GetMapping(value = "/facturas")
    private Flux<Factura> findAll() {
        return this.service.findAll();
    }



}
