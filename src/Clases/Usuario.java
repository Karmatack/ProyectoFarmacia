
package Clases;

public class Usuario {
    private String nombre_Usuario,contraseña_Usuario,tipo_Usuario;
    private int codigo_Usuario;

    public Usuario(int codigo_Usuario,String tipo_Usuario,String nombre_Usuario, String contraseña_Usuario ) {
        this.nombre_Usuario = nombre_Usuario;
        this.contraseña_Usuario = contraseña_Usuario;
        this.tipo_Usuario = tipo_Usuario;
        this.codigo_Usuario = codigo_Usuario;
    }
    
    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public String getContraseña_Usuario() {
        return contraseña_Usuario;
    }

    public void setContraseña_Usuario(String contraseña_Usuario) {
        this.contraseña_Usuario = contraseña_Usuario;
    }

    public String getTipo_Usuario() {
        return tipo_Usuario;
    }

    public void setTipo_Usuario(String tipo_Usuario) {
        this.tipo_Usuario = tipo_Usuario;
    }

    public int getCodigo_Usuario() {
        return codigo_Usuario;
    }

    public void setCodigo_Usuario(int codigo_Usuario) {
        this.codigo_Usuario = codigo_Usuario;
    }

    
    
}
