package com.company;

public class Main {

   /*En la clase Main que acabamos de crear, dentro del método main() te pedimos que crees un objeto de tipo Persona por cada constructor que hayamos definido en la clase,
    recuerda poner un nombre significativo a las variables donde vas a asignar cada objeto. ¿Cómo lo harías? A continuación vamos a crear otro objeto de tipo persona y

    vamos a construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor.
   ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?*/
    public static void main(String[] args) {
        Persona anonimo = new Persona();
        Persona juan = new Persona("Juan", "12345678", 20);
        Persona pedro = new Persona("Pedro", "12344694",30,  85, 1.80);
    }
}
