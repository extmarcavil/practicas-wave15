package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        FiguraGeometrica c = new Circulo(5);
        System.out.println(c.calcularArea());
        FiguraGeometrica t = new Triangulo(3,4);
        System.out.println(t.calcularArea());

    }
}
