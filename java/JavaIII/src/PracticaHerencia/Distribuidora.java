package PracticaHerencia;

public class Distribuidora {
    private Producto[] listado = new Producto[5];

    public Distribuidora(){
        generarProductos();
    }

    private void generarProductos(){
        Producto prod1 = new Producto("Pan", 25);
        Perecedero prod2 = new Perecedero("Leche", 40, 2);
        NoPerecedero prod3 = new NoPerecedero("Azucar", 70, "Comestible");
        Producto prod4 = new Perecedero("Jugo", 100, 10);
        Producto prod5 = new NoPerecedero("Alcohol", 150, "Limpieza");

        listado[0] = prod1;
        listado[1] = prod2;
        listado[2] = prod3;
        listado[3] = prod4;
        listado[4] = prod5;
    }

    public double costoTotal(){
        double costo = 0;
        for (Producto p : listado){
            costo += p.calcular(2);
        }
        return costo;
    }

    public static void main(String[] args) {
        Distribuidora dist = new Distribuidora();
        System.out.println(dist.costoTotal());
    }
}
