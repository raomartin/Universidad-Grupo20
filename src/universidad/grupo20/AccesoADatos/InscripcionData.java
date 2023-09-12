
package universidad.grupo20.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidad.grupo20.Entidades.Alumno;
import universidad.grupo20.Entidades.Inscripcion;
import universidad.grupo20.Entidades.Materia;


public class InscripcionData {
    private Connection con = null;
    private MateriaData matDat = null;
    private AlumnoData alumDat = null;
    
    public InscripcionData(){
        con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion insc){
        String sql = "INSERT INTO inscripcion(nota,idAlumno,idMateria)"
                + "VALUES (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            
            
            ResultSet res= ps.getGeneratedKeys();
            if (res.next()) {
                insc.setIdInscripcion(res.getInt(1));
                JOptionPane.showMessageDialog(null, "INSCRIPCION GUARDADA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INCRIPCION");
        }
        
    }
    public List<Inscripcion> listarInscripcion(){
        
        String sql="SELECT idInscripcion,nota,idAlumno,idMateria FROM inscripcion ";
                
        ArrayList<Inscripcion> inscripciones=new ArrayList<>();
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            AlumnoData alum = new AlumnoData();
            MateriaData mat = new MateriaData();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscrip=new Inscripcion();
                inscrip.setIdInscripcion(rs.getInt("idInscripcion"));


                inscrip.setNota(rs.getDouble("nota"));
                inscrip.setAlumno(alum.buscarAlumno(rs.getInt("idAlumno")));
                inscrip.setMateria(mat.buscarMateria(rs.getInt("idMateria")));
                
                
                inscripciones.add(inscrip);
            
            }
            ps.close();
      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR AL ACCEDER A LA TABLA DE INSCRIPCION");
        }
        return inscripciones;
    }
    
    
    public List<Inscripcion> listarInscripcionPorAlumno(int id){
        
        String sql="SELECT idInscripcion,nota,idAlumno,idMateria FROM inscripcion ";
                
        ArrayList<Inscripcion> inscripciones=new ArrayList<>();
        
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            AlumnoData alum=new AlumnoData();
            MateriaData mat=new MateriaData();
           
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Inscripcion inscrip=new Inscripcion();
                inscrip.setIdInscripcion(rs.getInt("idInscripcion"));


                inscrip.setNota(rs.getDouble("nota"));
                inscrip.setAlumno(alum.buscarAlumno(rs.getInt("idAlumno")));
                inscrip.setMateria(mat.buscarMateria(rs.getInt("idMateria")));
                
                if (id == inscrip.getAlumno().getIdAlumno()){
                inscripciones.add(inscrip);
                }
            
            }
            ps.close();
      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR AL ACCEDER A LA TABLA DE INSCRIPCION");
        }
        return inscripciones;
    }
    
    public List<Materia> obtenerMateriasCursadas(int id){
        
        String sql="SELECT idInscripcion,nota,idAlumno,idMateria FROM inscripcion ";
                
        ArrayList<Materia> cursadas=new ArrayList<>();
        
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            AlumnoData alum=new AlumnoData();
            MateriaData mat=new MateriaData();
           
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Inscripcion inscrip=new Inscripcion();
                inscrip.setIdInscripcion(rs.getInt("idInscripcion"));


                inscrip.setNota(rs.getDouble("nota"));
                inscrip.setAlumno(alum.buscarAlumno(rs.getInt("idAlumno")));
                inscrip.setMateria(mat.buscarMateria(rs.getInt("idMateria")));
                
                if (id == inscrip.getAlumno().getIdAlumno()){
                cursadas.add(inscrip.getMateria());
                }
            
            }
            ps.close();
      
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR AL ACCEDER A LA TABLA DE INCRIPCION");
        }
        return cursadas;
    }
    
    
}
