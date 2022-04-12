package principal;

public class Vehiculo {

        private String marca;
        private String modelo;
        private Integer costo;

        public Vehiculo(String marca, String modelo, Integer costo) {
            this.marca = marca;
            this.modelo = modelo;
            this.costo = costo;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public Integer getCosto() {
            return costo;
        }

        public void setCosto(Integer costo) {
            this.costo = costo;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Marca: ").append(marca).append("\n");
            sb.append("Modelo: ").append(modelo).append("\n");
            sb.append("Costo: ").append(costo).append("\n");
            return sb.toString();
        }


}
