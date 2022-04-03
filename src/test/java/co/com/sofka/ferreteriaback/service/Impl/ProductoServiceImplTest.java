package co.com.sofka.ferreteriaback.service.Impl;

import co.com.sofka.ferreteriaback.model.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class ProductoServiceImplTest {
    @Autowired
    ProductoServiceImpl servicio;

    @Test
    void save() {

        Producto producto = new Producto("2",  "papá", 100L);
        Mono<Producto> producto1 = servicio.save(producto);
        StepVerifier.create(producto1).expectNext(producto).verifyComplete();
    }

    @Test
    void findAll() {
        Producto producto1 = new Producto("2",  "papá", 100L);
        Flux<Producto> producto = servicio.findAll();
        StepVerifier.create(producto).expectNext(producto1).verifyComplete();
    }

    @Test
    void update() {
        Producto producto1 = new Producto("2",  "Pera", 100L);
        Mono<Producto> producto = servicio.update("2", producto1);
        StepVerifier.create(producto).expectNext(producto1).verifyComplete();
    }

    @Test
    void delete() {
        Mono<Producto> producto = servicio.delete("2");
        StepVerifier.create(producto).expectNext().verifyComplete();
    }
}