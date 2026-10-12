package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.RegistroPassword;
import modelo.VaultDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis
 */
@WebServlet(name="ConsultaVaultServlet", urlPatterns = {"/ConsultaVaultServlet"})
public class ConsultaVaultServlet extends HttpServlet{
    
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         ArrayList<RegistroPassword> registros = new ArrayList<>();
         
         registros = VaultDAO.leer();
         System.out.println("soy consulta" + registros);
         request.setAttribute("registros", registros);
         response.sendRedirect("vaulHistorico.jsp");
    }
}
