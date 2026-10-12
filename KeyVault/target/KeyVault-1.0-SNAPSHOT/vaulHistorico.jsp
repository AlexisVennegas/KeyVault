<%-- 
    Document   : vaulHistorico
    Created on : 12-oct-2026, 21:45:30
    Author     : Alexis
--%>
<%@ page import="modelo.RegistroPassword" %>
<%@ page import="java.util.ArrayList" %>
<%

    ArrayList<RegistroPassword> registros = (ArrayList<RegistroPassword>) request.getAttribute("registros");

    System.out.println(registros);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina para Mostrar las contraseñas</h1>
        <div class="formResultados" >
            <table border="2">
                <tr>
                    <th>Nombre Usuario</th>
                    <th>Nivel de fortaleza en %</th>
                    <th>Fecha</th>
                    <th>Clave</th>
                </tr>

                <% for (RegistroPassword registro : registros) {%>
                <tr>
                    <td><%= registro.getNombre()%></td>
                    <td><%= registro.getNivelfortaleza()%></td>
                    <td><%= registro.getFecha()%></td>
                    <td><%= registro.getClave()%></td>
                </tr>
                <% }%>
            </table>


            <form  action="index.jsp" method="get" >
                <input type="submit" value="Volver" />
            </form>
        </div>
    </body>
</html>
