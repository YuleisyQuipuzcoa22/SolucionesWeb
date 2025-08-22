package Logica;
import java.time.LocalDateTime;

public class Nota {

    private String titulo;
    private String contenido;
    private String categoria;
    private LocalDateTime fechaCreacion;

    public Nota() {
    }

    public Nota(String titulo, String contenido, String categoria) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.categoria = categoria;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
