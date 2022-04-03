package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "volante")
public class Volante {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String nombreProveedor;
    private List<Producto> productos;
    private Date Fecha;
    private String CIProveedor;

    public Volante() {}


    public Volante(String id, String nombreProveedor,  Date fecha, String CiProveedor) {
        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.Fecha = fecha;
        this.CIProveedor = CiProveedor;
    }
    public Volante(String id, String nombreProveedor, List<Producto> productos, Date fecha, String CiProveedor) {
        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.productos = productos;
        this.Fecha = fecha;
        this.CIProveedor = CiProveedor;
    }


    public String getId() {
        return id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Date getFecha() {
        return Fecha;
    }

    public String getCIProveedor() {
        return CIProveedor;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public void setCIProveedor(String CIProveedor) {
        this.CIProveedor = CIProveedor;
    }


    @Override
    public String toString() {
        return "VolanteProveedor{" +
                "id='" + id + '\'' +
                ", nombreProveedor='" + nombreProveedor + '\'' +
                ", productos=" + productos +
                ", Fecha=" + Fecha +
                ", documentoIdentidadProveedor='" + CIProveedor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volante that = (Volante) o;
        return Objects.equals(id, that.id) && Objects.equals(nombreProveedor, that.nombreProveedor) && Objects.equals(productos, that.productos) && Objects.equals(Fecha, that.Fecha) && Objects.equals(CIProveedor, that.CIProveedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreProveedor, productos, Fecha, CIProveedor);
    }
}
