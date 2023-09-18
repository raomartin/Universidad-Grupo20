package universidad.grupo20;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidad.grupo20.AccesoADatos.AlumnoData;
import universidad.grupo20.AccesoADatos.Conexion;
import universidad.grupo20.AccesoADatos.InscripcionData;
import universidad.grupo20.AccesoADatos.MateriaData;
import universidad.grupo20.Entidades.Alumno;
import universidad.grupo20.Entidades.Inscripcion;
import universidad.grupo20.Entidades.Materia;

public class UniversidadGrupo20 {

    public static void main(String[] args) {
        // TODO code application logic here

//        Connection con = Conexion.getConexion();

//Creamos los alumnos
        AlumnoData alu = new AlumnoData();
//        Alumno Juan = new Alumno(42273781, "Rodríguez", "Juan", LocalDate.of(1998, 4, 25), true);
//        Alumno Pedro = new Alumno(387626909, "Perez", "Pedro", LocalDate.of(1996, 7, 10), true);
//        Alumno Esteban = new Alumno(298426909, "Quito", "Esteban", LocalDate.of(1998, 10, 1), true);
//        Alumno Monica = new Alumno(407626909, "Galindo", "Monica", LocalDate.of(2000, 3, 19), true);
//        Alumno Armando = new Alumno(44626909, "Paredes", "Armando", LocalDate.of(1999, 8, 5), true);
        
//Modificamos un alumno
//        Alumno Armando = new Alumno(1, 44626909, "Paredes", "Armando", LocalDate.of(1999, 8, 5), false);
//        alu.modificarAlumno(Armando);
        
//Guardamos los alumnos
//        alu.guardarAlumno(Armando);
//        alu.guardarAlumno(Juan);
//        alu.guardarAlumno(Pedro);
//        alu.guardarAlumno(Esteban);
//        alu.guardarAlumno(Monica);

//Buscamos un alumno por ID
//        Alumno alumnoEncontrado = alu.buscarAlumno(2);
//        System.out.println("ID " + alumnoEncontrado.getIdAlumno());
//        System.out.println("Apellido " + alumnoEncontrado.getApellido());
//        System.out.println("Nombre " + alumnoEncontrado.getNombre());
//        System.out.println("DNI " + alumnoEncontrado.getDni());
//        System.out.println("Fecha nacimineto " + alumnoEncontrado.getFechaNac());
//        System.out.println("Estado " + alumnoEncontrado.isEstado());

//Buscamos un alumno por dni
//        Alumno buscadoporDni = alu.buscarAlumnoPorDni(298426909);
//        System.out.println("Alumno encontado por DNI " + buscadoporDni.getDni());
//        System.out.println("ID" + buscadoporDni.getIdAlumno());
//        System.out.println("Apellido " + buscadoporDni.getApellido());
//        System.out.println("Nombre " + buscadoporDni.getNombre());
//        System.out.println("Fecha de nacimiento" + buscadoporDni.getFechaNac());
//        System.out.println("Estado " + buscadoporDni.isEstado());
        
//Borramos un alumno
//        alu.borrarAlumno(3);
        
//Listamos los alumnos
//        for (Alumno alumno : alu.listarAlumnos()) {
//            System.out.println("ID " + alumno.getIdAlumno() + "Nombre " + alumno.getNombre() + "Apellido" + alumno.getApellido());
//        }
        
//Creamos Materias
        MateriaData mat = new MateriaData();
//        Materia matematicas = new Materia("Matematicas", 4, true);
//        Materia lengua = new Materia("Lengua", 2, true);
//        Materia geografia = new Materia("Geografia", 3, false);
//Guardamos las materias
//        mat.guardarMateria(matematicas);
//        mat.guardarMateria(lengua);
//        mat.guardarMateria(geografia);
        
//Buscamos materias
//        System.out.println(mat.buscarMateria(1));
//        System.out.println(mat.buscarMateria(2));
//        System.out.println(mat.buscarMateria(3));
//        System.out.println("------------");
//Listamos las materias
//        for (Materia materia : mat.listarMaterias()) {
//            System.out.println(materia);
//        }

//Creamos las inscripciones
//        Inscripcion inscrip1 = new Inscripcion(0, alu.buscarAlumno(1), mat.buscarMateria(1));
//        Inscripcion inscrip2 = new Inscripcion(0, alu.buscarAlumno(2), mat.buscarMateria(1));
//        Inscripcion inscrip3 = new Inscripcion(0, alu.buscarAlumno(5), mat.buscarMateria(2));
//        Inscripcion inscrip4 = new Inscripcion(0, alu.buscarAlumno(4), mat.buscarMateria(2));
//        Inscripcion inscrip5 = new Inscripcion(0, alu.buscarAlumno(1), mat.buscarMateria(2));
//Guardamos las inscripciones
        InscripcionData insc = new InscripcionData();
//        insc.guardarInscripcion(inscrip1);
//        insc.guardarInscripcion(inscrip2);
//        insc.guardarInscripcion(inscrip3);
//        insc.guardarInscripcion(inscrip4);
//        insc.guardarInscripcion(inscrip5);

//Listamos todas las inscripciones
        for (Inscripcion i : insc.listarInscripcion()) {
            System.out.println(i);
            System.out.println("------------");
        }
        System.out.println("------------");

//Listamos las inscripciones por alumno
        System.out.println("Las inscripciones del alumno "
                + alu.buscarAlumno(1).getNombre() + " son:");
        for (Inscripcion i : insc.listarInscripcionPorAlumno(1)) {
            System.out.println(i);
        }
        System.out.println("------------");

//Listamos las materias cursadas por alumnos con nuestro metodo
        System.out.println("Las materias cursadas por el alumno "
                + alu.buscarAlumno(1).getNombre() + " son:");
        for (Materia m : insc.obtenerMateriasCursadas(1)) {
            System.out.println(m);
        }
        System.out.println("---------------");

//Listamos las materias cursadas por alumnos con metodo del profe
        System.out.println("Las materias cursadas por el alumno "
                + alu.buscarAlumno(1).getNombre() + " son:");
        for (Materia m : insc.listarMateriasCursadas(1)) {
            System.out.println(m);
        }
        System.out.println("---------------");

//Litamos las materias NO cursadas por alumno
        System.out.println("Las materias NO cursadas por el alumno "
                + alu.buscarAlumno(2).getNombre() + " son:");
        for (Materia m : insc.listarMateriasNoCursadas(2)) {
            System.out.println(m);
        }
        System.out.println("---------------");

//Borramos inscripcion Materia Alumno
        insc.borrarInscripcionMateriaAlumno(2, 1);

//Actualizamos nota
        insc.actualizarNota(1, 1, 8);

//Listamos los alumnos por materia
        System.out.println("Los alumnos que cursan "
                + mat.buscarMateria(2).getNombre() + " son:");
        for (Alumno a : insc.listarAlumnosPorMateria(2)) {
            System.out.println(a);
        }
        System.out.println("---------------");

        
        
    }
}




