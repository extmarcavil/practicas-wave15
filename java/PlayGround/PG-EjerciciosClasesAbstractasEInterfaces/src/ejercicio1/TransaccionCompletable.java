package ejercicio1;

public interface TransaccionCompletable<T> {
    public void transaccionOK(T t);
    public void transaccionNOK(T t);
}
