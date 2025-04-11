import java.util.Objects;

public class Paciente implements Comparable<Paciente> {

    private static long contador = 0;
    private final String nombre;
    private final String sintoma;
    private final char prioridad;
    private final long timestamp; // Para mantener el orden de llegada

    public Paciente(String nombre, String sintoma, char prioridad) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.prioridad = prioridad;
        this.timestamp = System.nanoTime(); // Registra el momento de creación
    }

    // Getters...

    @Override
    public int compareTo(Paciente otro) {
        // Primero comparamos por prioridad
        int cmp = Character.compare(this.prioridad, otro.prioridad);
        if (cmp != 0) {
            return cmp;
        }
        // Si tienen la misma prioridad, comparamos por timestamp (orden de llegada)
        return Long.compare(this.timestamp, otro.timestamp);
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + prioridad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Paciente paciente = (Paciente) o;
        return prioridad == paciente.prioridad &&
                timestamp == paciente.timestamp &&
                nombre.equals(paciente.nombre) &&
                sintoma.equals(paciente.sintoma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, sintoma, prioridad, timestamp);
    }
}