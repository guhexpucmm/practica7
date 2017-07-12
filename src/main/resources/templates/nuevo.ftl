<!doctype html>
<html>
<head>
<#include "head.ftl">
    <title>CRUD Estudiante</title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">CRUD Estudiante</a>
        </div>
    </div>
</nav>

<#if estudiante??>

<div id="contenido" class="container">
    <div class="row">
        <div class="col col-lg-6 col-lg-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2>Registro de estudiante</h2>
                </div>
                <div class="panel-body">
                    <form action="/editar/estudiante/${estudiante.getMatriculaString()}" method="POST" class="form-signin" id="formulario-usuario">
                        <br>
                        <div>
                            <label for="matricula">Matricula:</label>
                            <input name="matricula" type="text" id="matricula" class="form-control" value="${estudiante.getMatriculaString()}" placeholder="Digite su matricula" minlength="8" required autofocus>
                        </div>

                        <br>
                        <div>
                            <label for="nombre">Nombre:</label>
                            <input name="nombre" type="text" id="nombre" class="form-control" value="${estudiante.getNombre()}" placeholder="Digite su nombre" minlength="4" required autofocus>
                        </div>

                        <br>
                        <div>
                            <label for="apellido">Apellido:</label>
                            <input  name="apellido" type="text" id="apellido" class="form-control" value="${estudiante.getApellido()}" placeholder="Digite su apellido"  required>
                        </div>

                        <br>
                        <div>
                            <label for="telefono">Telefono:</label>
                            <input  name="telefono" type="text" id="telefono" class="form-control" value="${estudiante.getTelefono()}" placeholder="(___)___-____"  required>
                        </div>

                        <br>
                        <div>
                            <button class="btn btn-success" type="submit">Actualizar</button>
                            <button class="btn btn-danger" onclick="location.href='/'">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<#else>

<div id="contenido" class="container">
    <div class="row">
        <div class="col col-lg-6 col-lg-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2>Registro de estudiante</h2>
                </div>
                <div class="panel-body">
                    <form action="/nuevo/estudiante" method="POST" class="form-signin" id="formulario-usuario">
                        <br>
                        <div>
                            <label for="matricula">Matricula:</label>
                            <input name="matricula" type="text" id="matricula" class="form-control" placeholder="Digite su matricula" minlength="8" required autofocus>
                        </div>

                        <br>
                        <div>
                            <label for="nombre">Nombre:</label>
                            <input name="nombre" type="text" id="nombre" class="form-control" placeholder="Digite su nombre" minlength="4" required autofocus>
                        </div>

                        <br>
                        <div>
                            <label for="apellido">Apellido:</label>
                            <input  name="apellido" type="text" id="apellido" class="form-control" placeholder="Digite su apellido"  required>
                        </div>

                        <br>
                        <div>
                            <label for="telefono">Telefono:</label>
                            <input  name="telefono" type="text" id="telefono" class="form-control" placeholder="(___)___-____"  required>
                        </div>

                        <br>
                        <div>
                            <button class="btn btn-success" type="submit">Agregar</button>
                            <button class="btn btn-danger" onclick="location.href='/'">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</#if>
</body>
<script>
    $("#formulario-usuario").validate({
        errorClass: "my-error-class"
    });

    jQuery.extend(jQuery.validator.messages, {
        required: "Por favor este campo no puede estar vacio."
    });
</script>
</html>