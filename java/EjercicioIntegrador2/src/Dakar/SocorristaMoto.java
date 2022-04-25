package Dakar;

public class SocorristaMoto implements Socorrista<Moto>{
    public void socorrer (Moto moto){
        System.out.println("Socorriendo moto..." + moto.getPatente());
    }
}
