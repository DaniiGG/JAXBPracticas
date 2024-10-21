package org.example;

import java.io.File;
import jakarta.xml.bind.JAXBException;

public class Marshal {

    public static void main(String[] args) {
        // Crear una instancia de Estudiante
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Juan");
        estudiante.setEdad(25);

        // Crear un archivo para guardar el XML
        File file = new File("estudiante.xml");

        try {
            // Usar JAXBUtil para convertir el objeto Estudiante a XML y guardarlo en el archivo
            JAXBUtil.marshal(estudiante, file);
        } catch (JAXBException e) {
            e.printStackTrace();  // Manejar cualquier excepción de JAXB
        }
    }
}
