<%@page import="java.util.List"%>
<%@page import="Logica.Nota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css">
        <title>Notas Berlin</title>
    </head>
    <body>

        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-light px-3" 
             style="background-color: #563d7c;">
            <a class="navbar-brand d-flex align-items-center" href="#">
                <!-- luego reemplazamos el texto por tu logo SVG -->
                <img src="resources/textito.svg" alt="Logo" width="40" height="40" class="me-2">
            </a>
            <div class="ms-auto">
                <!-- Botoncito que abre el modal -->
                <button class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#modalNota">
                    <i class="bi bi-plus-circle me-1"></i> Nueva Nota
                </button>

            </div>
        </nav>

        <div class="container mt-4">
            <h2 class="mb-3">Notas Berlin</h2>

            <%
                List<Nota> listaNotas = (List) request.getSession().getAttribute("listaNotas");
                if (listaNotas != null && !listaNotas.isEmpty()) {
            %>
            <div class="row g-3">
                <%
                    int cont = 1;
                    for (Nota note : listaNotas) {
                %>
                <div class="col-12 col-sm-6 col-md-4 col-lg-3">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
                            <p><b>Nota n° <%=cont%></b></p>
                            <h5 class="card-title"><%= note.getTitulo()%></h5>
                            <p class="card-text"><%= note.getContenido()%></p>
                        </div>
                    </div>
                </div>
                <% cont++;
                    }%>
            </div>
            <%
            } else {
            %>
            <div class="alert alert-warning">No hay notas guardadas</div>
            <% }%>
        </div>

        <!-- Modal con formulario -->
        <div class="modal fade" id="modalNota" tabindex="-1" aria-labelledby="modalNotaLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="svNotas" method="POST">
                        <div class="modal-header">
                            <h5 class="modal-title" id="modalNotaLabel">Nueva Nota</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                                <label class="form-label">Título</label>
                                <input type="text" class="form-control" name="titulo" required maxlength="50">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Contenido</label>
                                <textarea class="form-control" rows="3" name="contenido" required maxlength="255"></textarea>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Tipo de Nota</label>
                                <select class="form-select" name="tipo">
                                    <option value="normal">NORMAL</option>
                                    <option value="importante">IMPORTANTE</option>
                                    <option value="recordatorio">RECORDATORIO</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-primary">Guardar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS (para modal) -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
