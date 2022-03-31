package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document(collection = "producto")
public class Producto {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String nombreProducto;
    private Long precio;

    public Producto() {}

    public Producto(String id, String nombreProducto, Long precio) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(nombreProducto, producto.nombreProducto) && Objects.equals(precio, producto.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreProducto, precio);
    }

}
