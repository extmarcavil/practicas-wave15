public class Main {
    public static void main(String[] args) {
        Double d = 2.3D;
        Serie serieDe2 = new Serie(d);
        serieDe2.setBase(5.2f);

        System.out.println("------Serie de 2 double");

        System.out.println(serieDe2.next());
        System.out.println(serieDe2.next());
        System.out.println(serieDe2.next());
        System.out.println(serieDe2.next());

        Serie serieDe2ConBase = new Serie(2);
        serieDe2ConBase.setBase(1);

        System.out.println("------Serie de 2 con base");

        System.out.println(serieDe2ConBase.next());
        System.out.println(serieDe2ConBase.next());
        System.out.println(serieDe2ConBase.next());
        System.out.println(serieDe2ConBase.next());

        Serie serieDe3 = new Serie(3);

        System.out.println("------Serie de 3");

        System.out.println(serieDe3.next());
        System.out.println(serieDe3.next());
        System.out.println(serieDe3.next());
        System.out.println(serieDe3.next());
    }
}
