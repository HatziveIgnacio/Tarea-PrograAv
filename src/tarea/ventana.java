/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tarea;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alvar
 */
public class ventana extends javax.swing.JFrame {
    private static Map<String, Mesa> mesas = new HashMap<>();
    
    public static Map<String, Mesa> getMesas() {
        return mesas;
    }
        
    /**
     * Creates new form ventana
     */
    public ventana(){
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Casos = new javax.swing.JComboBox<>();
        Aceptar = new javax.swing.JButton();
        txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mostrar = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Casos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar Persona", "Buscar Region", "Eliminar Persona", "Lista Personas", "Salir" }));
        Casos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CasosActionPerformed(evt);
            }
        });

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });

        Mostrar.setColumns(20);
        Mostrar.setRows(5);
        jScrollPane1.setViewportView(Mostrar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Casos, 0, 371, Short.MAX_VALUE)
                                .addComponent(txt))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Casos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CasosActionPerformed
        // TODO add your handling code here:
        int eleccion = Casos.getSelectedIndex();
        switch(eleccion){
            case 0:                
                Mostrar.setText("Ingrese el Rut\n");
                String rut = txt.getText();
                // Buscar la mesa de votación para el RUT dado
                String[] mesaYRegion = RegistroElectoral.buscarMesaPorRut(rut);
                if (mesaYRegion != null) {
                    Mostrar.setText("Usted debe votar en la mesa: " + mesaYRegion[0] + ", en la " + mesaYRegion[1]);
                } else {
                    Mostrar.setText("Ingrese un rut de esta manera (12345678-k),(si ya lo ingreso es porque no existe)\n");
                }
                break;
            case 1:      
                //llama a funcion buscar x region
                //Mostrar.setText("\nIngrese el nombre de la región: (Ejemplo de entada: Región de Valparaíso)\n"); // SE DEBE INGRESAR DE ESTA FORNA: Región de Valparaíso
                String region = txt.getText();
                String resultadoBusqueda = RegistroElectoral.buscarPersonasPorRegion(region);
                Mostrar.setText(resultadoBusqueda);
                break;
            case 2:
                //llama a funcion eliminar persona
                Mostrar.setText("Ingrese el RUT de la persona a eliminar (sin puntos y con guion):\n");
                String rutEliminar = txt.getText();
                boolean personaEliminada = false;
                Map<String, Mesa> mesas = RegistroElectoral.getMesas();
                for (Mesa mesa : mesas.values()) {
                    Persona persona = mesa.getPersona(rutEliminar);
                    if (persona != null) {
                        mesa.removePersona(rutEliminar);
                        personaEliminada = true;
                        break; // Persona encontrada y eliminada, salir del bucle
                    }
                }
                if (personaEliminada) {
                    Mostrar.setText("La persona con RUT " + rutEliminar + " fue eliminada correctamente.");
                } else {
                    Mostrar.setText("ingrese un rut que se encuentre de esta manera (12345678-k)");
                }
                break;
            case 3:
                //llama a funcion mostrar lista
                Mostrar.setText("Ingrese el código de la mesa:");
                String codigoMesa = txt.getText();
                Mesa mesaSeleccionada = RegistroElectoral.getMesas().get(codigoMesa);
                if (mesaSeleccionada != null) {
                    //Mostrar.setText("Lista de personas en la mesa " + codigoMesa + ":");
                    StringBuilder texto = new StringBuilder();
                    texto.append("Lista de personas en la mesa ").append(codigoMesa).append(":\n");
                    Collection<Persona> personas = mesaSeleccionada.getPersonas();
                    if (!personas.isEmpty()) {
                        for (Persona persona : personas){
                            Mostrar.append("\nNombre: " + persona.getNombre() + ", RUT: " + persona.getRut());
                        }
                    } else {
                        Mostrar.append("No hay personas registradas en la mesa " + codigoMesa + ".");
                    }
                } else {
                    Mostrar.setText("Ingrese un codigo que exista de esta manera (A-123)");
                }
                break;
            case 4:
                //salir
                dispose();
                break;
        }
    }//GEN-LAST:event_CasosActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        // TODO add your handling code here:
        CasosActionPerformed(evt);
    }//GEN-LAST:event_AceptarActionPerformed

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
        // TODO add your handling code here:
        CasosActionPerformed(evt);
    }//GEN-LAST:event_txtActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JComboBox<String> Casos;
    private javax.swing.JTextArea Mostrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}