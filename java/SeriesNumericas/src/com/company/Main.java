package com.company;

public class Main {

    public static void main(String[] args) {
        Serie s = new Serie(2);
        System.out.println(s.next());
        System.out.println(s.next());

        SerieEnteros s2 = new SerieEnteros(3);
        System.out.println(s2.next());
        System.out.println(s2.next());

        s2.start(5.5);
        System.out.println(s2.next());
        System.out.println(s2.next());
    }
}
