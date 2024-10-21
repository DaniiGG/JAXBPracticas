package org.example;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UsoCurso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elige una opción:");
        System.out.println("1: Marshal (guardar a XML)");
        System.out.println("2: Unmarshal (cargar desde XML)");
        int option = scanner.nextInt();

        try {
            if (option == 1) {

                //aqui daba error de constructor vacío, pero al ponerle parámetros ya funciona correctamente

                // Crear estudiantes
                Estudiante estudiante1 = new Estudiante("Juan", 20);
                Estudiante estudiante2 = new Estudiante("María", 22);

                //cuando pongo un dato de otro tipo que no se pida en la clase me salta un error de tipos incompatibles

                // Crear un curso con estudiantes
                Curso curso = new Curso("Programación en Java", Arrays.asList(estudiante1, estudiante2));

                //igual ocurre aquí, ya que se debe insertar un String, y un objeto estudiante correctamente

                // Crear el contexto JAXB y el marshaller
                JAXBContext context = JAXBContext.newInstance(Curso.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                // Serializar el objeto Curso a XML
                marshaller.marshal(curso, System.out);

                // Guardar en un archivo XML
                marshaller.marshal(curso, new File("curso.xml"));
                System.out.println("\nCurso guardado en 'curso.xml'.");

            } else if (option == 2) {
                // Crear el contexto JAXB y el unmarshaller
                JAXBContext context = JAXBContext.newInstance(Curso.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                // Deserializar desde un archivo XML
                Curso curso = (Curso) unmarshaller.unmarshal(new File("curso.xml"));

                // Imprimir el curso deserializado
                System.out.println("Curso deserializado:");
                System.out.println("Nombre del curso: " + curso.getNombreCurso());
                System.out.println("Estudiantes:");
                for (Estudiante estudiante : curso.getEstudiantes()) {
                    System.out.println(" - " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
                }

            } else {
                System.out.println("Opción no válida. Elija 1 o 2.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
