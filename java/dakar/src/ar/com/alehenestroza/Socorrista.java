package ar.com.alehenestroza;

public interface Socorrista<T extends Vehiculo> {
    void socorrer(T vehiculo);
}
