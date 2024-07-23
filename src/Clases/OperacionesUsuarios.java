package Clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;


public class OperacionesUsuarios {
    private ArrayList<Usuario> usuaris = new ArrayList<>();
    private String nombreArchivo = "usuarios.txt";
/*------------------------------------------------------------------------------------------------------------------------------------*/   
/*------------------------------------------------------------------------------------------------------------------------------------*/   
    public void cargarUsuariosDesdeArchivo() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            usuaris.clear(); // Limpiar la lista antes de cargar nuevos elementos desde el archivo

            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 4) {
                    int codigo = Integer.parseInt(campos[0]);
                    String tipo = campos[1];
                    String nombre = campos[2];
                    String contraseña = campos[3];
                    Usuario nuevoUsuario = new Usuario(codigo,tipo, nombre ,contraseña);
                    usuaris.add(nuevoUsuario);
                }
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void agregar_Usuario(Usuario arr){
        usuaris.add(arr);
    }
    public void borrar_AgregarArchivo(){
        try (FileWriter escritor = new FileWriter(nombreArchivo)) {
            // Escribe nada en el archivo para borrar su contenido
            escritor.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Usuario usuario : usuaris) {
                String linea = String.format("%d,%s,%s,%s", usuario.getCodigo_Usuario(), usuario.getTipo_Usuario(),usuario.getNombre_Usuario(),usuario.getContraseña_Usuario());
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
        Collections.sort(usuaris, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario usuario1, Usuario usuario2) {
                return usuario1.getNombre_Usuario().compareTo(usuario2.getNombre_Usuario());
            }
        });
    }
    public void ordenar_Codigo() {
        Collections.sort(usuaris, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario usuario1, Usuario usuario2) {
                return Integer.compare(usuario1.getCodigo_Usuario(), usuario2.getCodigo_Usuario());
            }
        });
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/   
/*------------------------------------------------------------------------------------------------------------------------------------*/
   //BUSCAR Y MODIFICAR FALTAAAAA ES NOCHEEEEEEE
/*------------------------------------------------------------------------------------------------------------------------------------*/   
/*------------------------------------------------------------------------------------------------------------------------------------*/
    public ArrayList<Usuario> listarUsuarios(){
        return usuaris;
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/   
/*------------------------------------------------------------------------------------------------------------------------------------*/    
    public int ultimo_CodigoUsuario(){
        int codigo;
        if(usuaris.isEmpty()){         //si el historial está vacío 
            codigo=1;               //iniciar con 1
            return codigo;
        }
        else{
            codigo=usuaris.get(usuaris.size()-1).getCodigo_Usuario()+1;  //Agarrar el último valor y aumentarle en +1 al siguiente
            return codigo;  //retornar la variable tipo entero para definir en el algoritmo
        }
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/   
/*------------------------------------------------------------------------------------------------------------------------------------*/     
    public void eliminar_usuario_Codigo(int codigo){      //Código para eliminar, si lo encuentra lo elimina
        boolean usuarioEncontrado = false;
        for (Usuario usuario : usuaris) {
            if (usuario.getCodigo_Usuario()==codigo){
                String k=JOptionPane.showInputDialog("Usuario encontrado:\nCódigo: "+usuario.getCodigo_Usuario()+"\nNombre: "+usuario.getNombre_Usuario()+
                                                     "\nTipo de usuario: "+usuario.getTipo_Usuario()+"\nDesea eliminarlo ?, Escriba *CONFIRMAR* con mayúscula: ");
                        if(k.equals("CONFIRMAR")){
                            usuaris.remove(usuario);
                            JOptionPane.showMessageDialog(null, "usuario eliminado");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "MISIÓN ABORTADA");
                        }
                return;
            }
        }
        if(!usuarioEncontrado){                    // Si no lo encontró , salta mensaje
                JOptionPane.showMessageDialog(null, "No se encontró el usuario con el código digitado");
            }
    }
    public void eliminar_usuario_Nombre(String nombre){      //Código para eliminar, si lo encuentra lo elimina
        boolean itemEncontrado = false;
        for (var usuario : usuaris) {
            if (usuario.getNombre_Usuario().equals(nombre)){
                String k=JOptionPane.showInputDialog("Usuario encontrado:\nCódigo: "+usuario.getCodigo_Usuario()+"\nNombre: "+usuario.getNombre_Usuario()+
                                                     "\nTipo de usuario: "+usuario.getTipo_Usuario()+"\nDesea eliminarlo ?, Escriba *CONFIRMAR* con mayúscula: ");
                        if(k.equals("CONFIRMAR")){
                            usuaris.remove(usuario);
                            JOptionPane.showMessageDialog(null, "usuario eliminado");
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
