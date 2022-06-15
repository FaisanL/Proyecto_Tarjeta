/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.TarjetaDAO;
import javax.swing.JOptionPane;
import modelo.TarjetaB;

/**
 *
 * @author ffmor
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCrear = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnViajar = new javax.swing.JButton();
        btnCargar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCrear.setText("Crear tarjeta ");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Datos");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnViajar.setText("Viajar ");
        btnViajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViajarActionPerformed(evt);
            }
        });

        btnCargar.setText("Cargar tarjeta");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(btnViajar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnCrear)
                .addGap(36, 36, 36)
                .addComponent(btnMostrar)
                .addGap(36, 36, 36)
                .addComponent(btnViajar)
                .addGap(36, 36, 36)
                .addComponent(btnCargar)
                .addGap(41, 41, 41)
                .addComponent(btnSalir)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
       String codigo=JOptionPane.showInputDialog("Ingrese codigo a buscar");
       TarjetaDAO tarD=new TarjetaDAO();
       TarjetaB tt=tarD.buscarTarjeta(codigo);
       int c,t;
        TarjetaB ta=null;
       
       if(tt==null)
           JOptionPane.showMessageDialog(this, "Codigo de tarjeta  no existe");
       else
       {
           int total=Integer.parseInt(JOptionPane.showInputDialog("Ingrese monto a cargar "));
           tt.cargarTarjeta(total);
           JOptionPane.showMessageDialog(this, "Carga : "+  total +
                   "\n Total de dinero "+tt.getTotDinero());
        
           c=tt.getCantViajes();
           t=tt.getTotDinero();
           ta=new TarjetaB(codigo,t,c);
            tarD.modificarTarjeta(ta);
            JOptionPane.showMessageDialog(this, "Datos actualizados");
                   
       }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnViajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViajarActionPerformed
       String codigo=JOptionPane.showInputDialog("Ingrese codigo a buscar");
       TarjetaDAO tarD=new TarjetaDAO();
       TarjetaB tt=tarD.buscarTarjeta(codigo);
       int c,t;
       TarjetaB ta=null;
       
       if(tt==null)
           JOptionPane.showMessageDialog(this, "Codigo de tarjeta  no existe");
       else
       {
           int pasaje=Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor del pasaje  "));
           JOptionPane.showMessageDialog(this, "Valor pasaje  : "+  pasaje +
                   "\n "+tt.viajar(pasaje));
        
           c=tt.getCantViajes();
           t=tt.getTotDinero();
           ta=new TarjetaB(codigo,t,c);
            tarD.modificarTarjeta(ta);
            JOptionPane.showMessageDialog(this, "Datos actualizados");
                   
       }
    }//GEN-LAST:event_btnViajarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
       VentanaMostrar ven=new VentanaMostrar();
       ven.setVisible(true);
       ven.setLocationRelativeTo(null);
       ven.setTitle("MOSTRANDO DATOS TARJETAS");
       ven.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        VentanaIngresar ventIn=new VentanaIngresar();
       ventIn.setLocationRelativeTo(null);//centra la ventana en el medio de la pantalla
       ventIn.setTitle("CREACION TARJETA");
       ventIn.setResizable(false);//no permite que se agrande o se achique la ventana
       ventIn.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//que no cierren la ventana con la x
       ventIn.setVisible(true);//mue
    }//GEN-LAST:event_btnCrearActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnViajar;
    // End of variables declaration//GEN-END:variables
}
