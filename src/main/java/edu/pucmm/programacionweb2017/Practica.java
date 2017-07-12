package edu.pucmm.programacionweb2017;

import edu.pucmm.programacionweb2017.controladora.EstudianteControladora;
import edu.pucmm.programacionweb2017.controladora.InicioControladora;
import edu.pucmm.programacionweb2017.database.DB;
import edu.pucmm.programacionweb2017.entidad.Estudiante;
import edu.pucmm.programacionweb2017.util.Path;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class Practica {

    public Practica() {
        enableDebugScreen();
        setConfiguraciones();
        setHeroku();
        setRedireccion();
        setRutas();
        setEstudiantes();
    }

    private void setConfiguraciones() {
        staticFileLocation("/public/");
    }

    private void setHeroku() {
        port(getHerokuPort());
    }

    private int getHerokuPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();

        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567;
    }

    private void setRedireccion() {
        get("/", (request, response) -> {
            response.redirect(Path.Web.INICIO);
            return null;
        });

        get("", (request, response) -> {
            response.redirect(Path.Web.INICIO);
            return null;
        });
    }

    private void setRutas() {
        get(Path.Web.INICIO, InicioControladora.paginaInicio);
        get(Path.Web.NUEVO_ESTUDIANTE, EstudianteControladora.paginaNuevoEstudiante);
        post(Path.Web.NUEVO_ESTUDIANTE, EstudianteControladora.postNuevoEstudiante);
        get(Path.Web.BORRAR_ESTUDIANTE, EstudianteControladora.borrarEstudiante);
        get(Path.Web.EDITAR_ESTUDIANTE, EstudianteControladora.paginaEditarEstudiante);
        post(Path.Web.EDITAR_ESTUDIANTE, EstudianteControladora.editarEstudiante);
        get(Path.Web.VER_ESTUDIANTE, EstudianteControladora.paginaVerEstudiante);
    }

    private void setEstudiantes() {
        Estudiante estudiante = new Estudiante(20100001, "Gustavo", "Henriquez", "8095801962");
        Estudiante estudiante2 = new Estudiante(20019029, "Camacho", "Perez", "8294353482");

        DB.listaEstudiantes.add(estudiante);
        DB.listaEstudiantes.add(estudiante2);
    }
}
