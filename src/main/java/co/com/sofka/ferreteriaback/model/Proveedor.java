package co.com.sofka.ferreteriaback.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "proveedor")
public class Proveedor {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String CI;
    private String nombre;
    private String celular;

    public Proveedor() {}

    public Proveedor(String id, String ci, String nombre, String celular) {
        this.id = id;
        this.CI = ci;
        this.nombre = nombre;
        this.celular = celular;
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
        return "Proveedor{" +
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
        Proveedor proveedor = (Proveedor) o;
        return Objects.equals(id, proveedor.id) && Objects.equals(CI, proveedor.CI) && Objects.equals(nombre, proveedor.nombre) && Objects.equals(celular, proveedor.celular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CI, nombre, celular);
    }
}
