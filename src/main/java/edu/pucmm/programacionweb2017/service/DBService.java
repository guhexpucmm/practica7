package edu.pucmm.programacionweb2017.service;

import edu.pucmm.programacionweb2017.database.DB;
import edu.pucmm.programacionweb2017.entidad.Estudiante;

import java.util.Set;

public class DBService {

    private static DBService instancia;

    private DBService() {

    }

    public static DBService getInstancia() {
        if (instancia == null)
            instancia = new DBService();

        return instancia;
    }

    public void insertar(Estudiante estudiante) {
        DB.listaEstudiantes.add(estudiante);
    }

    public void editar(Estudiante estudiante) {
        for(Estudiante e : DB.listaEstudiantes) {
            if (e.equals(estudiante)) {
                e.setMatricula(estudiante.getMatricula());
                e.setNombre(estudiante.getNombre());
                e.setApellido(estudiante.getApellido());
                e.setTelefono(estudiante.getTelefono());
            }
        }
    }

    public void borrar(Estudiante estudiante) {
        DB.listaEstudiantes.remove(estudiante);
    }

    public Estudiante encontrar(int matricula) {
        for(Estudiante estudiante : DB.listaEstudiantes) {
            if (estudiante.getMatricula() == matricula) {
                return estudiante;
            }
        }

        return null;
    }

    public Set<Estudiante> encontrarTodos() {
        return DB.listaEstudiantes;
    }
}
