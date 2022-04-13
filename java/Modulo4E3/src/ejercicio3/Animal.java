package ejercicio3;

public abstract class Animal {

    private String sonido;


    public Boolean getComeAnimal() {
        return comeAnimal;
    }

    public void setComeAnimal(Boolean comeAnimal) {
        this.comeAnimal = comeAnimal;
    }

    private Boolean comeAnimal;

    public Animal(String sonido, Boolean comeAnimal) {
        this.sonido = sonido;
        this.comeAnimal = comeAnimal;
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public abstract String emitirSonido();


}
