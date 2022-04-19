package com.company.santiagopinzondev;
import java.util.*;

public class CarreraSelva {
    static void createUser(Scanner entrada, Integer id, List<Map> listaChico, List<Map> listaMedio, List<Map> listaAvanzado) {
        id += 1;
        System.out.println("Introduzca un nombre");
        String name = entrada.nextLine();
        System.out.println("Introduzca un apellido");
        String apellido = entrada.nextLine();
        System.out.println("Introduzca un dni");
        String dni = entrada.nextLine();
        System.out.println("Introduzca un grupo sanguineo");
        String sanguineo = entrada.nextLine();
        System.out.println("Introduzca una categoria");
        System.out.println("- chico\n - medio\n - avanzado");
        String categoria = entrada.nextLine();
        System.out.println("Introduzca la edad");
        String edad = entrada.nextLine();
        System.out.println("Introduzca un celular");
        String celular = entrada.nextLine();
        System.out.println("Introduzca un numero de emergencia");
        String numEmergencia = entrada.nextLine();

        Map<String, String> user = new HashMap();
        user.put("id", String.valueOf(id));
        user.put ("Nombre", name);
        user.put("edad", edad);
        user.put ("dni", dni);
        user.put("sanguineo", sanguineo);
        user.put("categoria", categoria);
        user.put("celular", celular);
        user.put("numEmergencia", numEmergencia);
        user.put("apellido", apellido);
        user.put("sanguineo", sanguineo);

        if (categoria.equals("chico")){
            listaChico.add(user);
        }
        else if (categoria.equals("medio")){
            listaMedio.add(user);
        }
        else {
            listaAvanzado.add(user);
        }


    }

    static void deleteUser(Scanner entrada, List<Map> listaChico, List<Map> listaMedio, List<Map> listaAvanzado) {
        System.out.println("Escriba el dni del user que quiere eliminar");
        int dniEliminar = Integer.parseInt(entrada.nextLine());

        listaChico = knowIndexUser(dniEliminar, listaChico);
        listaMedio = knowIndexUser(dniEliminar, listaMedio);
        listaAvanzado = knowIndexUser(dniEliminar, listaAvanzado);

    }
    static List<Map> knowIndexUser(int dniEliminar, List<Map> listaCategory){
        int indexUser = 0;
        boolean exitFor = false;

        for(Map<String, String> person : listaCategory) {
            // get entrySet() into Set
            Set<String> setOfListaChico = person.keySet();
            // Collection Iterator
            Iterator<String> iterator =
                    setOfListaChico.iterator();
            // iterate using while-loop after getting Iterator
            while(iterator.hasNext()) {
                String key = iterator.next();
                if (key.equals("dni") && Integer.parseInt(person.get(key)) == dniEliminar) {
                    exitFor = true;
                    break;
                }
            }
            if (exitFor) {
                break;
            }
            indexUser++;
        }
        if (indexUser < listaCategory.size() && exitFor){
            listaCategory.remove(indexUser);
            System.out.println("El user ha sido eliminado");
        }

        return listaCategory;
    }
    static void listUserCategoria(Scanner entrada, List<Map> listaChico, List<Map> listaMedio, List<Map> listaAvanzado){
        System.out.println("Escriba la categoria, para listar los usuarios de esta: ");
        System.out.println("chico: 1\n medio: 2\n avanzado: 3");
        int cat = Integer.parseInt(entrada.nextLine());
        switch (cat){
            case 1: System.out.println(listaChico);
                    break;
            case 2: System.out.println(listaMedio);
                    break;
            case 3: System.out.println(listaAvanzado);
                    break;
        }
    }
    static void showMeu(Integer breaks, List<Map> listaChico, List<Map> listaMedio, List<Map> listaAvanzado) {
        Scanner entrada = new Scanner(System.in);
        int id = 0;
        do {
            System.out.println("Si quiere agregar un usuario escriba 1 de lo contrario 0");
            System.out.println("Si quiere mostrar los usuarios de una categoria escriba 2");
            System.out.println("Si quiere eliminar un user escriba 3");
            breaks = Integer.parseInt(entrada.nextLine());
            switch (breaks) {
                case 1: createUser(entrada, id, listaChico, listaMedio, listaAvanzado);
                        break;
                case 2: listUserCategoria(entrada, listaChico, listaMedio, listaAvanzado);
                        break;
                case 3: deleteUser(entrada, listaChico, listaMedio, listaAvanzado);
                        break;
            }
        } while (breaks != 0);
    }
    public static void main(String[] args) {
        List<Map> listaChico = new ArrayList();
        List<Map> listaMedio = new ArrayList();
        List<Map> listaAvanzado = new ArrayList();


        int breaks = 1;
        showMeu(breaks, listaChico, listaMedio, listaAvanzado);


    }
}
