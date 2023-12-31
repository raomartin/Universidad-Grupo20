/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.grupo20.Vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.objects.NativeString.substring;
import universidad.grupo20.AccesoADatos.AlumnoData;
import universidad.grupo20.AccesoADatos.InscripcionData;
import universidad.grupo20.AccesoADatos.MateriaData;
import universidad.grupo20.Entidades.Alumno;
import universidad.grupo20.Entidades.Inscripcion;
import universidad.grupo20.Entidades.Materia;

/**
 *
 * @author negan
 */
public class inscripciones extends javax.swing.JInternalFrame {
AlumnoData alu=new AlumnoData();
InscripcionData ins=new InscripcionData();
MateriaData mate=new MateriaData();
//creamos un tipo de fondo panel
FondoPanel2 fon=new FondoPanel2();
String elegido;
int pos;
//creamos el tabla model
private DefaultTableModel model=new DefaultTableModel();
//codigo para que las celdas no sean editables
 public boolean isCellEditable(int i,int e){
    return false;
}


    /**
     * Creates new form inscripciones
     */
    public inscripciones() {
        //llamamos los metodos para cargar el combobox y armar la tabla
        this.setContentPane(fon);
        initComponents();
        armar();
        rellenarCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JLayeredPane();
        botoninscripto = new javax.swing.JRadioButton();
        BotonNoIns = new javax.swing.JRadioButton();
        BotonInscribir = new javax.swing.JButton();
        BotonAnular = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTabla = new javax.swing.JTable();
        Jcombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        botoninscripto.setText("Materias Inscriptas");
        botoninscripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoninscriptoActionPerformed(evt);
            }
        });

        BotonNoIns.setText("Materias No Inscriptas");
        BotonNoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNoInsActionPerformed(evt);
            }
        });

        BotonInscribir.setText("Inscribir");
        BotonInscribir.setEnabled(false);
        BotonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInscribirActionPerformed(evt);
            }
        });

        BotonAnular.setText("Anular inscripcion");
        BotonAnular.setEnabled(false);
        BotonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnularActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        JTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(JTabla);

        Jcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcomboActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione un alumno");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Listado de Materias");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Formulario de Inscripcion");

        fondo.setLayer(botoninscripto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(BotonNoIns, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(BotonInscribir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(BotonAnular, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(jBSalir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(Jcombo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fondo.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(BotonInscribir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonAnular)
                        .addGap(50, 50, 50)
                        .addComponent(jBSalir)
                        .addGap(67, 67, 67))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Jcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(botoninscripto)
                                .addGap(47, 47, 47)
                                .addComponent(BotonNoIns)))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botoninscripto)
                    .addComponent(BotonNoIns))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir)
                    .addComponent(BotonAnular)
                    .addComponent(BotonInscribir))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcomboActionPerformed
        //borramos todo lo que tiene la tabla
        borrar();
        //convertimos lo que se selecciono en el combobox en string
        elegido = String.valueOf(Jcombo.getSelectedItem());
        //obtenemos el largo del string
        int total=elegido.length();
        //recorre todo la cadena hasta encontrar la ','
        for (int i = 0; i <elegido.length(); i++) {
            if(elegido.charAt(i)==','){
                pos=i;
                //guardamos en una variable la ubicacion de la ','
                i=total;
                
            }
       //desactivamos los botones de inscripto y no 
       BotonNoIns.setSelected(false);
       botoninscripto.setSelected(false);
       
        
        }
    }//GEN-LAST:event_JcomboActionPerformed

    private void BotonNoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNoInsActionPerformed
//borramos todo lo que tiene la tabla
borrar();
//usamos el substring para obtener la id ,comienza en 0 ytermina en la posicion de la coma
for(Materia mat:ins.listarMateriasNoCursadas(Integer.parseInt((elegido.substring(0,pos))))){
    model.addRow(new Object[]{mat.getIdMateria(),mat.getNombre(),mat.getAnio()});
}
//desactiva el boton seleccionado
    botoninscripto.setSelected(false);
