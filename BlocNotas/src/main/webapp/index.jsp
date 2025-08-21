
<%@page import="java.util.List"%>
<%@page import="Logica.Nota"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
        <title>Formulario de prueba</title>
    </head>
    <body>

        <h1>Ingresa tu notita</h1>
        <form action="svNotas" method="POST">
            <div class="mb-3">
                <label class="form-label" >Título</label>
                <input type="text" class="form-control" name = "titulo">
            </div >
            <div class="mb-3"> 
                <label class="form-label">Contenido</label> 
                <textarea  class="form-control" rows="3" name = "contenido"></textarea>
            </div
            
            <div class="mb-3">
                <label class="form-label">TIPO DE NOTA</label>
                <select ckass ="form-select" name="tipo">
                    <option value="normal">NORMAL</option>
                    <option value="importante">IMPORTANTE</option>
                    <option value="recordatorio">RECORDATORIO</option>
                </select>
            </div>
            
            <button type= "submit" class="btn btn-primary"> Enviar</button>
        
        </form>    

        <h1>Lista de notas</h1>

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
                        <p><b>Nota n° <%=cont%></b> </p>
                        <h5  class="card-title"> <%= note.getTitulo()%></h5>
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
        <%            }
        %> 
        
        <%
            String errorMsg = (String) session.getAttribute("error");
            if(errorMsg != null){
        %>
        
            <div class ="alert alert-danger"><%= errorMsg%></div>
        <%
            session.removeAttribute("Error");
            }
        %>
    </body>
</html>
