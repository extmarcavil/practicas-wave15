import java.util.*;

public class Main {
    public static void main(String[] args) {
        int id = 0;
        int opcion = 0;
        Map<Integer, HashMap<String, String >> participantes = new HashMap<Integer, HashMap<String, String>>();
        List<Integer> chico = new ArrayList<Integer>();
        List<Integer> medio = new ArrayList<Integer>();
        List<Integer> avanzado = new ArrayList<Integer>();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido a la Carrera de la Selva \n\n");
        while (opcion != -1){
            System.out.println("Menu Principal (Seleccione una opción):");
            System.out.println("");
            System.out.println("1- Inscripción");
            System.out.println("2- Mostrar Inscriptos");
            System.out.println("3- Desinscribir");
            System.out.println("4- Total acumulado");
            System.out.println("5- Salir");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    HashMap<String, String> nuevo = new HashMap<String, String>();
                    System.out.println("Ingrese DNI:");
                    String dni = teclado.next();
                    boolean valido = true;
                    for (int i: participantes.keySet()) {
                        if (participantes.get(i).get("dni").equals(dni)) {
                            valido = false;
                        }
                    }
                    if (!valido){
                        System.out.println("Participante ya registrado");
                        break;
                    }
                    nuevo.put("dni", dni);
                    System.out.println("Ingrese Nombre:");
                    nuevo.put("nombre", teclado.next());
                    System.out.println("Ingrese apellido:");
                    nuevo.put("apellido", teclado.next());
                    System.out.println("Ingrese edad:");
                    int edad = teclado.nextInt();
                    nuevo.put("edad", edad+"");
                    System.out.println("Ingrese celular:");
                    nuevo.put("celular", teclado.next());
                    System.out.println("Ingrese nùmero de emergencia:");
                    nuevo.put("emergencia", teclado.next());
                    System.out.println("Ingrese grupo sanguineo:");
                    nuevo.put("grupo", teclado.next());
                    int carrera = 0;
                    do {
                        System.out.println("Seleccione una categoría de inscripción");
                        System.out.println("1- 2 Km");
                        System.out.println("2- 5 Km");
                        System.out.println("3- 10 Km");
                        carrera = teclado.nextInt();
                    }while (carrera<1 | carrera>3 );
                    double cuota = 0.0;
                    if(carrera==3) {
                        if (edad<18){
                            System.out.println("El participante es muy chico para esta carrera");
                            break;
                        }else {
                            cuota = 2800.0;
                        }
                    }else if (carrera == 2) {
                        if(edad<18){
                            cuota = 2000.0;
                        }else {
                            cuota = 2300.0;
                        }
                    }
                    else if (carrera == 1) {
                        if(edad<18){
                            cuota = 1300.0;
                        }else {
                            cuota = 1500.0;
                        }
                    }
                    nuevo.put("cuota", cuota+"");
                    id++;
                    participantes.put(id,nuevo);
                    switch (carrera){
                        case 1:
                            chico.add(id);
                        case 2:
                            medio.add(id);
                        case 3:
                            avanzado.add(id);
                    }
                    System.out.println("Monto a pagar: " + cuota);
                    break;
                case 2:
                    int carr = 0;
                    do {
                        System.out.println("Elegir carrera para mostrar participantes:");
                        System.out.println("1- Circuito chico");
                        System.out.println("2- Circuito medio");
                        System.out.println("3- Circuito avanzado");
                        carr = teclado.nextInt();
                    }while (carr<1 | carr>3);
                    switch (carr){
                        case 1:
                            for (int pos:chico) {
                                HashMap<String, String> actual = participantes.get(pos);
                                System.out.println(
                                        pos+"- "+
                                        actual.get("dni")+"  "+
                                        actual.get("nombre")+" "+
                                        actual.get("apellido")+"  "+
                                        actual.get("edad")+"  "+
                                        actual.get("celular")+ "  "+
                                        actual.get("emergencia")+"  "+
                                        actual.get("grupo"));
                            }
                            break;
                        case 2:
                            for (int pos:medio) {
                                HashMap<String, String> actual = participantes.get(pos);
                                System.out.println(
                                        pos+"- "+
                                                actual.get("dni")+"  "+
                                                actual.get("nombre")+" "+
                                                actual.get("apellido")+"  "+
                                                actual.get("edad")+"  "+
                                                actual.get("celular")+ "  "+
                                                actual.get("emergencia")+"  "+
                                                actual.get("grupo"));
                            }
                            break;
                        case 3:
                            for (int pos:avanzado) {
                                HashMap<String, String> actual = participantes.get(pos);
                                System.out.println(
                                        pos+"- "+
                                                actual.get("dni")+"  "+
                                                actual.get("nombre")+" "+
                                                actual.get("apellido")+"  "+
                                                actual.get("edad")+"  "+
                                                actual.get("celular")+ "  "+
                                                actual.get("emergencia")+"  "+
                                                actual.get("grupo"));
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Proporcione el nùmero del participante a desinscribir");
                    int par = teclado.nextInt();
                    if (participantes.keySet().contains(par)){
                        participantes.remove(par);
                        chico.remove(Integer.valueOf(par));
                        medio.remove(Integer.valueOf(par));
                        avanzado.remove(Integer.valueOf(par));
                        System.out.println("Se ha removido el participante "+ par+ " con éxito");
                    }else {
                        System.out.println("No se encontrò el participante");
                    }
                    break;
                case 4:
                    double total=0.0;
                    for (int i:participantes.keySet()) {
                        total=total +Double.parseDouble(participantes.get(i).get("cuota"));
                    }
                    System.out.println("El total a pagar de todos los competidores es: "+total);
                    break;
            }



        }
        teclado.close();
        System.out.println("Carrera Teminada");
    }
}
