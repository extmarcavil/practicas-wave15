package com.joyeria.LasPerlas.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
    private double peso;

    public Joya(Long nro_identificatorio, String nombre, String material, String particularidad, boolean posee_piedra, double peso) {
        this.nro_identificatorio = nro_identificatorio;
        this.nombre = nombre;
        this.material = material;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.peso = peso;
        this.ventaONo = true;
    }

    public Joya() {
    }

    @Override
    public String toString() {
        return "Joya{" +
                "nro_identificatorio=" + nro_identificatorio +
                ", nombre='" + nombre + '\'' +
                ", material='" + material + '\'' +
                ", particularidad='" + particularidad + '\'' +
                ", posee_piedra=" + posee_piedra +
                ", ventaONo=" + ventaONo +
                ", peso=" + peso +
                '}';
    }
}
