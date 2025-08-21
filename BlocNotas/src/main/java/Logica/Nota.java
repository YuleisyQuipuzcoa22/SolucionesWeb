package Logica;

public class Nota {

    private String titulo;
    private String contenido;
    private String categoria;

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
}
