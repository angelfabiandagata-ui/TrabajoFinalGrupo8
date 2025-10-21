/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Ema
 */
public class Masajista {  
    
    //ATRIBUTOS
    long matricula;
    String nombreyapellido;
    long telefono;
    String especialidad;
    boolean estado;  
    
    //CONSTRUCTOR
    public Masajista(long matricula, String nombreyapellido, long telefono, String especialidad, boolean estado) {
        this.matricula = matricula;
        this.nombreyapellido = nombreyapellido;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.estado = estado;
    }
    
    //GETTERS AND SETTERS
    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNombreyapellido() {
        return nombreyapellido;
    }

    public void setNombreyapellido(String nombreyapellido) {
        this.nombreyapellido = nombreyapellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
//final    
}