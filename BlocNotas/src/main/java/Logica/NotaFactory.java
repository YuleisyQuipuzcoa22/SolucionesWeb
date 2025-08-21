package Logica;

public class NotaFactory {
    public static Nota crearNota(String categoria, String titulo, String contenido) {
        return new Nota(titulo, contenido, categoria.toLowerCase());
    }
}
