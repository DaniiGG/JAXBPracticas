package org.example;

import java.io.File;
import jakarta.xml.bind.JAXBException;

public class Unmarshal {

    public static void main(String[] args) {
        // El archivo XML que vamos a deserializar
        File file = new File("estudiante.xml");

        try {
            // Usar JAXBUtil para deserializar el archivo XML a un objeto Estudiante
            Estudiante estudiante = JAXBUtil.unmarshal(file);

            // Imprimir los valores del objeto Estudiante deserializado
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Edad: " + estudiante.getEdad());
        } catch (JAXBException e) {
            e.printStackTrace();  // Manejar la excepción si ocurre un error durante la deserialización
        }
    }
}
