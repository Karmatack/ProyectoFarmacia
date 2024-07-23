package FORMULARIOS;

import Clases.Item;
import Clases.OperacionesItems;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelVentas extends javax.swing.JPanel {

     private DefaultTableModel modelo1;
    private DefaultTableModel modelo2;
    String[] columna1 = {"Código","Nombre", "Precio","Stock","Receta Médica"};
    String[] columna2 = {"Nombre", "Precio(s/)","Cantidad","PrecioTotal(s/)"};
    private OperacionesItems oper = new OperacionesItems(); 
    private ArrayList<Item> itms = new ArrayList<>();
    
    public PanelVentas() {
        initComponents();
        modelo1 = new DefaultTableModel(columna1, 0);
        modelo2 = new DefaultTableModel(columna2, 0);
        tblInventario.setModel(modelo1);
        tblVenta.setModel(modelo2);
        oper.cargarItemsDesdeArchivo();         //cargar los archivos
    }
    private void cargarProductosTabla(ArrayList<Item> itm){
        modelo1.setRowCount(0);
        for (Item itms : itm) {
            modelo1.addRow(new Object[]{itms.getCodigo_Item(),itms.getNombre_Item(), itms.getPrecio_Item(),itms.getStock_Item(),itms.getReceta_Item()});
        }
    }
    public String validarEntradas1() {
        if (txtNombreProducto.getText().equals("")){
            return "campo vacío, por favor rellanarlo";
        }
        else if (txtNombreProducto.getText().matches("^[A-Za-z0-9 ]+$")==false){
            return "Error en el nombre, solo usar letras y números";
        }
        else{
            return "";
        }
    }
    public String validarEntradas2() {
        if (txtCodigo.getText().equals("")){
            return "campo vacío, por favor rellanarlo";
        }
        
        else if (oper.strInt(txtCodigo.getText())==-1){
            return "Error en el código";
        }
        else if (repetida(Integer.parseInt(txtCodigo.getText()),oper.listarItems())==true){
            return "Codigo repetido en la tabla";
        }
        else{
            return "";
        }
    }
    void Limpiar1() {
        txtNombreProducto.setText("");
    }
    void Limpiar2() {
        txtCodigo.setText("");
    }
    void LimpiarTabla1(){
        DefaultTableModel model = (DefaultTableModel) tblInventario.getModel();
        model.setRowCount(0);
    }
    void LimpiarTabla2(){
        DefaultTableModel model = (DefaultTableModel) tblVenta.getModel();
        model.setRowCount(0);
    }
    public String Totalpago() {
        double total = 0.0;
            for (int i = 0; i < modelo2.getRowCount(); i++) {
                Object valorCelda = modelo2.getValueAt(i,3);
                if (valorCelda instanceof Number) {
                    total += ((Number) valorCelda).doubleValue();
                } else if (valorCelda != null) {
                    try {
                        total += Double.parseDouble(valorCelda.toString());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error al convertir a número: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);// Manejar el caso en que el valor no sea un número válido
                    }
                }
            }
            return String.valueOf(total);
    }
    void DescontarStock(){
        if(modelo2.getRowCount()!=0){
            for (int i = 0; i < modelo2.getRowCount(); i++) {
                    int valorCeldaStock = (int)modelo2.getValueAt(i,2);             //cantidad
                    String valorCeldaNombre = (String)modelo2.getValueAt(i,0);      //nombre
                    oper.modificarStock(valorCeldaNombre,valorCeldaStock);
                    JOptionPane.showMessageDialog(this,"Hecho !!");
                }
        }
        else{
            JOptionPane.showMessageDialog(this,"Tabla vacía");
        }
    }
    
    boolean repetida(int codigo,ArrayList<Item> itm){
        boolean repe=false;
        for (int i = 0; i < modelo2.getRowCount(); i++) {
            String valorCeldaNombre = (String)modelo2.getValueAt(i,0);
            for (Item itms : itm) {
                   if(codigo==itms.getCodigo_Item()){
                       if(itms.getNombre_Item().equals(valorCeldaNombre)){
                           repe=true;  //declaramos que es un valor repetido
                       }
                   }
            }
        }
        return repe;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        btnBuscarItem = new javax.swing.JButton();
        txtNombreProducto = new javax.swing.JTextField();
        btnLimpiar2 = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        btnListarProductos1 = new javax.swing.JButton();
        btnCompra = new javax.swing.JButton();
        txtTotal = new javax.swing.JLabel();

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInventario.setEnabled(false);
        jScrollPane1.setViewportView(tblInventario);

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
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
        tblVenta.setEnabled(false);
        jScrollPane2.setViewportView(tblVenta);

        btnBuscarItem.setText("Buscar ");
        btnBuscarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarItemActionPerformed(evt);
            }
        });

        txtNombreProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre del Producto"));

        btnLimpiar2.setText("Limpiar Campos");
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });

        txtCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder("Código del Producto"));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnLimpiar1.setText("Limpiar Campos");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        btnListarProductos1.setText("Listar Productos");
        btnListarProductos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProductos1ActionPerformed(evt);
            }
        });

        btnCompra.setText("Efectuar compra");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        txtTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio Total (s/)"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreProducto)
                            .addComponent(btnListarProductos1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLimpiar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuscarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCodigo)
                                .addComponent(btnLimpiar2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBuscarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnListarProductos1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtCodigo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarItemActionPerformed
        if (validarEntradas1().equals("")) {
            ArrayList<Item> coincidencias = oper.busquedaAbrevia(txtNombreProducto.getText());
            
            if(coincidencias!=null&&!coincidencias.isEmpty()){
                LimpiarTabla1();
                cargarProductosTabla(coincidencias);
            }
            else{
                JOptionPane.showMessageDialog(this,"No se encontraron coincidencias");
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this, validarEntradas1());
        }
    }//GEN-LAST:event_btnBuscarItemActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        Limpiar2();
        LimpiarTabla2();
        txtTotal.setText(Totalpago());
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        Limpiar1();
        LimpiarTabla1();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnListarProductos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProductos1ActionPerformed
        cargarProductosTabla(oper.listarItems());
    }//GEN-LAST:event_btnListarProductos1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (validarEntradas2().equals("")){
            Item add = oper.buscar_Item_Codigo(Integer.parseInt(txtCodigo.getText()),1);
                if (add != null) {
                    String a=JOptionPane.showInputDialog("Digite la cantidad, max("+add.getStock_Item()+")");
                    if(a!=null){
                        int cantidad=(oper.strInt(a));
                        if(cantidad<=add.getStock_Item()&&cantidad>0){                             // si a es difente que null && a no está vacío  && si está todo bien 
                            double total;
                            total = Double.parseDouble(new DecimalFormat("0.00").format(add.getPrecio_Item() * oper.strInt(a)));    //darle precisión de 2 decimales

                            modelo2.addRow(new Object[]{add.getNombre_Item(), add.getPrecio_Item(),cantidad,total});     
                            //{"Nombre", "Precio","cantidad","PrecioTotal"};
                        }
                        else if((oper.strInt(a))>add.getStock_Item()){
                            JOptionPane.showMessageDialog(this, "Cancelado, el producto rebasó el stock");
                        }
                        else if(cantidad==0){
                            JOptionPane.showMessageDialog(this, "Cancelado, no se acepta el valor de 0");
                        }
                        else {
                            JOptionPane.showMessageDialog(this, "Cancelado");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "Cancelado");
                    }
                }
                txtTotal.setText(Totalpago());
        }
        else{
            JOptionPane.showMessageDialog(this, validarEntradas2());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        String a=JOptionPane.showInputDialog("¿Está seguro/a que desea efectuar la compra?\nEscriba *SI* para confirmar: ");
        if(a!=null){
            if((a.toLowerCase().equals("si")||a.toLowerCase().equals("sí"))){
                DescontarStock();
                oper.borrar_AgregarArchivo();
                Limpiar2();
                LimpiarTabla2();
            }
            else{
               JOptionPane.showMessageDialog(this, "Cancelado"); 
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Cancelado");
        }
    }//GEN-LAST:event_btnCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarItem;
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnListarProductos1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTable tblVenta;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables

}
