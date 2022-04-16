package com.company;

import java.sql.SQLOutput;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {

        Scanner intro = new Scanner(System.in);

        Map <Integer, String> easyMap = new HashMap<>();
        Map <Integer, String> mediumMap = new HashMap<>();
        Map <Integer, String> hardMap = new HashMap<>();
        Map <Integer, String> dataFields = new HashMap<>();


        int playersEasy=0,playersMedium=0,playersHard=0,delete;
        String name,lastName,age,dni,contact,contactEmergency,rH;

        int menu=-1;

        while(menu!=8){

            System.out.println("Menu\nInscribir participante\n 1. Facil  2. Medio  3. Dificil \nVer participantes \n 4. Ver participantes de Competencia \nRemover participante \n 5. Categoria Facil 6. Categoria Medio  7. Categoria dificil  \nSalir\n 8. Cerrar inscripciones " );
            menu = intro.nextInt();

            switch (menu) {

                case 1:
                    System.out.println("Inscribir participante a carrera Facil");
                        System.out.println("Identificacion:");
                        dataFields.put(1,intro.next());
                        System.out.println("Nombre:");
                        dataFields.put(2,intro.next());
                        System.out.println("Apellido:");
                        dataFields.put(3,intro.next());
                        System.out.println("Edad:");
                        dataFields.put(4,intro.next());
                        System.out.println("Celular:");
                        dataFields.put(5,intro.next());
                        System.out.println("Celular Emergencia:");
                        dataFields.put(6,intro.next());
                        System.out.println("RH:");
                        dataFields.put(7,intro.next());

                        if(easyMap.containsValue(dataFields.toString())==false && mediumMap.containsValue(dataFields.toString())==false && hardMap.containsValue(dataFields.toString())==false ){
                            if(parseInt(dataFields.get(4))<18){
                                System.out.println("Pagas 1300");
                            }else{
                                System.out.println("Pagas 1500");
                            }
                            System.out.println("====Registrado con exito====");
                            easyMap.put(++playersEasy, dataFields.toString() );
                        }else{
                            System.out.println("----Participante ya registrado en la competencia----");
                        }

                    break;
                case 2:

                    System.out.println("Inscribir participante a carrera Intermedia");

                    System.out.println("Identificacion:");
                    dataFields.put(1,intro.next());
                    System.out.println("Nombre:");
                    dataFields.put(2,intro.next());
                    System.out.println("Apellido:");
                    dataFields.put(3,intro.next());
                    System.out.println("Edad:");
                    dataFields.put(4,intro.next());
                    System.out.println("Celular:");
                    dataFields.put(5,intro.next());
                    System.out.println("Celular Emergencia:");
                    dataFields.put(6,intro.next());
                    System.out.println("RH:");
                    dataFields.put(7,intro.next());

                    if(easyMap.containsValue(dataFields.toString())==false && mediumMap.containsValue(dataFields.toString())==false && hardMap.containsValue(dataFields.toString())==false ){
                        if(parseInt(dataFields.get(4))<18){
                            System.out.println("Pagas 2000");
                        }else{
                            System.out.println("Pagas 2300");
                        }
                        System.out.println("====Registrado con exito====");
                        mediumMap.put(++playersMedium, dataFields.toString() );
                    }else{
                        System.out.println("----Participante ya registrado en la competencia----");
                    }
                    break;

                case 3:

                    System.out.println("Inscribir participante en Circuito Dificil");

                    System.out.println("Identificacion:");
                    dataFields.put(1,intro.next());
                    System.out.println("Nombre:");
                    dataFields.put(2,intro.next());
                    System.out.println("Apellido:");
                    dataFields.put(3,intro.next());
                    System.out.println("Edad:");
                    dataFields.put(4,intro.next());
                    System.out.println("Celular:");
                    dataFields.put(5,intro.next());
                    System.out.println("Celular Emergencia:");
                    dataFields.put(6,intro.next());
                    System.out.println("RH:");
                    dataFields.put(7,intro.next());

                    if(easyMap.containsValue(dataFields.toString())==false && mediumMap.containsValue(dataFields.toString())==false && hardMap.containsValue(dataFields.toString())==false ){
                        if(parseInt(dataFields.get(4))<18){
                            System.out.println("----No se permite a menores de edad en este circuito----");
                        }else{
                            System.out.println("Pagas 2800");
                            hardMap.put(++playersHard, dataFields.toString() );
                            System.out.println("====Registrado con exito====");
                        }

                    }else{
                        System.out.println("----Participante ya registrado en la competencia----");
                    }

                    break;
                case 4:

                    System.out.println("Participantes de Easy");
                    if(easyMap.isEmpty()){
                        System.out.println("----Categoria sin participantes----");
                    } else {
                        System.out.println(easyMap);
                    }
                    System.out.println("Participantes de Medium");
                    if(mediumMap.isEmpty()){
                        System.out.println("----Categoria sin participantes----");
                    } else {
                        System.out.println(mediumMap);
                    }
                    System.out.println("Participantes de Hard");
                    if(hardMap.isEmpty()){
                        System.out.println("----Categoria sin participantes----");
                    } else {
                        System.out.println(hardMap);
                    }
                    break;
                case 5:
                    if(easyMap.isEmpty()){
                        System.out.println("----Categoria sin participantes----");
                    } else {
                        System.out.println("ingrese el key del participante que desea eliminar");
                        System.out.println(easyMap.toString());
                        delete = intro.nextInt();
                        easyMap.remove(delete);
                    }

                    break;
                case 6:
                    if(mediumMap.isEmpty()){
                        System.out.println("----Categoria sin participantes-----");
                    } else {
                        System.out.println("ingrese el key del participante que desea eliminar");
                        System.out.println(mediumMap.toString());
                        delete = intro.nextInt();
                        mediumMap.remove(delete);
                    }

                    break;
                case 7:
                    if(hardMap.isEmpty()){
                        System.out.println("----Categoria sin participantes----");
                    } else {
                        System.out.println("Ingrese el key del participante que desea eliminar");
                        System.out.println(easyMap.toString());
                        delete = intro.nextInt();
                        hardMap.remove(delete);
                    }

                    break;
                case 8:
                    System.out.println("Inscripciones cerradas... !Que empiece la carrera!");
                    continue;
                default:
                    System.out.println("Intenta de nuevo");
            }
        }

    }
}
