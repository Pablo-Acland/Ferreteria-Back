package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String nombre;
    private String celular;
    private String CI;

    public Cliente() {}



    public Cliente(String id, String celular, String nombre, String ci) {
        this.id= id;
        this.nombre = nombre;
        this.celular = celular;
        this.CI = ci;
    }


    public String getId() {
        return id;
    }
    public String getCI() {
        return CI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCelular() {
        return celular;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setCI(String CI) {
        this.CI = CI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", documentoIdentidad='" + CI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(CI, cliente.CI) && Objects.equals(nombre, cliente.nombre) && Objects.equals(celular, cliente.celular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CI, nombre, celular);
    }
}
