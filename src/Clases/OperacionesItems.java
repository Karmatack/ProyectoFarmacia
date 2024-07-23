package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashSet;

    
public class OperacionesItems {
    private ArrayList<Item> itms = new ArrayList<>();
    private String nombreArchivo = "inventario.txt";
/*------------------------------------------------------------------------------------------------------------------------------------*/   
/*------------------------------------------------------------------------------------------------------------------------------------*/   
    public void cargarItemsDesdeArchivo() {
    try {
        BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        itms.clear(); // Limpiar la lista antes de cargar nuevos elementos desde el archivo

        while ((linea = lector.readLine()) != null) {
            String[] campos = linea.split(",");
            if (campos.length == 5) {
                int codigo = Integer.parseInt(campos[0]);
                String nombre = campos[1];
                double precio = Double.parseDouble(campos[2]);
                int stock = Integer.parseInt(campos[3]);
                String receta = campos[4];
                Item nuevoItem = new Item(codigo, nombre, precio, stock, receta);
                itms.add(nuevoItem);
            }
        }
        lector.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public void agregar_Item(Item item){
        itms.add(item);
    }
    public void borrar_AgregarArchivo(){
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            // Escribe nada en el archivo para borrar su contenido
            escritor.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Item item : itms) {
                String linea = String.format("%d,%s,%.2f,%d,%s", item.getCodigo_Item(), item.getNombre_Item(), item.getPrecio_Item(), item.getStock_Item(), item.getReceta_Item());
                escritor.write(linea);
                escritor.newLine(); // Agrega un salto de línea para el próximo elemento
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
/*------------------------------------------------------------------------------------------------------------------------------------*/   
/*------------------------------------------------------------------------------------------------------------------------------------*/
    public void ordena_Nombre() {
        Collections.sort(itms, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.getNombre_Item().compareTo(item2.getNombre_Item());
            }
        });
    }
    public void ordenar_Codigo() {
        Collections.sort(itms, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Integer.compare(item1.getCodigo_Item(), item2.getCodigo_Item());
            }
        });
    }
    public void ordenar_Cantidad() {
        Collections.sort(itms, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Integer.compare(item1.getStock_Item(), item2.getStock_Item());
            }
        });
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/   
/*------------------------------------------------------------------------------------------------------------------------------------*/ 

    public Item buscar_Item_Codigo(int codigo,int a){ // 1 es solo para buscar, 2 es para editar
        boolean itemEncontrado = false;
        for (Item item : itms) {
            String c= "";
            double precio;
            if (item.getCodigo_Item()==codigo){
                String message = "Código: " + item.getCodigo_Item() + "\n" +
                 "Nombre: " + item.getNombre_Item() + "\n" +
                 "Precio: " + item.getPrecio_Item() + "\n" +
                 "Stock: " + item.getStock_Item() + "\n" +
                 "Receta: " + item.getReceta_Item();
                JOptionPane.showMessageDialog(null, message);       //imprimir lo buscado
                if(a==1){                                           //si solo se eligió para buscar, acaba todo aquí
                    return item;
                }
                else{
                    itemEncontrado = true;
                    String f= JOptionPane.showInputDialog("Digite lo que desea en valor numérico\nlo que desea editar:(1)Nombre,(2)Precio,(3)Stock,(otro)Receta");
                    if(f!=null){
                        int b=strInt(f);
                        if(b!=-1){
                            switch (b) {
                                case 1:                                                                         //Editar el nombre
                                    c=JOptionPane.showInputDialog("Digite el nuevo nombre: ");
                                    if(c!=null){
                                        item.setNombre_Item(c);
                                        JOptionPane.showMessageDialog(null, "Nombre corregido.");
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Cancelado");
                                    }
                                break;
                                
                                case 2:                                                                         //Editar el precio
                                    f=JOptionPane.showInputDialog("Digite el nuevo precio: ");
                                    if(f!=null){
                                        precio=strDou(f);
                                        if(precio!=-1){
                                            item.setPrecio_Item(precio);
                                            JOptionPane.showMessageDialog(null, "Precio corregido.");
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Cancelado");
                                    }
                                break;
                            
                                case 3:                                                                         //Editar el stock, aquí me di cuenta que mi función creada no servía
                                c=JOptionPane.showInputDialog("Digite el nuevo Stock: ");                   //así que hice otro código simple para optener valores 0
                                if(c!=null){
                                    int actualizado = strInt(c);
                                    if(actualizado!=-1){
                                        item.setStock_Item(actualizado);
                                        JOptionPane.showMessageDialog(null, "Stock corregido.");
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Cancelado");
                                }
                                break;
                            
                                default:                                                                        //Editar receta
                                    f=JOptionPane.showInputDialog("Digite la nueva receta (1)Sin Receta-(2)Con Receta");
                                    if(f!=null){
                                        a=strInt(f);
                                        if(a!=-1){
                                            switch (a) {
                                                case 1:
                                                    item.setReceta_Item("Sin receta");
                                                    JOptionPane.showMessageDialog(null, "Receta corregida.");
                                                break;
                                                
                                                case 2:
                                                    item.setReceta_Item("Con receta");
                                                    JOptionPane.showMessageDialog(null, "Receta corregida.");
                                                break;
                                                
                                                case -1:
                                                break;
                                                
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Error , valor no establecido, vuelva a intentarlo.");
                                                break;
                                            }
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Cancelado");
                                    }
                                    
                                break;
                            }                                                       
                            message = "Código: " + item.getCodigo_Item() + "\n" +   //Mostar en pantalla el nuevo valor 
                            "Nombre: " + item.getNombre_Item() + "\n" +
                             "Precio: " + item.getPrecio_Item() + "\n" +
                            "Stock: " + item.getStock_Item() + "\n" +
                            "Receta: " + item.getReceta_Item();
                            JOptionPane.showMessageDialog(null, message);
                            return item;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Cancelado");
                    }
                }
            }
        }
        if(!itemEncontrado){            //cuando termina el bucle y no encuentra
                JOptionPane.showMessageDialog(null, "No se encontró el artículo con el código digitado");
            }
    return null;
    }
    public Item buscar_Item_Nomb(String nombre,int a){ // 1 es solo para buscar, 2 es para editar
        boolean itemEncontrado = false;
        for (Item item : itms) {
            String c= "";
            double precio;
            if (item.getNombre_Item().equals(nombre)){
                String message = "Código: " + item.getCodigo_Item() + "\n" +
                 "Nombre: " + item.getNombre_Item() + "\n" +
                 "Precio: " + item.getPrecio_Item() + "\n" +
                 "Stock: " + item.getStock_Item() + "\n" +
                 "Receta: " + item.getReceta_Item();
                JOptionPane.showMessageDialog(null, message);       //imprimir lo buscado
                if(a==1){                                           //si solo se eligió para buscar, acaba todo aquí
                    return item;
                }
                else{
                    int b=strInt(JOptionPane.showInputDialog("Digite lo que desea en valor numérico\nlo que desea editar:(1)Nombre,(2)Precio,(3)Stock,(otro)Receta"));
                    if(b!=-1){
                        switch (b) {
                            case 1:                                                                         //Editar el nombre
                                c=JOptionPane.showInputDialog("Digite el nuevo nombre: ");
                                item.setNombre_Item(c);
                                JOptionPane.showMessageDialog(null, "Nombre corregido.");
                            break;
                                
                            case 2:                                                                         //Editar el precio
                                precio=strDou(JOptionPane.showInputDialog("Digite el nuevo precio: "));
                                if(precio!=-1){
                                    item.setPrecio_Item(precio);
                                    JOptionPane.showMessageDialog(null, "Precio corregido.");
                                }
                            break;
                            
                            case 3:                                                                         //Editar el stock, aquí me di cuenta que mi función creada no servía
                                c=JOptionPane.showInputDialog("Digite el nuevo Stock: ");                   //así que hice otro código simple para optener valores 0
                                try {
                                    int actualizado = Integer.parseInt(c);
                                    if(actualizado<0){
                                        JOptionPane.showMessageDialog(null, "Por favor, digite valores mayores o iguales que 0.");
                                    }
                                    else{
                                        item.setStock_Item(actualizado);
                                        JOptionPane.showMessageDialog(null, "Stock corregido.");
                                    }
                                }catch (NumberFormatException e) {
                                    // La entrada no es un número válido, mostramos un mensaje de error
                                    JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.");
                                }
                            break;
                            
                            default:                                                                        //Editar receta 
                                a=strInt(JOptionPane.showInputDialog("Digite la nueva receta (1)Sin Receta-(2)Con Receta"));
                                if(a!=-1){
                                    switch (a) {
                                    case 1:
                                        item.setReceta_Item("Sin receta");
                                        JOptionPane.showMessageDialog(null, "Receta corregida.");
                                        break;
                                    case 2:
                                        item.setReceta_Item("Con receta");
                                        JOptionPane.showMessageDialog(null, "Receta corregida.");
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Error , valor no establecido, vuelva a intentarlo.");
                                        break;
                                    }
                                }
                            break;
                        }                                                       
                        message = "Código: " + item.getCodigo_Item() + "\n" +   //Mostar en pantalla el nuevo valor 
                        "Nombre: " + item.getNombre_Item() + "\n" +
                        "Precio: " + item.getPrecio_Item() + "\n" +
                        "Stock: " + item.getStock_Item() + "\n" +
                        "Receta: " + item.getReceta_Item();
                        JOptionPane.showMessageDialog(null, message);
                        return item;
                    }
                }
            }
        }
        if(!itemEncontrado){            //cuando termina el bucle y no encuentra
                JOptionPane.showMessageDialog(null, "No se encontró el artículo con el nombre digitado");
            }
    return null;
    }
    
    public ArrayList<Item> busquedaAbrevia(String palabra){
        ArrayList<Item> coincidencias = new ArrayList<>();
        palabra=palabra.toLowerCase(); //para poner todo en minúscula
        String comparador;
        for (Item item : itms) {
            comparador=item.getNombre_Item().toLowerCase();
            if(comparador.contains(palabra)){
            coincidencias.add(item);
            }
        }
        return coincidencias;
    }
    public void modificarStock(String nombre,int stock){
        for (Item item : itms) {
                if(item.getNombre_Item().equals(nombre)){
                        item.setStock_Item(item.getStock_Item()-stock);
                }
        }
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/   
/*------------------------------------------------------------------------------------------------------------------------------------*/    
    public ArrayList<Item> listarItems(){
        return itms;
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/ 
/*------------------------------------------------------------------------------------------------------------------------------------*/      
    public int ultimo_CodigoItem(){
        int codigo;
        if(itms.isEmpty()){         //si el historial está vacío 
            codigo=1;               //iniciar con 1
            return codigo;
        }
        else{
            codigo=itms.get(itms.size()-1).getCodigo_Item()+1;  //Agarrar el último valor y aumentarle en +1 al siguiente
            return codigo;  //retornar la variable tipo entero para definir en el algoritmo
        }
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/ 
/*------------------------------------------------------------------------------------------------------------------------------------*/    
    public void eliminar_Item_Codigo(int codigo){      //Código para eliminar, si lo encuentra lo elimina
        boolean itemEncontrado = false;
        for (Item item : itms) {
            if (item.getCodigo_Item()==codigo){
                String k=JOptionPane.showInputDialog("Artículo encontrado:\nCódigo: "+item.getCodigo_Item()+"\nNombre: "+item.getNombre_Item()+
                        "\n Desea eliminarlo ?, Escriba *CONFIRMAR* con mayúscula: ");
                if(k!=null){
                    if(k.equals("CONFIRMAR")){
                            itms.remove(item);
                            JOptionPane.showMessageDialog(null, "artículo eliminado");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "MISIÓN ABORTADA");
                        }
                }
                else{
                    JOptionPane.showMessageDialog(null, "MISIÓN ABORTADA");
                }
                        
                return;
            }
        }
        if(!itemEncontrado){                    // Si no lo encontró , salta mensaje
                JOptionPane.showMessageDialog(null, "No se encontró el artículo con el código digitado");
            }
    }
    public void eliminar_Item_Nombre(String nombre){      //Código para eliminar, si lo encuentra lo elimina
        boolean itemEncontrado = false;
        for (var item : itms) {
            if (item.getNombre_Item().equals(nombre)){
                String k=JOptionPane.showInputDialog("Artículo encontrado:\nCódigo: "+item.getCodigo_Item()+"\nNombre: "+item.getNombre_Item()+
                        "\n Desea eliminarlo ?, Escriba *CONFIRMAR* con mayúscula: ");
                        if(k.equals("CONFIRMAR")){
                            itms.remove(item);
                            JOptionPane.showMessageDialog(null, "artículo eliminado");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "MISIÓN ABORTADA");
                        }
                return;
            }
        }
        if(!itemEncontrado){                    // Si no lo encontró , salta mensaje
                JOptionPane.showMessageDialog(null, "No se encontró el artículo con el nombre digitado");
            }
    }
 /*------------------------------------------------------------------------------------------------------------------------------------*/   
 /*------------------------------------------------------------------------------------------------------------------------------------*/
    public double strDou(String valor) {    //Convertir el valor en texto a un número de formato de 2 dígitos decimales --> 0.00
                                            //Condición, que no valide si es 0 si vas a utilizar este método 
        boolean showError = true; // Variable para controlar la visualización de errores
        try {
            double actualizado = Double.parseDouble(valor);
                if(actualizado<0){
                    if (showError) {
                        JOptionPane.showMessageDialog(null, "Por favor, digite valores mayores o iguales que 0.");
                        showError = false; // Establece showError en false para evitar mensajes repetidos.
                    }
                    return -1;
                }
                else{
                actualizado=Double.parseDouble(String.format("%.2f", actualizado));
                return actualizado;
                }
                
        }catch (NumberFormatException e) {
            // La entrada no es un número válido, mostramos un mensaje de error
            if (showError) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.");
                showError = false; // Establece showError en false para evitar mensajes repetidos.
            }
                return -1;
        }
    }
    public int strInt(String valor) {    //Convertir el valor en texto a un número de formato de 2 dígitos decimales --> 0.00
                                        //Condición, que no valide si es 0 si vas a utilizar este método
        boolean showError = true; // Variable para controlar la visualización de errores
        try {
            int actualizado = Integer.parseInt(valor);
                if(actualizado<0){
                    if (showError) {
                        JOptionPane.showMessageDialog(null, "Por favor, digite valores mayores o iguales que 0.");
                        showError = false; // Establece showError en false para evitar mensajes repetidos.
                    }
                    
                    return -1;
                }
                else{
                return actualizado;
                }
                
        }catch (NumberFormatException e) {
            // La entrada no es un número válido, mostramos un mensaje de error
            if (showError) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.");
                showError = false; // Establece showError en false para evitar mensajes repetidos.
            }
            return -1;
        }
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/
 /*------------------------------------------------------------------------------------------------------------------------------------*/   
    public static double formatearDouble(double numero) {           // Para redondear el número, ejemplo: 1.9812=2.0  9.29= 9.3
        return Double.parseDouble(String.format("%.1f", numero));
    }
 /*------------------------------------------------------------------------------------------------------------------------------------*/
 /*------------------------------------------------------------------------------------------------------------------------------------*/  
}
