package abstractasInterfaces.ejercicio2.print.impl;

import abstractasInterfaces.ejercicio2.document.Document;
import abstractasInterfaces.ejercicio2.print.Print;

public class PrintImpl implements Print {

    @Override
    public void print(Document document) {
        System.out.println(document.print());
    }
}
