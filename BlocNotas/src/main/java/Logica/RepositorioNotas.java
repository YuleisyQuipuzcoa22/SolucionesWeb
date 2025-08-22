package Logica;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class RepositorioNotas {

    private static class Holder {

        private static final RepositorioNotas INSTANCE = new RepositorioNotas();
    }

    public static RepositorioNotas getInstancia() {
        return Holder.INSTANCE;
    }

    private final ConcurrentMap<String, List<Nota>> store = new ConcurrentHashMap<>();

    private RepositorioNotas() {
    }

    public List<Nota> getNotas(String sessionId) {
        return store.computeIfAbsent(sessionId, id -> new CopyOnWriteArrayList<>());
    }

    public void agregarNota(String sessionId, Nota nota) {
        getNotas(sessionId).add(nota);
    }

}
