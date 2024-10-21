package org.example;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante {

// Un error ha sido poner la etiqueta @XmlElement en la asignación de variables
// ya que ponia que se duplicaba la variable, lo he arreglado poniendo la etiqueta
// en los getters

    private String nombre;
    private int edad;

    // Constructor vacío
    public Estudiante() {}

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Anotaciones sobre los métodos getter
    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @XmlElement
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}



