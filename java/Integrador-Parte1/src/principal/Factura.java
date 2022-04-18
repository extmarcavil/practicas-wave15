package principal;
import java.util.*;

public class Factura {
   Cliente cliente;
   List<Producto> listaProductos;
   float total;

   public Factura(Cliente cliente, List<Producto> listaProductos) {
      this.cliente = cliente;
      this.listaProductos = listaProductos;
      this.total = 0;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public List<Producto> getListaProductos() {
      return listaProductos;
   }

   public void setListaProductos(List<Producto> listaProductos) {
      this.listaProductos = listaProductos;
   }

   public float getTotal() {
      for ( Producto producto: listaProductos) {
         total= total+ producto.getCosto();
      }
      return total;
   }

   @Override
   public String toString() {
      return "Factura{" +
              "cliente=" + cliente +'\n'+
              ", listaProductos=" + listaProductos + '\n'+
              ", total=" + getTotal() +
              '}';
   }

   public void setTotal(int total) {
      this.total = total;
   }


}
