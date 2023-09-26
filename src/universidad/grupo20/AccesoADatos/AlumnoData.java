package universidad.grupo20.AccesoADatos;

//FABRIZZIO
import java.sql.Connection;
import java.sql.Date;
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

public class AlumnoData {

    private Connection cone = null;

    //CONSTRUCTOR(INICIALIZAR LA VARIABLE CONE)
    public AlumnoData() {
        cone = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) {

        /*UTILIZAMOS EL METODO INSERT E INICIALIZAMOS LOS CAMPOS(DNI,APELLIDO ETC) CON CARACTERES COMODINES(?),
            PARA REMPLAZARLOS LUEGO*/
        String sql = "INSERT INTO alumno(dni,apellido,nombre,fechaNac,estado)"
                + "VALUES (?,?,?,?,?)";
        try {
            //GENERAMOS OBJETO Y PEDIMOS QUE NOS RETORNE LAS ID GENERADAS AUTOMATICAMENTE(sql,Statement.return_generated_keys)
            PreparedStatement a1 = cone.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //REMPLAZAMOS LOS COMODINES(?)
            //UTILIZAMOS VALUEOF(),PARA PODER CONVERTIR A DATE UN LOCALDATE
            a1.setInt(1, alumno.getDni());
            a1.setString(2, alumno.getApellido());
            a1.setString(3, alumno.getNombre());
            a1.setDate(4, Date.valueOf(alumno.getFechaNac()));
            a1.setBoolean(5, alumno.isEstado());
            a1.executeUpdate();

            //PEDIMOS LA CLAVE GENERADA AUTOMATICAMENTE(ID ALUMNO)
            //res.next(),PREGUNTA SI HAY OTRA FILA O APUNTA A LA SIGUIENTE FILA
            ResultSet res = a1.getGeneratedKeys();
            if (res.next()) {
                alumno.setIdAlumno(res.getInt(1));
                JOptionPane.showMessageDialog(null, "ALUMNO GUARDADO");
            }
            a1.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO. " + ex.getMessage());
        }
    }

    public Alumno buscarAlumno(int id) {


        String sql = "SELECT dni,apellido,nombre,fechaNac,estado FROM alumno WHERE idAlumno=? AND estado = 1;";


        //variable Alumno
        Alumno alumno = null;
        try {
            PreparedStatement ps = cone.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                //USAMOS TOLOCALDATE PARA CONVERTIR UN LOCALDATE A DATE
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));


            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE EL ALUMNO");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO. " + ex.getMessage());
        }
        return alumno;
    }

    public Alumno buscarAlumnoPorDni(int dni) {


        String sql = "SELECT idAlumno,apellido,nombre,fechaNac,estado FROM alumno WHERE dni=? AND estado = 1;";

        Alumno alumno = null;
        try {
            PreparedStatement ps = cone.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(dni);
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE ESE ALUMNO");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO. " + ex.getMessage());
        }
        return alumno;
    }

    public List<Alumno> listarAlumnos() {

        String sql = "SELECT idAlumno,dni,apellido,nombre,fechaNac FROM alumno WHERE estado=1";
        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement ps = cone.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                alumno.setEstado(true);

                alumnos.add(alumno);
            }
           // JOptionPane.showMessageDialog(null, "ALUMNOS LISTADOS");
            ps.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA ALUMNO. " + ex.getMessage());
        }
        return alumnos;
    }

    public void modificarAlumno(Alumno alumno) {

        //INGRESAMOS CODIGO PARA MODIFICAR UN DATO (UPDATE)
        String sql = "UPDATE alumno SET dni=?,apellido=?,nombre=?,fechaNac=?,estado=? WHERE idAlumno=?";

        try {
            //CAMBIAMOS COMODINES(?)
            PreparedStatement ps = cone.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());

            // PREGUNTAMOS SI LOGRO EL ENVIO DE DATOS
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "ALUMNO MODIFICADO");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCER A LA TABLA ALUMNOS. " + ex.getMessage());
        }
    }

    public void borrarAlumno(int id) {

        //CREAMOS CODIGO PARA MODIFICAR EL "ESTADO" DE UN ALUMNO(TAMBIEN SE PUEDE ELIMINAR DE LA BASE)
        //PERO LO QUE PIDE ES UN BORRADO LOGICO Y NO FISICO
        String sql = "UPDATE alumno SET estado=0 WHERE idAlumno=?";

        try {
            PreparedStatement ps = cone.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "ALUMNO DADO DE BAJA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL DAR DE BAJA AL ALUMNO. " + ex.getMessage());
        }
    }

}
