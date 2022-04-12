package uy.com.vparula;

public class Main {

    public static void main(String[] args) {
	    Persona pepe = new Persona();
	    Persona juan = new Persona("Juan", 32, "1111111");
	    Persona jose = new Persona("Jose",40, "1234567",87.3,1.78);
        System.out.println(jose.calcularImc());
        if (jose.esMayor()){
            System.out.println( jose.getNombre() + " es mayor");
        }else {
            System.out.println(jose.getNombre() +" es menor");
        }
        int imc = jose.calcularImc();
        switch (imc){
            case -1:
                System.out.println("Tiene bajo peso");
                break;
            case 0:
                System.out.println("Tiene peso saludable");
                break;
            case 1:
                System.out.println("Tiene sobrepeso");
                break;
        }

        System.out.println(jose.toString());

    }
}
