package co.com.sofka.ferreteriaback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "factura")
public class Factura {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private Long consecutivoFactura;
    private Date Fecha;
    private String nombreCliente;
    private String nombreEmpleado;
    private List<Producto> productos;
    private Long totalPagar;

    public Factura() {}

    public Factura(String id, Long consecutivoFactura, Date fecha, String nombreCliente, String nombreEmpleado, List<Producto> productos, Long totalPagar) {
        this.id= id;
        this.consecutivoFactura = consecutivoFactura;
        this.Fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.nombreEmpleado = nombreEmpleado;
        this.productos = productos;
        this.totalPagar = totalPagar;
    }

    public String getId() {
        return id;
    }

    public Long getConsecutivoFactura() {
        return consecutivoFactura;
    }

    public Date getFecha() {
        return Fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Long getTotalPagar() {
        return totalPagar;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setConsecutivoFactura(Long consecutivoFactura) {
        this.consecutivoFactura = consecutivoFactura;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setTotalPagar(Long totalPagar) {
        this.totalPagar = totalPagar;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id='" + id + '\'' +
                ", consecutivoFactura=" + consecutivoFactura +
                ", Fecha=" + Fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                ", productos=" + productos +
                ", totalPagar=" + totalPagar +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Objects.equals(id, factura.id) && Objects.equals(consecutivoFactura, factura.consecutivoFactura) && Objects.equals(Fecha, factura.Fecha) && Objects.equals(nombreCliente, factura.nombreCliente) && Objects.equals(nombreEmpleado, factura.nombreEmpleado) && Objects.equals(productos, factura.productos) && Objects.equals(totalPagar, factura.totalPagar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, consecutivoFactura, Fecha, nombreCliente, nombreEmpleado, productos, totalPagar);
    }
}
