package edu.pucmm.programacionweb2017.util;

public class Path {
    public static class Web {
        public static final String INICIO = "/inicio";
        public static final String NUEVO_ESTUDIANTE = "/nuevo/estudiante";
        public static final String BORRAR_ESTUDIANTE = "/borrar/estudiante/:matricula";
        public static final String EDITAR_ESTUDIANTE = "/editar/estudiante/:matricula";
        public static final String VER_ESTUDIANTE = "/ver/estudiante/:matricula";
    }

    public static class Template {
        public static final String INICIO = "inicio.ftl";
        public static final String NUEVO_ESTUDIANTE = "nuevo.ftl";
        public static final String VER_ESTUDIANTE = "ver.ftl";
    }
}
