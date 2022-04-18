public class Socorrista {
    public void socorrer(Auto auto){
        System.out.println("Socorriendo Auto");
        System.out.println(auto.getPatente());
    }
    public void socorrer(Motocicleta moto){
        System.out.println("Socorriendo Moto");
        System.out.println(moto.getPatente());
    }
}
