package TutorialBootcamp.EncapsulamientoHerenciaPolimorfismo;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Animal {
    private String especie;

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Animal(String especie) {
        this.especie = especie;
    }

    public void mostrarEspecie(){
        System.out.println("Soy un animal de la especie " +this.especie);
    }

    public void hacerSonido(){
        System.out.println("El animal hace sonido");
    }
}
