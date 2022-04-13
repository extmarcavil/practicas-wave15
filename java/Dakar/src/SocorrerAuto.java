public class SocorrerAuto extends VehiculoSocorrista<Auto>{
    @Override
    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo auto: " + unAuto.getPatente());
    }
}
