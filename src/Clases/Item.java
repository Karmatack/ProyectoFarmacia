
package Clases;

public class Item {
    
    private String nombre_Item;
    private double precio_Item;
    private int stock_Item,codigo_Item;
    private String receta_Item;
    
    public Item(int codigo_Item, String nombre_Item, double precio_Item,int stock_Item , String receta_Item) {
        this.nombre_Item = nombre_Item;
        this.precio_Item = precio_Item;
        this.stock_Item = stock_Item;
        this.codigo_Item = codigo_Item;
        this.receta_Item = receta_Item;
    }
    
    public String getNombre_Item() {
        return nombre_Item;
    }

    public void setNombre_Item(String nombre_Item) {
        this.nombre_Item = nombre_Item;
    }

    public double getPrecio_Item() {
        return precio_Item;
    }

    public void setPrecio_Item(double precio_Item) {
        this.precio_Item = precio_Item;
    }

    public int getStock_Item() {
        return stock_Item;
    }

    public void setStock_Item(int stock_Item) {
        this.stock_Item = stock_Item;
    }

    public int getCodigo_Item() {
        return codigo_Item;
    }

    public void setCodigo_Item(int codigo) {
        this.codigo_Item = codigo;
    }

    public String getReceta_Item() {
        return receta_Item;
    }

    public void setReceta_Item(String receta_Item) {
        this.receta_Item = receta_Item;
    }
}

