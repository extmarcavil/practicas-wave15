public class Distribuidora {
    public static void main(String[] args) {
        NoPerecedero p1 = new NoPerecedero("arroz",200,"cereal");
        Perecedero p2 = new Perecedero("leche",150,3);

        System.out.println(p1);
        System.out.println(p1.calcular(3));
        System.out.println("--------------");
        System.out.println(p2);
        System.out.println(p2.calcular(2));

    }
}
