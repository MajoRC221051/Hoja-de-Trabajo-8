import java.io.BufferedReader;
import java.io.FileReader;

public class Hospital {

    public static void main(String[] args) {
        VectorHeap<Paciente> cola = new VectorHeap<>();
        cargarPacientes(cola);

        System.out.println("Atendiendo pacientes con VectorHeap:");
        while (!cola.isEmpty()) {
            System.out.println(cola.remove());
        }
    }

    public static void cargarPacientes(VectorHeap<Paciente> cola) {
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String nombre = datos[0].trim();
                    String sintoma = datos[1].trim();
                    char prioridad = datos[2].trim().charAt(0);
                    Paciente paciente = new Paciente(nombre, sintoma, prioridad);
                    cola.add(paciente);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}