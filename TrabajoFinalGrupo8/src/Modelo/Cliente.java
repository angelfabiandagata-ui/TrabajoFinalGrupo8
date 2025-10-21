/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Cliente {
       
    //ATRIBUTOS
    private int codCli;
    private long dni;
    private String nombrecompleto;
    private long telefono;
    private int edad;
    private String afeciones;
    private boolean estado;
    
    //CONSTRUCTOR
    public Cliente(int codCli, long dni, String nombrecompleto, long telefono, int edad, String afeciones, boolean estado) {
        this.codCli = codCli;
        this.dni = dni;
        this.nombrecompleto = nombrecompleto;
        this.telefono = telefono;
        this.edad = edad;
        this.afeciones = afeciones;
        this.estado = estado;
    }    

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //GETTERS AND SETTERS
    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAfeciones() {
        return afeciones;
    }

    public void setAfeciones(String afeciones) {
        this.afeciones = afeciones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
//fin 
}
