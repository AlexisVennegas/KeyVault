/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.Extension;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import modelo.RegistroPassword;
import modelo.VaultDAO;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author Alexis
 */

@WebServlet(name="GuardaVaultServlet", urlPatterns = {"/GuardaVaultServlet"})
public class GuardaVaultServlet extends HttpServlet {
    
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      
        HttpSession sesion = request.getSession();

        RegistroPassword datos = (RegistroPassword) sesion.getAttribute("datos");
    
        VaultDAO.guardar(datos);
        response.sendRedirect("index.jsp");
 }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      
        HttpSession sesion = request.getSession();

        RegistroPassword datos = (RegistroPassword) sesion.getAttribute("datos");
    
        VaultDAO.guardar(datos);
        response.sendRedirect("index.jsp");
 }
}
 