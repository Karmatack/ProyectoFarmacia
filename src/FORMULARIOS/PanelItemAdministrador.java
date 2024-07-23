
package FORMULARIOS;

import Clases.Item;
import Clases.OperacionesItems;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelItemAdministrador extends javax.swing.JPanel {
    
    private DefaultTableModel modelo;
    String[] columna = {"Código","Nombre", "Precio","Stock","Receta Médica"};
    private OperacionesItems oper = new OperacionesItems();
    private Item its;
    
    public PanelItemAdministrador() {
        initComponents();
         modelo = new DefaultTableModel(columna, 0);
        tblRegistro.setModel(modelo);
        oper.cargarItemsDesdeArchivo();
    }
    void LimpiarTabla(){
        DefaultTableModel model = (DefaultTableModel) tblRegistro.getModel();
        model.setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnRegistro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        txtPrecio = new javax.swing.JTextField();
        jcbcReceta = new javax.swing.JComboBox<>();
        btnListar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre del Producto"));

        txtStock.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock"));

        btnRegistro.setText("REGISTRAR");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRegistro);

        txtPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio"));

        jcbcReceta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin receta", "Con receta" }));
        jcbcReceta.setBorder(javax.swing.BorderFactory.createTitledBorder("Receta Médica"));
        jcbcReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbcRecetaActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Limpiar campo");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtPrecio))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbcReceta, 0, 147, Short.MAX_VALUE)
                            .addComponent(txtStock)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistro)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnListar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar)))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbcReceta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistro)
                    .addComponent(btnEliminar)
                    .addComponent(btnListar)
                    .addComponent(btnBorrar)
                    .addComponent(btnBuscar)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cargarProductosTabla(ArrayList<Item> itm){
        modelo.setRowCount(0);
        for (Item itms : itm) {
            modelo.addRow(new Object[]{itms.getCodigo_Item(),
                itms.getNombre_Item(), itms.getPrecio_Item(),
                itms.getStock_Item(),itms.getReceta_Item()});
        }
    }
    public String validarEntradas() {
        if (txtNombre.getText().equals("")){
            return "Error en el nombre";
        }
        else if (oper.strDou(txtPrecio.getText())<0){
            return "Error en el precio";
        }
        else if (oper.strInt(txtStock.getText())==-1){
            return "Error en el stock";
        }
        else{
            return "";
        }
    }
    void Limpiar() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        jcbcReceta.setSelectedIndex(0);
    }
    
    
    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        if (validarEntradas().equals("")) {
            int cod=oper.ultimo_CodigoItem();
            Item producto = new Item(cod,txtNombre.getText(), oper.formatearDouble(Double.parseDouble(txtPrecio.getText())),
                                    Integer.parseInt(txtStock.getText()),jcbcReceta.getSelectedItem().toString());
            oper.agregar_Item(producto);
            cargarProductosTabla(oper.listarItems());
            Limpiar();
            oper.borrar_AgregarArchivo();
        }
        else{
            JOptionPane.showMessageDialog(this, validarEntradas());
        }
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void jcbcRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbcRecetaActionPerformed
        
    }//GEN-LAST:event_jcbcRecetaActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        
        String a=JOptionPane.showInputDialog("Ordenamiento por Nombre(1) , por Código(2) o por Stock\nDigite 1-3");
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
            else if(cd==3){
                oper.ordenar_Cantidad();
                JOptionPane.showMessageDialog(null, "HECHO");
            }
            else{
               JOptionPane.showMessageDialog(null, "Error, digite un valor correcto (1-3)");
            }
            cargarProductosTabla(oper.listarItems());
        }
        else{
            JOptionPane.showMessageDialog(null, "Cancelado");
        }
        
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        Limpiar();
        LimpiarTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String a=JOptionPane.showInputDialog("Eliminado por Nombre(1)-Código(2) ");
        if(a!=null){
            int k=oper.strInt(a);
            if(k==1){
                a=JOptionPane.showInputDialog("Digite el nombre del item que desea eliminar");
                if(a!=null){
                        Limpiar();
                        oper.eliminar_Item_Nombre(a);
                        LimpiarTabla();
                        cargarProductosTabla(oper.listarItems());

                }
                else{
                    JOptionPane.showMessageDialog(null, "Cancelado");
                }
            }
            else if(k==2){
                a=JOptionPane.showInputDialog("Digite el código del item que desea eliminar");
                if(a!=null){
                    int cd=oper.strInt(a);
                    if(cd != -1){
                        Limpiar();
                        oper.eliminar_Item_Codigo(cd);
                        LimpiarTabla();
                        cargarProductosTabla(oper.listarItems());
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String a=JOptionPane.showInputDialog("Búsqueda por Nombre (1)-Búsqueda por código(2)\nDigitar 1-2");
        if(a!=null){
            int cd=oper.strInt(a);
            if(cd==1){
                String nom=JOptionPane.showInputDialog("Digite el nombre del item que desea buscar");
                if(nom != null){
                    Limpiar();
                    oper.buscar_Item_Nomb(nom,1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Cancelado");
                }
            }
            else if(cd==2){
                cd=oper.strInt(JOptionPane.showInputDialog("Digite el código del item que desea buscar"));
                if(cd!= -1){
                    Limpiar();
                    oper.buscar_Item_Codigo(cd,1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Cancelado");
                }
            }
            else{    
                JOptionPane.showMessageDialog(null, "Mision abortada, Error en digitación(1-2)");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Cancelado");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String cd=JOptionPane.showInputDialog("Opciones a elegir:\nEditar por Nombre(1)-Código(2)\nDigite 1-2");
        if(cd!=null){
            if(cd.equals("1")){
                cd=JOptionPane.showInputDialog("Digite el nombre del item que desea editar");
                if(cd != null){
                    Limpiar();
            
                    its=oper.buscar_Item_Nomb(cd,2);
            
                    if (its!=null){
                        LimpiarTabla();
                        modelo.addRow(new Object[]{its.getCodigo_Item(),its.getNombre_Item(), its.getPrecio_Item(),its.getStock_Item(),its.getReceta_Item()});
                    }
                    else{
                        cargarProductosTabla(oper.listarItems());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Mision abortada");
                }
            }
            else if(cd.equals("2")){
                cd=JOptionPane.showInputDialog("Digite el código del item que desea editar");
                if(cd != null){
                    Limpiar();
            
                    its=oper.buscar_Item_Codigo(oper.strInt(cd),2);
            
                    if (its!=null){
                        LimpiarTabla();
                        modelo.addRow(new Object[]{its.getCodigo_Item(),its.getNombre_Item(), its.getPrecio_Item(),its.getStock_Item(),its.getReceta_Item()});
                    }
                    else{
                        cargarProductosTabla(oper.listarItems());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Mision abortada");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Valor fuera de rango, solo 1 y 2");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Cancelado");
        }
        oper.borrar_AgregarArchivo();
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnRegistro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbcReceta;
    private javax.swing.JTable tblRegistro;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
