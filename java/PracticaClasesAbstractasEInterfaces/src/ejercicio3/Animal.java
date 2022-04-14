package ejercicio3;

public abstract class Animal {
    public  enum Tipo {
        MASCOTA, ANIMALDEGRANJA
    }

   Tipo tipo;

    public Animal(Tipo tipo) {
        this.tipo = tipo;
    }

    public void comerAnimal (){
        if(tipo.equals(Tipo.MASCOTA)){
            System.out.println("Este animal no es comestible ");
        }else {
            System.out.println("Este animal se puede comer");
        }
    }

    abstract void  emitirSonido();
}
