package FORMULARIOS;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

public class PrincipalAdministrador extends javax.swing.JFrame {
    
    public PrincipalAdministrador() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuInventario = new javax.swing.JMenu();
        menuVentas = new javax.swing.JMenu();
        menuUsuarios = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        escritorio.setBackground(new java.awt.Color(255, 255, 255));
        escritorio.setPreferredSize(new java.awt.Dimension(863, 598));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 863, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
        );

        menuInventario.setText("Inventario");
        menuInventario.setMinimumSize(new java.awt.Dimension(127, 22));
        menuInventario.setPreferredSize(new java.awt.Dimension(127, 22));
        menuInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuInventarioMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuInventario);

        menuVentas.setText("Ventas");
        menuVentas.setMinimumSize(new java.awt.Dimension(127, 22));
        menuVentas.setPreferredSize(new java.awt.Dimension(127, 22));
        menuVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuVentasMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuVentas);

        menuUsuarios.setText("Usuarios");
        menuUsuarios.setMinimumSize(new java.awt.Dimension(127, 22));
        menuUsuarios.setPreferredSize(new java.awt.Dimension(127, 22));
        menuUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuUsuariosMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuUsuarios);

        menuSalir.setText("Salir");
        menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSalirMouseClicked(evt);
            }
        });
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSalirMouseClicked
        int opc = JOptionPane.showConfirmDialog(this, "Seguro de salir","Mensaje de confirmacion", 
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(opc == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_menuSalirMouseClicked

    private void menuInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuInventarioMouseClicked
        PanelItemAdministrador its = new PanelItemAdministrador();
        its.setSize(30767, 30767); //
        its.setLocation(0,0);
        escritorio.removeAll();
        escritorio.add(its, BorderLayout.CENTER);
        escritorio.revalidate();
        escritorio.repaint();
    }//GEN-LAST:event_menuInventarioMouseClicked

    private void menuUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUsuariosMouseClicked
        PanelUsuarios usu = new PanelUsuarios();
        usu.setSize(30767, 30767); 
        usu.setLocation(0,0);
        escritorio.removeAll();
        escritorio.add(usu, BorderLayout.CENTER);
        escritorio.revalidate();
        escritorio.repaint();
    }//GEN-LAST:event_menuUsuariosMouseClicked

    private void menuVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuVentasMouseClicked
        PanelVentas ventas = new PanelVentas();
        ventas.setSize(30767, 30767); 
        ventas.setLocation(0,0);
        escritorio.removeAll();
        escritorio.add(ventas, BorderLayout.CENTER);
        escritorio.revalidate();
        escritorio.repaint();
        
    }//GEN-LAST:event_menuVentasMouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuInventario;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenu menuVentas;
    // End of variables declaration//GEN-END:variables
}
