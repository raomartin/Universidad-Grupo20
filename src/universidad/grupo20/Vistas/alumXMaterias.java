
package universidad.grupo20.Vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import universidad.grupo20.AccesoADatos.AlumnoData;
import universidad.grupo20.AccesoADatos.MateriaData;
import universidad.grupo20.Entidades.Alumno;
import universidad.grupo20.Entidades.Materia;


public class alumXMaterias extends javax.swing.JInternalFrame {
FondoPanel fon=new FondoPanel();

private List<Alumno> listaA;
private List<Materia> listaM;
private AlumnoData aData;
private MateriaData mData;
private DefaultTableModel modelo=new DefaultTableModel();

    
    public alumXMaterias() {
        this.setContentPane(fon);
        initComponents();
        
        mData = new MateriaData();
        listaM = mData.listarMaterias();
        armarCabeceraTabla();
        cargarMaterias();
        cargaAlum();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JCBMAT = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTALU = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Listado de Alumnos por materias");

        jLabel2.setText("Seleccione una materia");

        JTALU.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTALU);

        jButton1.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JCBMAT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JCBMAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Materia> JCBMAT;
    private javax.swing.JTable JTALU;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

class FondoPanel extends JPanel {

    private Image imagen;

    @Override
    public void paint(Graphics g) {
        imagen = new ImageIcon(getClass().getResource("/Imagenes/ulp.jpg")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}

private void cargarMaterias(){
    for (Materia item: listaM){
        JCBMAT.addItem(item);
    }
}

private void armarCabeceraTabla(){
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Id");
        filaCabecera.add("DNI");
        filaCabecera.add("Apellido");
        filaCabecera.add("Nombre");
        for (Object it: filaCabecera){
            modelo.addColumn(it);
        }
        JTALU.setModel(modelo);
    }
private void cargaAlum(){
    listaA = aData.listarAlumnos();
    for (Alumno a: listaA){
        modelo.addRow(new Object[]{a.getIdAlumno(), a.getDni(), a.getApellido(), a.getNombre()});
    }
}
}
