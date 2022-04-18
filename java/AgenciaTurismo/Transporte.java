package AgenciaTurismo;

public class Transporte{
        private double precio;

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

    @Override
    public String toString() {
        return "Transporte{" +
                "precio=" + precio +
                '}';
    }

    public Transporte(double precio) {
        this.precio = precio;
    }

}
