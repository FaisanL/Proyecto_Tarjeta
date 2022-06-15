
package vista;

import controlador.TarjetaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.TarjetaB;


public class VentanaMostrar extends javax.swing.JFrame {

    
    public VentanaMostrar() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMostrar = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Ingrese Codigo: ");

        btnBuscar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(51, 51, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Total dinero", "Cantidad de viajes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMostrar);

        btnEliminar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 51, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(51, 51, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(51, 51, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(29, 29, 29)
                        .addComponent(btnModificar)
                        .addGap(42, 42, 42)
                        .addComponent(btnVolver)
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void limpiarTabla()
    {
       DefaultTableModel dtm=(DefaultTableModel)tblMostrar.getModel();
       int n=tblMostrar.getRowCount()-1;
       for (int i = 0; i <=n; i++) {
           dtm.removeRow(dtm.getRowCount()-1);
       }
   }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        limpiarTabla();
        TarjetaDAO ttd=new TarjetaDAO();
        TarjetaB t=ttd.buscarTarjeta(txtRut.getText());

        if(t==null)//No existe
        {
            ArrayList <TarjetaB> t1=ttd.obtenerTodo();
            if(t1.size()==0)
            JOptionPane.showMessageDialog(this, "No hay tarjetas en la tabla");
            else
            {
                DefaultTableModel dtm=(DefaultTableModel)tblMostrar.getModel();
                String [][] datos=new String[t1.size()][3];
                for (int i = 0; i < t1.size(); i++) {
                    datos[i][0]=t1.get(i).getCodigo();
                    datos[i][1]=String.valueOf(t1.get(i).getTotDinero());
                    datos[i][2]=String.valueOf(t1.get(i).getCantViajes());
                    dtm.addRow(datos[i]);
                }
                tblMostrar.setModel(dtm);
            }
        }
        else //Existe
        {

            DefaultTableModel dtm=(DefaultTableModel)tblMostrar.getModel();
            String [] datos=new String[3];
            datos[0]=t.getCodigo();
            datos[1]=String.valueOf(t.getTotDinero());
            datos[2]=String.valueOf(t.getCantViajes());
            
            dtm.addRow(datos);
            tblMostrar.setModel(dtm);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel dtm=(DefaultTableModel)tblMostrar.getModel();
        int fila=tblMostrar.getSelectedRow();
        if(fila==-1)
        JOptionPane.showMessageDialog(this, "Debe seleccionar la tarjeta");
        else
        {
            String codigo=String.valueOf(tblMostrar.getValueAt(fila, 0));
            TarjetaDAO aluDAO=new TarjetaDAO();
            aluDAO.eliminarTarjeta(codigo);
            JOptionPane.showMessageDialog(this,"Tarjeta eliminada");
            dtm.removeRow(fila);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        DefaultTableModel dtm=(DefaultTableModel)tblMostrar.getModel();
        int fila=tblMostrar.getSelectedRow();
        if(fila==-1)
        JOptionPane.showMessageDialog(this, "Debe seleccionar la tarjeta ");
        else
        {
            String codigo=String.valueOf(tblMostrar.getValueAt(fila, 0));
           
            int  n1=Integer.parseInt(String.valueOf(tblMostrar.getValueAt(fila, 1)));
            
            int n2=Integer.parseInt(String.valueOf(tblMostrar.getValueAt(fila, 2)));
            
            TarjetaB tar=new TarjetaB(codigo, n1, n2);
            TarjetaDAO tt=new TarjetaDAO();
            tt.modificarTarjeta(tar);
            JOptionPane.showMessageDialog(this, "Datos modificados en la tarjeta");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMostrar;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables
}
