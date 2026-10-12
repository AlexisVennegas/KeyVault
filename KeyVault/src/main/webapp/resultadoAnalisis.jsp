<%-- 
    Document   : resultadoAnalisis
    Created on : 12-oct-2026, 14:54:32
    Author     : Alexis
--%>
<%@ page import="java.util.ArrayList" %>
<%

    ArrayList<String> datos = null;
    datos = (ArrayList<String>) request.getAttribute("datos");
       Cookie[] cookies = request.getCookies();

    String nombre= null;
     if (cookies != null) {
        for (Cookie cookie : cookies) {
         
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
         <link rel="stylesheet" href="css/resultados.css" >
    </head>
    <body>
        <h1>Bienvenido a los resultados analisis</h1>
        <div class="formResultados" >
            <table border="2">
                <tr>
                     <th>Nombre Usuario</th> 
                    <th>nivel de fortaleza en %</th> 
                    <th> tiempo
                        estimado de rotura</th> 
                    <th>recomendaciones</th> 

                </tr>
                <tr>
                    <td><%= nombre %></td>
                    <td><%= datos.get(0)%></td>
                    <td><%= datos.get(1)%></td>
                    <td>ni idea </td>
                </tr>


            </table>
            <div class="progreso" />
            <form  action="GuardaVaultServlet" method="post" >
                <input type="submit" value="guardar" />
            </form>
            <form  action="index.jsp" method="get" >
                <input type="submit" value="Volver" />
            </form>
        </div>




    </body>
</html>
