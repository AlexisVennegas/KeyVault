package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import javax.servlet.http.Cookie;
import modelo.EvaluadorPassword;
import modelo.RegistroPassword;

/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis
 */
@WebServlet(name = "evaluaPassword", urlPatterns = {"/evaluaPassword"})
public class EvaluaPasswordServlet extends HttpServlet {

    protected void extrerParametro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // obtenemos la sesion
        HttpSession sesion = request.getSession();
        LocalDate fecha = LocalDate.now();
        ArrayList<String> datos = null;

        // PRIMER EXTRAEMOS LA CONTRASEÑA DEL FORM 
        String contrasena = request.getParameter("contrasena");
        String nombre = request.getParameter("nombre");
     

        // LLAMAMOS AL METODO PARA OBTENER LOS DATOS 
        datos = EvaluadorPassword.EvaluadorPassword(contrasena, nombre);
        RegistroPassword datosP = new RegistroPassword(contrasena, datos.get(0), "" +  fecha, nombre);
        
        // AÑADIMOS A LA SESSION y cookie
        sesion.setAttribute("datos", datosP);
      
        
        // Cookie con el nombre
        Cookie cookie = new Cookie("tiempo", fecha.toString());
        Cookie cookieNombre = new Cookie("nombre", nombre);
        Cookie cookiePassword = new Cookie("contrasena", contrasena);
        cookieNombre.setMaxAge(24 * 60 * 60);
        cookie.setMaxAge(24 * 60 * 60); // 24 horas
          
        response.addCookie(cookieNombre);
        response.addCookie(cookiePassword);
        response.addCookie(cookie);
        
        
        // LO AÑADIMOS AL REQUEST LA CONTRASEÑA Y LOS DATOS
        request.setAttribute("contraseña", contrasena);
        request.setAttribute("datos", datos);
        request.setAttribute("nombre", datos);
        request.getRequestDispatcher("/resultadoAnalisis.jsp").forward(request, response);
        //response.sendRedirect("resu.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        extrerParametro(request, response);
    }
}
