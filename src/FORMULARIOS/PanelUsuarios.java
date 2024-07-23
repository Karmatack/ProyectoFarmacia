
package FORMULARIOS;

import Clases.Usuario;
import Clases.OperacionesUsuarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class PanelUsuarios extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    String[] columna = {"Código","Tipo de usuario", "Nombre de usuario","Contraseña"};
    private OperacionesUsuarios oper = new OperacionesUsuarios();
    private Usuario usu;
    
    
    public PanelUsuarios() {
        initComponents();
         modelo = new DefaultTableModel(columna, 0);
        tblUsuario.setModel(modelo);
        oper.cargarUsuariosDesdeArchivo();
    }
    
    void LimpiarTabla(){
            DefaultTableModel model = (DefaultTableModel) tblUsuario.getModel();
        model.setRowCount(0);
    }
    private void cargarProductosTabla(ArrayList<Usuario> usuaris){
        modelo.setRowCount(0);
        for (Usuario usuario : usuaris) {
            modelo.addRow(new Object[]{usuario.getCodigo_Usuario(),
                usuario.getTipo_Usuario(),usuario.getNombre_Usuario(),
                usuario.getContraseña_Usuario()});
        }
    }
    public String validarEntradas() {
        if (txtNombre.getText().equals("")){
            return "Error en el nombre";
        }
        else if (txtContraseña.getText().equals("")){
            return "Error en la contraseña";
        }

        else{
            return "";
        }
    }
    void Limpiar() {
        txtNombre.setText("");
        txtContraseña.setText("");
        jcbcTipo.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbcTipo = new javax.swing.JComboBox<>();
        btnListar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        txtContraseña = new javax.swing.JTextField();

        jcbcTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Operador", "Administrador" }));
        jcbcTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Usuario"));
        jcbcTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbcTipoActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar campo");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre del Usuario"));

        btnRegistro.setText("REGISTRAR");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblUsuario);

        txtContraseña.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraseña"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addComponent(jcbcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistro)
                    .addComponent(btnEliminar)
                    .addComponent(btnListar)
                    .addComponent(btnLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbcTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbcTipoActionPerformed

    }//GEN-LAST:event_jcbcTipoActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed

        String a=JOptionPane.showInputDialog("Ordenamiento por Nombre(1) o por Código(2)\nDigite 1-2: ");
        if(a!=null){
            int cd=oper.strInt(a);
            if(cd==1){
                oper.ordena_Nombre();
                JOptionPane.showMessageDialog(null, "HECHO");
            }
            else if(cd==2){
                oper.ordenar_Codigo();
                JOptionPane.showMessageDialog(null, "HECHO");
            }
            else{
                JOptionPane.showMessageDialog(null, "Error, digite un valor correcto (1-2)");
            }
            cargarProductosTabla(oper.listarUsuarios());
        }
        else{
            JOptionPane.showMessageDialog(null, "Cancelado");
        }

    }//GEN-LAST:event_btnListarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
        LimpiarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String a=JOptionPane.showInputDialog("Eliminado por Nombre(1)-Código(2) ");
        if(a!=null){
            int k=oper.strInt(a);
            if(k==1){
                a=JOptionPane.showInputDialog("Digite el nombre del Usuario que desea eliminar");
                if(a!=null){
                    Limpiar();
                    oper.eliminar_usuario_Nombre(a);
                    LimpiarTabla();
                    cargarProductosTabla(oper.listarUsuarios());

                }
                else{
                    JOptionPane.showMessageDialog(null, "Cancelado");
                }
            }
            else if(k==2){
                a=JOptionPane.showInputDialog("Digite el código del usuario que desea eliminar");
                if(a!=null){
                    int cd=oper.strInt(a);
                    if(cd != -1){
                        Limpiar();
                        oper.eliminar_usuario_Codigo(cd);
                        LimpiarTabla();
                        cargarProductosTabla(oper.listarUsuarios());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Mision abortada");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Cancelado");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Cancelado");
        }
        oper.borrar_AgregarArchivo();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        if (validarEntradas().equals("")) {
            int cod=oper.ultimo_CodigoUsuario();
            Usuario usuario = new Usuario(cod,jcbcTipo.getSelectedItem().toString(),txtNombre.getText(),txtContraseña.getText());
            oper.agregar_Usuario(usuario);
            cargarProductosTabla(oper.listarUsuarios());
            Limpiar();
            oper.borrar_AgregarArchivo();
        }
        else{
            JOptionPane.showMessageDialog(this, validarEntradas());
        }
    }//GEN-LAST:event_btnRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbcTipo;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
