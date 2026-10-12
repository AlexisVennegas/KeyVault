<%-- 
    Document   : index
    Created on : 09-oct-2026, 12:05:48
    Author     : Alexis
--%>
<%
    //Object  fecha =  session.getAttribute("tiempo");
    Cookie[] cookies = request.getCookies();
    //Session sesion = session.getId();
    String fecha = null;
    String nombre = null;
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("tiempo".equals(cookie.getName())) {
                fecha = cookie.getValue();
            }

            if ("nombre".equals(cookie.getName())) {
                nombre = cookie.getValue();
            }
        }
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/index.css" >
    </head>
    <body>
        <h1>Ingresar una contraseña registrada</h1>
        <p>Ultima contraseña analizada: <%= fecha%> Nombre:  <%= nombre%> Sesion:  </p>
        <div class="divFormulario">
            <form action="evaluaPassword"  method="post">
                <input  id="inputNombre" type="text" placeholder="Nombre" name="nombre" class="inputContraseña"/>
                <input  id="inputContrasena" type="text" placeholder="Contraseña" name="contrasena" class="inputContraseña"/> 
                <img src="https://cdn-icons-png.flaticon.com/128/159/159604.png" class="imagenForm">
                <p class="porcentajeProgreso"></p>
                <div class="containerProgreso"><div class="barraProgeso"> </div></div>
                <input type="submit" />
            </form>

            <input class="buttonGenerar" type="button" value="Generar Contraseña" />
            <form action="ConsultaVaultServlet"  method="post">
                <input type="submit" value="Mostrar Guardos"/>
            </form>
        </div>
        <script src="js/index.js" ></script>
    </body>

</html>
