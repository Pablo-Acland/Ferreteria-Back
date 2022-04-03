package co.com.sofka.ferreteriaback.service.Impl;


import co.com.sofka.ferreteriaback.model.Proveedor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class ProveedorServiceImplTest {

    @Autowired
    ProveedorServiceImpl servicio;

    @Test
    void save() {

        Proveedor proveedor = new Proveedor("b9b1d146-0", "09994312", "Pi", "Limpia");
        Mono<Proveedor> proveedor1 = servicio.save(proveedor);
        StepVerifier.create(proveedor1).expectNext(proveedor).verifyComplete();
    }

    @Test
    void findAll() {

        Proveedor proveedor = new Proveedor("b56bbc23-d", "Limpito", "holii", "0999431212");
        Flux<Proveedor> proveedor1 = servicio.findAll();
        StepVerifier.create(proveedor1).expectNext(proveedor).verifyComplete();
        //funciona si hay un solo proveedor en la Bd para q tome todos hay q poner un expectNext() por cada proveedor en la BD
    }

    @Test
    void update() {
        Proveedor proveedor = new Proveedor("b56bbc23-d", "Limpio", "holii", "0999431212");
        Mono<Proveedor> proveedor1 = servicio.update("b56bbc23-d",proveedor);
        StepVerifier.create(proveedor1).expectNext(proveedor).verifyComplete();
    }

    @Test
    void delete() {
        Mono<Proveedor> proveedor1 = servicio.delete("b56bbc23-d");
        StepVerifier.create(proveedor1).expectNext().verifyComplete();
    }
}