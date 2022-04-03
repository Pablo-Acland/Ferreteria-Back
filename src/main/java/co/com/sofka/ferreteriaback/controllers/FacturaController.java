package co.com.sofka.ferreteriaback.controllers;

import co.com.sofka.ferreteriaback.model.Factura;
import co.com.sofka.ferreteriaback.service.FacturaService;
import co.com.sofka.ferreteriaback.service.Impl.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/factura")
public class FacturaController {

    @Autowired
    FacturaService service;

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Factura> saveFactura(@RequestBody Factura factura) {
        return this.service.save(factura);
    }

    @GetMapping(value = "/facturas")
    private Flux<Factura> findAll() {
        return this.service.findAll();
    }

    @PutMapping("/factura/update/{id}")
    private Mono<ResponseEntity<Factura>> updateFactura(@PathVariable("id") String id, @RequestBody Factura factura) {
        return this.service.update(id, factura)
                .flatMap(factura1 -> Mono.just(ResponseEntity.ok(factura1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/factura/delete/{id}")
    private Mono<ResponseEntity<Factura>> deleteFactura(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(factura1 -> Mono.just(ResponseEntity.ok(factura1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


}
