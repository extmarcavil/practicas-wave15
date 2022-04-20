import java.util.ArrayList;

public class Repositorio {

    ArrayList<Localizador> localizadores;

    public Repositorio(){
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public void aplicarDescuentos(Descuento descuentos){
        for (int i = 0; i < localizadores.size(); i++){
            descuentos.aplicar(localizadores.get(i));
        }
    }



}
