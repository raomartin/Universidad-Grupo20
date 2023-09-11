
package universidad.grupo20;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import universidad.grupo20.AccesoADatos.AlumnoData;
import universidad.grupo20.AccesoADatos.Conexion;
import universidad.grupo20.Entidades.Alumno;

public class UniversidadGrupo20 {

    public static void main(String[] args) {
        // TODO code application logic here

        Connection con = Conexion.getConexion();
        AlumnoData alu = new AlumnoData();
//        Alumno Juan = new Alumno(42273781, "Rodríguez", "Juan", LocalDate.of(1998, 4, 25), true);
//        Alumno Pedro = new Alumno(387626909, "Perez", "Pedro", LocalDate.of(1996, 7, 10), true);
//        Alumno Esteban = new Alumno(298426909, "Quito", "Esteban", LocalDate.of(1998, 10, 1), true);
//        Alumno Monica = new Alumno(407626909, "Galindo", "Monica", LocalDate.of(2000, 3, 19), true);
//        Alumno Armando = new Alumno(44626909, "Paredes", "Armando", LocalDate.of(1999, 8, 5), true);
//
//            Alumno Armando = new Alumno(1, 44626909,"Paredes", "Armando", LocalDate.of(1999, 8, 5), false);
//               alu.modificarAlumno(Armando);
//        alu.guardarAlumno(Armando);
//        alu.guardarAlumno(Juan);
//        alu.guardarAlumno(Pedro);
//        alu.guardarAlumno(Esteban);
//        alu.guardarAlumno(Monica);
//        
//            Alumno alumnoEncontrado=alu.buscarAlumno(2);
//            System.out.println("ID "+alumnoEncontrado.getIdAlumno());
//            System.out.println("Apellido "+alumnoEncontrado.getApellido());
//            System.out.println("Nombre "+alumnoEncontrado.getNombre()); 
//            System.out.println("DNI "+alumnoEncontrado.getDni());
//            System.out.println("Fecha nacimineto "+alumnoEncontrado.getFechaNac());
//            System.out.println("Estado "+alumnoEncontrado.isEstado());
            

//
//            Alumno buscadoporDni=alu.buscarAlumnoPorDni(298426909);
//            System.out.println("Alumno encontado por DNI "+buscadoporDni.getDni());
//            System.out.println("ID"+buscadoporDni.getIdAlumno());
//            System.out.println("Apellido "+buscadoporDni.getApellido());
//            System.out.println("Nombre "+buscadoporDni.getNombre());
//            System.out.println("Fecha de nacimiento"+buscadoporDni.getFechaNac() );
//            System.out.println("Estado "+buscadoporDni.isEstado());

                
              
//            alu.borrarAlumno(3);
           
           for(Alumno alumno:alu.listarAlumnos()){
               System.out.println("ID "+alumno.getIdAlumno()+ "Nombre "+alumno.getNombre()+ "Apellido"+alumno.getApellido());
                       
    }
    }
}
