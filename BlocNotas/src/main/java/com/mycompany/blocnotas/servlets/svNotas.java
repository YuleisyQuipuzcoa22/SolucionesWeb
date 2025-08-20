
package com.mycompany.blocnotas.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Logica.Nota;

@WebServlet(name = "svNotas", urlPatterns = {"/svNotas"})
public class svNotas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession misesion = request.getSession();
        List<Nota> listaNotas = (List<Nota>) misesion.getAttribute("listaNotas");
        if (listaNotas == null) {
            listaNotas = new ArrayList<>();
            misesion.setAttribute("listaNotas", listaNotas);
        }
               
       //redirigir a la JSP
        
        response.sendRedirect("index.jsp");

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
 
        
        Nota nuevaNota = new Nota(titulo, contenido);
        
        HttpSession misesion = request.getSession();
        List<Nota> listaNotas = (List<Nota>) misesion.getAttribute("listaNotas");
        if (listaNotas == null) {
            listaNotas = new ArrayList<>();         
        }
        listaNotas.add(nuevaNota);
        misesion.setAttribute("listaNotas", listaNotas);
        response.sendRedirect("index.jsp");
        


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
