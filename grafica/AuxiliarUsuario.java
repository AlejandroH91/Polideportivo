/*
 * Para mostrar resultados de la categoría.
 */
package grafica;

import DAO.DAOPersona;
import com.mycompany.polideportivo_alejandro.Persona;
import java.util.List;

/**
 *
 * @author ahraz
 */
public class AuxiliarUsuario extends javax.swing.JFrame {

    private List<Persona> personas;

    /**
     * Creates new form AuxiliarUsuario
     */
    public AuxiliarUsuario(String categoria) {
        initComponents();
        cargarLista();
        mensajeEntrada.setText(categoria);
        String resultado = "";

        for (Persona p : personas) {
            if (p.getCategoria().toString().equals(mensajeEntrada.getText())) {
                String linea = p.getNombre() + "\t" + p.getApellido1() + "\t" + p.getApellido2() + "\n";
                resultado += linea;
            }
        }
        mostrarResultados.setText(resultado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Apellido = new javax.swing.JButton();
        Dni = new javax.swing.JButton();
        orden = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        gArchivo = new javax.swing.JLabel();
        mensajeEntrada = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarResultados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Apellido.setText("Apellido");

        Dni.setText("DNI");

        orden.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orden.setText("ORDENA POR");

        guardar.setText("GUARDAR");

        gArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gArchivo.setText("ARCHIVO");

        mensajeEntrada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mensajeEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mostrarResultados.setColumns(20);
        mostrarResultados.setRows(5);
        jScrollPane1.setViewportView(mostrarResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mensajeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Apellido)
                            .addComponent(Dni)
                            .addComponent(guardar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mensajeEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(orden, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Apellido)
                .addGap(18, 18, 18)
                .addComponent(Dni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gArchivo)
                .addGap(27, 27, 27)
                .addComponent(guardar)
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AuxiliarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuxiliarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuxiliarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuxiliarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    private void cargarLista() {
        DAOPersona cargar_info = new DAOPersona();
        personas = cargar_info.verInformacion();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apellido;
    private javax.swing.JButton Dni;
    private javax.swing.JLabel gArchivo;
    private javax.swing.JButton guardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mensajeEntrada;
    private javax.swing.JTextArea mostrarResultados;
    private javax.swing.JLabel orden;
    // End of variables declaration//GEN-END:variables
}
