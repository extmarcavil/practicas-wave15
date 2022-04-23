package ejerpracticosp2vivo.calculadora.calculadoradecalorias.repository;

import ejerpracticosp2vivo.calculadora.calculadoradecalorias.model.Ingrediente;

public interface IRepository {

    Ingrediente findByName(Ingrediente ingrediente);

}