//activa y desactiva los botones inscribir y anular inscripcion
    BotonInscribir.setEnabled(true);
    BotonAnular.setEnabled(false);
       
    }//GEN-LAST:event_BotonNoInsActionPerformed

    private void BotonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnularActionPerformed
       //borramos todo lo de la tabla
        borrar();
        for (Materia mat:ins.listarMateriasCursadas(Integer.parseInt(elegido.substring(0,pos)))){
            //obtenemos la id de la materia
            int idmat = mat.getIdMateria();
            //le pasamos la id del alumno y de la materia
            ins.borrarInscripcionMateriaAlumno(  Integer.parseInt((elegido.substring(0, pos))),idmat);
        
        }
        //desactivamos el boton inscripto y el no
        botoninscripto.setSelected(false);
        BotonNoIns.setSelected(false);

        
    }//GEN-LAST:event_BotonAnularActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
     //codigo para cerrar una internal frame
        this.dispose();
        
    }//GEN-LAST:event_jBSalirActionPerformed

    private void botoninscriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoninscriptoActionPerformed
        //borramos todo lo que tiene la tabla
        borrar();
        
        for(Materia mat:ins.listarMateriasCursadas(Integer.parseInt(elegido.substring(0,pos)))){
            //carga los datos en la tabla
              model.addRow(new Object[]{mat.getIdMateria(), mat.getNombre(),mat.getAnio()});
        }
       //desactivamos el boton no inscripto
       BotonNoIns.setSelected(false);
       BotonInscribir.setEnabled(false);
       BotonAnular.setEnabled(true);
    }//GEN-LAST:event_botoninscriptoActionPerformed

    private void BotonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInscribirActionPerformed
    //borramos todo lo que tiene la tabla
borrar();
for(Materia mat:ins.listarMateriasNoCursadas(Integer.parseInt((elegido.substring(0,pos))))){
   //obtenemos la id de materia
    int idmat=mat.getIdMateria();
    //creamos una variable de tipo Inscripcion,buscamos el alumno y la materia
    Inscripcion inscri=new Inscripcion(0,alu.buscarAlumno(Integer.parseInt((elegido.substring(0,pos)))),mate.buscarMateria(idmat));
    //guardamos la inscripcion guardada con los datos del combobox y las materias no cursadas
    ins.guardarInscripcion(inscri);
}   
//descactivamos el boton inscripto y no inscripto
botoninscripto.setSelected(false);
BotonNoIns.setSelected(false);
      
    }//GEN-LAST:event_BotonInscribirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAnular;
    private javax.swing.JButton BotonInscribir;
    private javax.swing.JRadioButton BotonNoIns;
    private javax.swing.JTable JTabla;
    private javax.swing.JComboBox<String> Jcombo;
    private javax.swing.JRadioButton botoninscripto;
    private javax.swing.JLayeredPane fondo;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables


//metodo para armar la tabla
    private void armar(){
    model.addColumn("ID");
    model.addColumn("NOMBRE");
    model.addColumn("AÑO");
    JTabla.setModel(model);
    
}

//metodo para borrar los datos de la tabla
private void borrar(){
    int filas=JTabla.getRowCount()-1;
    for(int f=filas;f>=0;f--){
        model.removeRow(f);
    }
}

//metodo para poder cargar el fondo
class FondoPanel2 extends JPanel {

    private Image imagen;

    @Override
    public void paint(Graphics g) {
        imagen = new ImageIcon(getClass().getResource("/Imagenes/ulp.jpg")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}

//metodo para rellenar el combo con alumnos
public void rellenarCombo(){
for (Alumno alumno : alu.listarAlumnos()) {
           Jcombo.addItem(alumno.getIdAlumno()+","+alumno.getDni()+","+ alumno.getNombre()+ "," + alumno.getApellido());
           
}

}



    
    
    
    
}





