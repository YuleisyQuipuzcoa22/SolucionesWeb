package com.mycompany.blocnotas.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Logica.Nota;
import Logica.RepositorioNotas;

@WebServlet(name = "svNotas", urlPatterns = {"/svNotas"}) //Necesarios para el index
public class svNotas extends HttpServlet {

    // --- GET: mostrar la lista ---
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession misesion = request.getSession();
        String sessionId = misesion.getId();

        RepositorioNotas repo = RepositorioNotas.getInstancia();
        List<Nota> listaNotas = repo.getNotas(sessionId);

        request.setAttribute("listaNotas", listaNotas);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // --- POST ---
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        String categoria = request.getParameter("categoria");

        if (titulo == null || titulo.trim().isEmpty()
                || contenido == null || contenido.trim().isEmpty()) {
            response.sendRedirect("svNotas"); // redirige a GET
            return;
        }

        Nota nuevaNota = Logica.NotaFactory.crearNota(titulo, contenido, categoria);

        HttpSession misesion = request.getSession();
        String sessionId = misesion.getId();
        RepositorioNotas repo = RepositorioNotas.getInstancia();
        repo.agregarNota(sessionId, nuevaNota);

        response.sendRedirect("svNotas");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
