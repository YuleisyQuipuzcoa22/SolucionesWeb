
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
import Logica.RepositorioNotas;

@WebServlet(name = "svNotas", urlPatterns = {"/svNotas"})
public class svNotas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession misesion = request.getSession();
        String sessionId = misesion.getId();
        
        
        
        RepositorioNotas repo = RepositorioNotas.getInstancia();
        List<Nota> listaNotas = repo.getNotas(sessionId);
        
        misesion.setAttribute("listaNotas", listaNotas);
        response.sendRedirect("index.jsp");

    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        String tipo = request.getParameter("tipo");
        
        if (titulo == null || titulo.trim().isEmpty() ||
        contenido == null || contenido.trim().isEmpty()) {
        
        request.getSession().setAttribute("error", "⚠️ El título y contenido no pueden estar vacíos.");
        response.sendRedirect("index.jsp");
        return; 
    }
        Nota nuevaNota = Logica.NotaFactory.crearNota(tipo, titulo, contenido);
        
        HttpSession misesion = request.getSession();
        String sessionId = misesion.getId(); //identificador unico del usuario
        RepositorioNotas repo = RepositorioNotas.getInstancia();
        repo.agregarNota(sessionId, nuevaNota);
        
        
        
        
        //Se guarda en la sesion para que el JSP lea la lista
        misesion.setAttribute("listaNotas", repo.getNotas(sessionId));
        response.sendRedirect("index.jsp");
        


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
