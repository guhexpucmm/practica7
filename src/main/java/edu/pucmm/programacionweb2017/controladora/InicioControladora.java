package edu.pucmm.programacionweb2017.controladora;

import edu.pucmm.programacionweb2017.service.DBService;
import edu.pucmm.programacionweb2017.util.Path;
import edu.pucmm.programacionweb2017.util.VistaUtil;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class InicioControladora {
    public static Route paginaInicio = (request, response) -> {
        Map<String, Object> map = new HashMap<>();

        map.put("estudiantes", DBService.getInstancia().encontrarTodos());

        return new VistaUtil().render(map, Path.Template.INICIO);
    };
}
