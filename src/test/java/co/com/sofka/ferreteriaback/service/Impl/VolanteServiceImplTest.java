package co.com.sofka.ferreteriaback.service.Impl;

import co.com.sofka.ferreteriaback.model.Factura;
import co.com.sofka.ferreteriaback.model.Volante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VolanteServiceImplTest {


    @Autowired
    VolanteServiceImpl servicio;

    @Test
    void save() {
        Date fecha = new Date(2022-02-23);
        Volante volante = new Volante("2", "Pablo", fecha,  "Raul");
        Mono<Volante> volante1 = servicio.save(volante);
        StepVerifier.create(volante1).expectNext(volante).verifyComplete();

    }

    @Test
    void findAll() {
        Date fecha = new Date(2022-02-23);
        Volante volante = new Volante("2", "Pablo", fecha,  "Raul");
        Flux<Volante> volante1 = servicio.findAll();
        StepVerifier.create(volante1).expectNext(volante).verifyComplete();

    }

    @Test
    void update() {
        Date fecha = new Date(2022-03-13);
        Volante volante = new Volante("2", "Pablo", fecha,  "Raul");
        Mono<Volante> volante1 = servicio.update("2", volante);
        StepVerifier.create(volante1).expectNext(volante).verifyComplete();

    }

    @Test
    void delete() {
        Mono<Volante> volante1 = servicio.delete("2");
        StepVerifier.create(volante1).expectNext().verifyComplete();
    }
}