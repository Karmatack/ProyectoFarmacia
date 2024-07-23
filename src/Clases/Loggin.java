
package Clases;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Loggin {
    private ArrayList <Usuario> usuarios = new ArrayList<>();
    private String nombreArchivo = "usuarios.txt";
    public Loggin(){
        cargarUsuariosDesdeArchivo();
        usuarios.add(new Usuario(0,"Administrador","Admin", "123"));
    }
/*------------------------------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------------------------------*/
    public void cargarUsuariosDesdeArchivo() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            usuarios.clear(); // Limpiar la lista antes de cargar nuevos elementos desde el archivo

            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 4) {
                    int codigo = Integer.parseInt(campos[0]);
                    String tipo = campos[1];
                    String nombre = campos[2];
                    String contraseña = campos[3];
                    Usuario nuevoUsuario = new Usuario(codigo,tipo, nombre ,contraseña);
                    usuarios.add(nuevoUsuario);
                }
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  /*------------------------------------------------------------------------------------------------------------------------------------*/
    public boolean autenticarUsuario(String nombUsuario, String contUsuario){
        for (Usuario usuario : usuarios) {
            if(usuario.getNombre_Usuario().equals(nombUsuario)&& usuario.getContraseña_Usuario().equals(contUsuario)){
                return true;
            }
        }
        return false;
    }
    public String devolverTipoUsuario(String nombUsuario){
        for (Usuario usuario : usuarios) {
            if(usuario.getNombre_Usuario().equals(nombUsuario)){
                return usuario.getTipo_Usuario();
            }
        }
        return "error";
    }
  /*------------------------------------------------------------------------------------------------------------------------------------*/
  /*------------------------------------------------------------------------------------------------------------------------------------*/
    public void agregar_Usuario(Usuario arr){
        usuarios.add(arr);
    }
  /*------------------------------------------------------------------------------------------------------------------------------------*/
  /*------------------------------------------------------------------------------------------------------------------------------------*/
        public ArrayList<Usuario> listarUsuarios(){
        return usuarios;
    }
  /*------------------------------------------------------------------------------------------------------------------------------------*/
  /*------------------------------------------------------------------------------------------------------------------------------------*/
    public int ultimo_CodigoUsuario(){
        int codigo;
        if(usuarios.isEmpty()){
            codigo=1;
            return codigo;
        }
        else{
            codigo=usuarios.get(usuarios.size()-1).getCodigo_Usuario()+1;
            return codigo;
        }
    }
  /*------------------------------------------------------------------------------------------------------------------------------------*/
  /*------------------------------------------------------------------------------------------------------------------------------------*/
    public String reconocer_Usuario(int codigo){
    boolean UsEncontrado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo_Usuario()==codigo){
                    if(usuario.getTipo_Usuario().equals("Operador")){
                        return "Operador";
                    }
                    else{
                        return "Administrador";
                    }
            }
        }
        if(!UsEncontrado){
            JOptionPane.showMessageDialog(null, "No se encontró el usuario con el código digitado");
        }
        return null;
    }
  /*------------------------------------------------------------------------------------------------------------------------------------*/
  /*------------------------------------------------------------------------------------------------------------------------------------*/
    public void eliminar_Usuario(int codigo){
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo_Usuario()==codigo){
                    usuarios.remove(usuario);
                    JOptionPane.showMessageDialog(null, "Usuario eliminado");
                    return;
            }
        }
    }
  /*------------------------------------------------------------------------------------------------------------------------------------*/
  /*------------------------------------------------------------------------------------------------------------------------------------*/
}