
package universidad.grupo20.Vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import universidad.grupo20.AccesoADatos.AlumnoData;
import universidad.grupo20.AccesoADatos.InscripcionData;
import universidad.grupo20.AccesoADatos.MateriaData;
import universidad.grupo20.Entidades.Alumno;
import universidad.grupo20.Entidades.Materia;





public class CargaNotas extends javax.swing.JInternalFrame {
    
    private List<Alumno> listaA;
    private List<Materia> listaM;
    private AlumnoData aData;
    private MateriaData mData;
    private InscripcionData actuN;
    
    private DefaultTableModel modelo=new DefaultTableModel(){
        
        public boolean isCellEditable(int fila, int columna){
           if (columna==2){
               return true;
           }
            return false; 
        }
    }


    public CargaNotas() {
        initComponents();
        
        aData= new AlumnoData();
        listaA = aData.listarAlumnos();
//        modelo = new DefaultTableModel();
        mData = new MateriaData();
        
        
        cargarAlumno();
        armarCabeceraTabla();
        cargaNota();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbcAlu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMat = new javax.swing.JTable();
        JBGuardar = new javax.swing.JButton();
        JBSALIR = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Carga de notas");

        jLabel2.setText("Seleccione un alumno");

        jbcAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbcAluActionPerformed(evt);
            }
        });

        jtMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jtMat);

        JBGuardar.setText("Guardar");
        JBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGuardarActionPerformed(evt);
            }
        });

        JBSALIR.setText("Salir");
        JBSALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSALIRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jbcAlu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(JBGuardar)
                        .addGap(76, 76, 76)
                        .addComponent(JBSALIR, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jbcAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGuardar)
                    .addComponent(JBSALIR))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbcAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbcAluActionPerformed

        
    }//GEN-LAST:event_jbcAluActionPerformed

    private void JBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGuardarActionPerformed
        Alumno alusel = (Alumno) jbcAlu.getSelectedItem();
        int filsel = (int) jtMat.getSelectedRow();
        int idm = (int) modelo.getValueAt(filsel, 0);
        int nota = (int) modelo.getValueAt(filsel, 2);
        actuN.actualizarNota(alusel.getIdAlumno(),idm, nota);
        
    }//GEN-LAST:event_JBGuardarActionPerformed

    private void JBSALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSALIRActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_JBSALIRActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBGuardar;
    private javax.swing.JButton JBSALIR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Alumno> jbcAlu;
    private javax.swing.JTable jtMat;
    // End of variables declaration//GEN-END:variables
    private void cargarAlumno() {
        for (Alumno item: listaA){
            jbcAlu.addItem(item);
        }
    }
    
    private void armarCabeceraTabla(){
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Codigo");
        filaCabecera.add("Nombre");
        filaCabecera.add("Nota");
        for (Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jtMat.setModel(modelo);
    }
    
    private void cargaNota(){
//        Alumno aluSel = (Alumno) jbcAlu.getSelectedItem();
        listaM = mData.listarMaterias();
        for (Materia m: listaM){
            modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre(), 0});
        }
        
    }
}

