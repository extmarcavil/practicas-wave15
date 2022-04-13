package models;

public class Item {
    private Long id;
    private String codigo;
    private String nombre;
    private Integer cantidadComprada;
    private Integer precioUnitario;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", precioUnitario=" + precioUnitario +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
