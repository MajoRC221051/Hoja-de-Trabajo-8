import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VectorHeapTest {

    @Test
    public void testOrdenAtencionPrioridad() {
        VectorHeap<Paciente> cola = new VectorHeap<>();

        // Insertamos en orden aleatorio
        cola.add(new Paciente("P3", "S3", 'C'));
        cola.add(new Paciente("P1", "S1", 'A'));
        cola.add(new Paciente("P5", "S5", 'E'));
        cola.add(new Paciente("P2", "S2", 'B'));
        cola.add(new Paciente("P4", "S4", 'D'));

        // Verificamos el orden de salida
        assertEquals("P1, S1, A", cola.remove().toString());
        assertEquals("P2, S2, B", cola.remove().toString());
        assertEquals("P3, S3, C", cola.remove().toString());
        assertEquals("P4, S4, D", cola.remove().toString());
        assertEquals("P5, S5, E", cola.remove().toString());
    }

    @Test
    public void testPrioridadesMezcladas() {
        VectorHeap<Paciente> cola = new VectorHeap<>();

        // Insertamos con prioridades mezcladas
        cola.add(new Paciente("P1", "S1", 'B'));
        cola.add(new Paciente("P2", "S2", 'A'));
        cola.add(new Paciente("P3", "S3", 'B'));
        cola.add(new Paciente("P4", "S4", 'C'));
        cola.add(new Paciente("P5", "S5", 'A'));
        cola.add(new Paciente("P6", "S6", 'B'));

        // Verificamos el orden correcto
        assertEquals("P2, S2, A", cola.remove().toString()); // Primera A
        assertEquals("P5, S5, A", cola.remove().toString()); // Segunda A
        assertEquals("P1, S1, B", cola.remove().toString()); // Primera B
        assertEquals("P3, S3, B", cola.remove().toString()); // Segunda B
        assertEquals("P6, S6, B", cola.remove().toString()); // Tercera B
        assertEquals("P4, S4, C", cola.remove().toString()); // Única C
    }

    @Test
    public void testMismaPrioridadOrdenLlegada() throws InterruptedException {
        VectorHeap<Paciente> cola = new VectorHeap<>();

        // Insertamos varios con misma prioridad
        Paciente p1 = new Paciente("Primero", "S1", 'B');
        Thread.sleep(10); // Pequeña pausa para asegurar timestamp diferente
        Paciente p2 = new Paciente("Segundo", "S2", 'B');
        Thread.sleep(10);
        Paciente p3 = new Paciente("Tercero", "S3", 'B');

        cola.add(p1);
        cola.add(p2);
        cola.add(p3);

        // Deben salir en orden de llegada
        assertEquals(p1.toString(), cola.remove().toString());
        assertEquals(p2.toString(), cola.remove().toString());
        assertEquals(p3.toString(), cola.remove().toString());
    }
}