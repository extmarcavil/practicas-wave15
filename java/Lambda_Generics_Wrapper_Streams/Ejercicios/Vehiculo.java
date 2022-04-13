package Lambda_Generics_Wrapper_Streams.Ejercicios;

public class Vehiculo implements Comparable<Vehiculo>{
    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(String modelo, String marca, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public int compareTo(Vehiculo o) {
        //Por costo
        /*Double a= this.getCosto();
        Double b= o.getCosto();
        return a.compareTo(b);*/
        //Por Marca y costo
        String a=new String(String.valueOf(this.getMarca())+this.getCosto());
        String b=new String(String.valueOf(o.getMarca())+o.getCosto());
        return a.compareTo(b);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", costo=" + costo +
                '}';
    }
}
