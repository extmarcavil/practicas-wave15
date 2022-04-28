package abstractasInterfaces.ejercicio2;

import abstractasInterfaces.ejercicio2.document.Document;
import abstractasInterfaces.ejercicio2.document.impl.Curriculums;
import abstractasInterfaces.ejercicio2.document.impl.PDFBooks;
import abstractasInterfaces.ejercicio2.document.impl.Paper;
import abstractasInterfaces.ejercicio2.entity.Hability;
import abstractasInterfaces.ejercicio2.entity.Person;
import abstractasInterfaces.ejercicio2.print.Print;
import abstractasInterfaces.ejercicio2.print.impl.PrintImpl;

import java.util.ArrayList;

public class Main {
    Print printer;
    Document curriculum;
    Document pdfBook;
    Document paper;

    public Main() {
        this.printer = new PrintImpl();
        Hability hability = new Hability("Responsable");
        ArrayList<Hability> habilities = new ArrayList<>();
        habilities.add(hability);
        Person person = new Person(habilities);

        this.curriculum = new Curriculums(person);
        this.pdfBook = new PDFBooks(50, "Felipe", "Titulo", "Drama");
        this.paper = new Paper("Lorem Ipsum", 89, "Carlos", "Gabriel");

        this.printer.print(this.curriculum);
        this.printer.print(this.pdfBook);
        this.printer.print(this.paper);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
