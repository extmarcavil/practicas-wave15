package ar.com.alehenestroza;

public interface Repositorio<K, V> {
    K agregar(V value);
}
