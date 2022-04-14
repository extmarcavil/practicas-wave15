package ejercicio1;

public class Main {
    public static void main(String[] args) {
        Persona personaSinArgimentos = new Persona();
        Persona personaSinPesoYAltura = new Persona("Juan",20,"123456");
        Persona personaConTodo = new Persona("Benito",28,"1000999922",85.5,180);
        System.out.println(personaConTodo.toString());


    }
}
