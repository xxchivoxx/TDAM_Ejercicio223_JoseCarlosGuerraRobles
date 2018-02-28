package com.example.carlos.tdam_ejercicio223_josecarlosguerrarobles;

/**
 * Created by carlos on 27/02/18.
 */

public class Persona {
    String nombre="";
    String NumControl ="";
    String carrera = "";

    public Persona(String nombre, String numControl, String carrera) {
        this.nombre = nombre;
        NumControl = numControl;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumControl() {
        return NumControl;
    }

    public void setNumControl(String numControl) {
        NumControl = numControl;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
