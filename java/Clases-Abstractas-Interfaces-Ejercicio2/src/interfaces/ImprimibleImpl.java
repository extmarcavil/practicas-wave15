package interfaces;

import model.Documento;

public class ImprimibleImpl implements Imprimible{
    @Override
    public void imprimir(Documento d) {
        System.out.println(d.imprimir());
    }
}
