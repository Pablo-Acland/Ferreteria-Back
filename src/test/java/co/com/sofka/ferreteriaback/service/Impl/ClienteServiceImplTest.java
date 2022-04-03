package co.com.sofka.ferreteriaback.service.Impl;

import co.com.sofka.ferreteriaback.model.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ClienteServiceImplTest {

    @Autowired
    ClienteServiceImpl servicio;

    @Test
    void save() {
        Cliente cliente = new Cliente("2", "113144", "pablo", "099458472");
        Mono<Cliente> cliente1 = servicio.save(cliente);
        StepVerifier.create(cliente1).expectNext(cliente).verifyComplete();
    }

    @Test
    void findAll() {
        Cliente cliente = new Cliente("b9b1d146-0", "09994312", "Pi", "Limpia");
        Flux<Cliente> cliente1 = servicio.findAll();
        StepVerifier.create(cliente1).expectNext(cliente).verifyComplete();
    }

    @Test
    void update() {

        Cliente cliente = new Cliente("b9b1d146-0", "09994312", "Pablo", "Limpia");
        Mono<Cliente> cliente1 = servicio.update("b9b1d146-0", cliente);
        StepVerifier.create(cliente1).expectNext(cliente).verifyComplete();

    }

    @Test
    void delete() {
        Cliente cliente = new Cliente("b9b1d146-0", "09994312", "Pi", "Limpia");
        Mono<Cliente> cliente1 = servicio.delete("b9b1d146-0");
        StepVerifier.create(cliente1).expectNext(cliente).verifyComplete();
    }
}