package edu.pucmm.programacionweb2017.controladora;

import edu.pucmm.programacionweb2017.database.DB;
import edu.pucmm.programacionweb2017.entidad.Estudiante;
import edu.pucmm.programacionweb2017.service.DBService;
import edu.pucmm.programacionweb2017.util.Path;
import edu.pucmm.programacionweb2017.util.VistaUtil;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class EstudianteControladora {
    public static Route paginaNuevoEstudiante = (request, response) -> {
        Map<String, Object> map = new HashMap<>();

        return new VistaUtil().render(map, Path.Template.NUEVO_ESTUDIANTE);
    };

    public static Route postNuevoEstudiante = (request, response) -> {
        int matricula = Integer.parseInt(request.queryParams("matricula"));
        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");
        String telefono = request.queryParams("telefono");

        Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);

        DBService.getInstancia().insertar(estudiante);

        response.redirect(Path.Web.INICIO);
        return null;
    };

    public static Route borrarEstudiante = (request, response) -> {
        DB.listaEstudiantes.remove(DBService.getInstancia().encontrar(Integer.parseInt(request.params("matricula"))));

        response.redirect(Path.Web.INICIO);
        return null;
    };

    public static Route paginaEditarEstudiante = (request, response) -> {
        Map<String, Object> map = new HashMap<>();

        Estudiante estudiante = DBService.getInstancia().encontrar(Integer.valueOf(request.params("matricula")));

        map.put("estudiante", estudiante);

        return new VistaUtil().render(map, Path.Template.NUEVO_ESTUDIANTE);
    };

    public static Route editarEstudiante = (request, response) -> {
        Estudiante estudiante = DBService.getInstancia().encontrar(Integer.valueOf(request.params("matricula")));

        int matricula = Integer.parseInt(request.queryParams("matricula"));
        String nombre = request.queryParams("nombre");
        String apellido = request.queryParams("apellido");
        String telefono = request.queryParams("telefono");

        estudiante.setMatricula(matricula);
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setTelefono(telefono);

        DBService.getInstancia().editar(estudiante);

        response.redirect(Path.Web.INICIO);
        return null;
    };

    public static Route paginaVerEstudiante = (request, response) -> {
        Map<String, Object> map = new HashMap<>();

        Estudiante estudiante = DBService.getInstancia().encontrar(Integer.parseInt(request.params("matricula")));

        map.put("estudiante", estudiante);

        return new VistaUtil().render(map, Path.Template.VER_ESTUDIANTE);
    };
}
