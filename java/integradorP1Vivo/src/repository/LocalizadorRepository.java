package repository;

import db.AgenciaTurismoDB;
import model.Cliente;
import model.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository implements Repository<Localizador,Integer>{

    @Override
    public Localizador findById(Integer id) {
        return null;
    }

    @Override
    public Localizador create(Localizador localizador) {
        Cliente cliente=localizador.getCliente();
        if (AgenciaTurismoDB.getLocalizadoresPorCliente().get(cliente) == null) {
            List<Localizador> list=new ArrayList<>();
            list.add(localizador);
            AgenciaTurismoDB.getLocalizadoresPorCliente().put(cliente,list);
        }
        else {
            AgenciaTurismoDB.getLocalizadoresPorCliente().get(cliente).add(localizador);
        }
        return localizador;
    }

    @Override
    public List<Localizador> findAll() {
        List<Localizador> list = new ArrayList<>();
        AgenciaTurismoDB.getLocalizadoresPorCliente().values()
                .forEach(localizadors -> list.addAll(localizadors));
        return list;
    }

    public List<Localizador> findByCliente(Cliente cliente){
        return AgenciaTurismoDB.getLocalizadoresPorCliente().get(cliente);
    }
}
