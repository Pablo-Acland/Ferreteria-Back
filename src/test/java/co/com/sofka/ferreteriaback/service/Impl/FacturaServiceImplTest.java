package co.com.sofka.ferreteriaback.service.Impl;

import co.com.sofka.ferreteriaback.model.Factura;
import co.com.sofka.ferreteriaback.model.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

@SpringBootTest
class FacturaServiceImplTest {

    @Autowired
    FacturaServiceImpl servicio;

    @Test
    void save(){

        Date fecha = new Date(2022-02-23);
        Factura factura = new Factura("2", 5L, fecha, "Pablo", "Raul", 30L);
        Mono<Factura> factura1 = servicio.save(factura);
        StepVerifier.create(factura1).expectNext(factura).verifyComplete();
    }

    @Test
    void findAll() {
        Factura factura1 = new Factura();
        factura1.setId("c943448e-c");
        Flux<Factura> factura = servicio.findAll();
        StepVerifier.create(factura).expectNext(factura1).verifyComplete();
        //el codigo funciona testea bien pero solo cuando hay una factura sino tengo q poner tantos expectnext()
        // segun cuantos resultados hay en la BD
    }

    @Test
    void update() {
        Date fecha = new Date(2022-02-23);
        Factura factura = new Factura("b9b1d146-0", 5L, fecha, "Pablo", "Raul", 30L);
        Mono<Factura> cliente1 = servicio.update("c943448e-c", factura);
        StepVerifier.create(cliente1).expectNext(factura).verifyComplete();

    }

    @Test
    void delete() {
       Mono<Factura> factura1 = servicio.delete("b9b1d146-0");
        StepVerifier.create(factura1).expectNext().verifyComplete();
    }
}