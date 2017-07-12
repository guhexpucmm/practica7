<!doctype html>
<html>
<head>
<#include "head.ftl">
    <title>CRUD Estudiante</title
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">CRUD Estudiante</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <div class="navbar-form navbar-left">
                <button type="button" class="btn btn-default" onclick="location.href='/nuevo/estudiante'">Agregar estudiante</button>
            </div>
        </div>
    </div>
</nav>

<div class="panel panel-default">
    <div class="panel-heading">Estudiantes registrados</div>

    <table class="table">
        <tr>
            <th>Matricula</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Telefono</th>
            <th>Accion</th>
        </tr>
        <tbody>
        <#list estudiantes as estudiante>
        <tr>
            <td>${estudiante.getMatriculaString()}</td>
            <td>${estudiante.getNombre()}</td>
            <td>${estudiante.getApellido()}</td>
            <td>${estudiante.getTelefono()}</td>
            <td>
                <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default" onclick="location.href='/ver/estudiante/${estudiante.getMatriculaString()}'">Visualizar</button>
                    <button type="button" class="btn btn-default" onclick="location.href='/editar/estudiante/${estudiante.getMatriculaString()}'">Editar</button>
                    <button type="button" class="btn btn-default" onclick="location.href='/borrar/estudiante/${estudiante.getMatriculaString()}'">Borrar</button>
                </div>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>