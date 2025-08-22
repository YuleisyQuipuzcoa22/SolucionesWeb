package Logica;

import java.time.LocalDateTime;

public class NotaFactory {

    public static Nota crearNota(String titulo, String contenido, String categoria) {
        Nota nota = new Nota(titulo, contenido, categoria);
        nota.setFechaCreacion(LocalDateTime.now()); // fecha automática
        return nota;
    }
}
