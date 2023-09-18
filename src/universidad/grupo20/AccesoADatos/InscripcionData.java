
package universidad.grupo20.AccesoADatos;

import com.sun.org.apache.xerces.internal.util.FeatureState;
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

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion(nota,idAlumno,idMateria)"
                + "VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();

            ResultSet res = ps.getGeneratedKeys();
            if (res.next()) {
                insc.setIdInscripcion(res.getInt(1));
                JOptionPane.showMessageDialog(null, "INSCRIPCION GUARDADA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INCRIPCION");
        }

    }

    public List<Inscripcion> listarInscripcion() {

        String sql = "SELECT idInscripcion,nota,idAlumno,idMateria FROM inscripcion ";

        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            AlumnoData alum = new AlumnoData();
            MateriaData mat = new MateriaData();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscrip = new Inscripcion();
                inscrip.setIdInscripcion(rs.getInt("idInscripcion"));

                inscrip.setNota(rs.getDouble("nota"));
                inscrip.setAlumno(alum.buscarAlumno(rs.getInt("idAlumno")));
                inscrip.setMateria(mat.buscarMateria(rs.getInt("idMateria")));

                inscripciones.add(inscrip);

            }
            JOptionPane.showMessageDialog(null, "INSCRIPCIONES LISTADAS");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA DE INSCRIPCION");
        }
        return inscripciones;
    }

     
    public List<Inscripcion> listarInscripcionPorAlumno(int id) {

        String sql = "SELECT idInscripcion,nota,idAlumno,idMateria FROM inscripcion ";

        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            AlumnoData alum = new AlumnoData();
            MateriaData mat = new MateriaData();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscrip = new Inscripcion();
                inscrip.setIdInscripcion(rs.getInt("idInscripcion"));

                inscrip.setNota(rs.getDouble("nota"));
                inscrip.setAlumno(alum.buscarAlumno(rs.getInt("idAlumno")));
                inscrip.setMateria(mat.buscarMateria(rs.getInt("idMateria")));

                if (id == inscrip.getAlumno().getIdAlumno()) {
                    inscripciones.add(inscrip);
                }

            }
            JOptionPane.showMessageDialog(null, "INSCRIPCIONES LISTADAS");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA DE INSCRIPCION");
        }
        return inscripciones;
    }

    //Este Metodo lo hicimos a nuestra manera
    public List<Materia> obtenerMateriasCursadas(int id) {

        String sql = "SELECT idInscripcion,nota,idAlumno,idMateria FROM inscripcion ";

        ArrayList<Materia> cursadas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            AlumnoData alum = new AlumnoData();
            MateriaData mat = new MateriaData();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscrip = new Inscripcion();
                inscrip.setIdInscripcion(rs.getInt("idInscripcion"));

                inscrip.setNota(rs.getDouble("nota"));
                inscrip.setAlumno(alum.buscarAlumno(rs.getInt("idAlumno")));
                inscrip.setMateria(mat.buscarMateria(rs.getInt("idMateria")));

                if (id == inscrip.getAlumno().getIdAlumno()) {
                    cursadas.add(inscrip.getMateria());
                }

            }
            JOptionPane.showMessageDialog(null, "MATERIAS LISTADAS");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA DE INCRIPCION");
        }
        return cursadas;
    }

    //Este metodo es como lo hizo el profe
    public List<Materia> listarMateriasCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();

        String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, materia"
                + "WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));
                
                materias.add(materia);
            }
            JOptionPane.showMessageDialog(null, "MATERIAS LISTADAS");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION. "+ex.getMessage());
        }
        return materias;

    }
    
    public List<Materia> listarMateriasNoCursadas(int idAlumno) {
        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado=1 AND idMateria NOT IN"
                + "(SELECT idMateria FROM inscripcion WHERE idAlumno=?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(rs.getBoolean("estado"));

                materias.add(materia);
            }
            JOptionPane.showMessageDialog(null, "MATERIAS LISTADAS");
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA MATERIA ");
        }
        return materias;

    }
    
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        String sql = "DELETE inscripcion WHERE idAlumno=? AND idMateria=?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Inscripcion borrada.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION. "+ex.getMessage());
        }
    }
    
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMAteria = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Nota actualizada.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA INSCRIPCION. "+ex.getMessage());
        }
        
    }
    
    
    public List<Alumno> listarAlumnosPorMateria(int idMateria){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT alumno.idAlumno, apellido, nombre, dni, fechaNac, estado FROM inscripcion, alumno"
                + "WHERE inscrpcion.idAlumno = alumno.idAlumno AND inscripcion.idMateria = ? AND alumno.estado = 1;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                
                alumnos.add(alumno);
            }
            JOptionPane.showMessageDialog(null, "ALUMNOS LISTADOS");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO. "+ex.getMessage());
        }
        return alumnos;
    }
    

}
