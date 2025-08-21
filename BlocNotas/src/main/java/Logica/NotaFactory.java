
package Logica;


public class NotaFactory {
    public static Nota crearNota (String tipo, String titulo, String contenido){
        switch (tipo.toLowerCase()) {
            case "importante":
                return new Nota("⚠️ " + titulo, contenido);
            case "recordatorio":
                return new Nota("⏰ " + titulo, contenido);
            default:
                return new Nota(titulo, contenido);
        }
    }
}
