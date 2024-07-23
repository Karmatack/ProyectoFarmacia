
package Clases;

public class Producto {
   
    private String nombre_Item;
    private int cantidad_Item;
    private float precio_Item;
  

    public Producto(String nombre_Item, int cantidad_Item, float precio_Item) {
        this.nombre_Item = nombre_Item;
        this.cantidad_Item = cantidad_Item;
        this.precio_Item = precio_Item;
       
    }
    
    public double total(){
        return cantidad_Item * precio_Item; 
    }
    

    public String getNombre_Item() {
        return nombre_Item;
    }

    public void setNombre_Item(String nombre_Item) {
        this.nombre_Item= nombre_Item;
    }

    public int getCantidad_Item() {
        return cantidad_Item;
    }

    public void setCantidad_Item(int cantidad_Item) {
        this.cantidad_Item = cantidad_Item;
    }

    public float getPrecio_Item() {
        return precio_Item;
    }

    public void setPrecio_Item(float precio_Item) {
        this.precio_Item = precio_Item;
    }

    
    
    
    
    
}
