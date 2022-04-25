package Dakar;

public class SocorristaAuto implements Socorrista<Auto>{

    public void socorrer (Auto auto){
        System.out.println("Socorriendo auto..." + auto.getPatente());
    }
}
