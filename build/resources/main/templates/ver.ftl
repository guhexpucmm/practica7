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

<div id="contenido" class="container">
    <div class="row">
        <div class="col col-lg-6 col-lg-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2>Registro de estudiante</h2>
                </div>
                <div class="panel-body">
                    <form action="/" method="GET" class="form-signin" id="formulario-usuario">
                        <br>
                        <div>
                            <label for="matricula"><strong>Matricula:</strong> ${estudiante.getMatriculaString()}</label>
                        </div>

                        <br>
                        <div>
                            <label for="nombre"><strong>Nombre:</strong> ${estudiante.getNombre()}</label>
                        </div>

                        <br>
                        <div>
                            <label for="apellido"><strong>Apellido:</strong> ${estudiante.getApellido()}</label>
                        </div>

                        <br>
                        <div>
                            <label for="telefono"><strong>Telefono:</strong> ${estudiante.getTelefono()}</label>
                        </div>

                        <br>
                        <div>
                            <button class="btn btn-success" type="submit">Volver</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
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