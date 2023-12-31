package universidad.grupo20.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidad.grupo20.Entidades.Alumno;
import universidad.grupo20.Entidades.Materia;

public class MateriaData {

    private Connection cone = null;

    //CONSTRUCTOR(INICIALIZAR LA VARIABLE CONE)
    public MateriaData() {
        cone = Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {

        /*UTILIZAMOS EL METODO INSERT E INICIALIZAMOS LOS CAMPOS(NOMBRE,ESTADO Y ANIO) CON CARACTERES COMODINES(?),
            PARA REMPLAZARLOS LUEGO*/
        String sql = "INSERT INTO materia(Nombre,año,estado)"
                + "VALUES (?,?,?)";

        try {
            //GENERAMOS OBJETO Y PEDIMOS QUE NOS RETORNE LAS ID GENERADAS AUTOMATICAMENTE(sql,Statement.return_generated_keys)
            PreparedStatement ps = cone.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //REMPLAZAMOS LOS COMODINES(?)
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();

            //PEDIMOS LA CLAVE GENERADA AUTOMATICAMENTE(ID MATERIA)
            //res.next(),PREGUNTA SI HAY OTRA FILA O APUNTA A LA SIGUIENTE FILA
            ResultSet res = ps.getGeneratedKeys();
            if (res.next()) {
                materia.setIdMateria(res.getInt(1));
                JOptionPane.showMessageDialog(null, "MATERIA GUARDADA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA MATERIA. " + ex.getMessage());
        }
    }

    public Materia buscarMateria(int id) {

        String sql = "SELECT nombre, año FROM materia WHERE idMateria=? AND estado=1";

        //Variable Materia
        Materia materia = null;
        try {
            PreparedStatement ps = cone.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE LA MATERIA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA MATERIA. " + ex.getMessage());
        }
        return materia;
    }

    public List<Materia> listarMaterias() {

        String sql = "SELECT idMateria,nombre,año FROM materia ";
        ArrayList<Materia> materias = new ArrayList<>();

        try {
            PreparedStatement ps = cone.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("año"));
                materia.setEstado(true);

                materias.add(materia);
            }
            JOptionPane.showMessageDialog(null, "MATERIAS LISTADAS");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA MATERIA. " + ex.getMessage());
        }
        return materias;
    }

    public void modificarMateria(Materia materia) {

        //INGRESAMOS CODIGO PARA MODIFICAR UN DATO (UPDATE)
        String sql = "UPDATE materia SET nombre=?,año=?,estado=? WHERE idMateria=?";

        try {
            //CAMBIAMOS COMODINES(?)
            PreparedStatement ps = cone.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());

            // PREGUNTAMOS SI LOGRO EL ENVIO DE DATOS
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "MATERIA MODIFICADA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA MATERIA. " + ex.getMessage());
        }
    }

    public void borrarMateria(int id) {

        //CREAMOS CODIGO PARA MODIFICAR EL "ESTADO" DE UNA MATERIA (TAMBIEN SE PUEDE ELIMINAR DE LA BASE)
        //PERO LO QUE PIDE ES UN BORRADO LOGICO Y NO FISICO
        String sql = "UPDATE materia SET estado=0 WHERE idMateria=?";

        try {
            PreparedStatement ps = cone.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "MATERIA DADA DE BAJA");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL DAR DE BAJA LA MATERIA. " + ex.getMessage());
        }
    }

}
