/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Cliente {
       
    //ATRIBUTOS
    private int codCliente;
    private long dni;
    private String nombre;
    private String apellido;
    private long telefono;
    private int edad;
    private String afeciones;
    private boolean estado;
    
    //CONSTRUCTOR

    public Cliente(int codCliente, long dni, String nombre, String apellido, long telefono, int edad, String afeciones, boolean estado) {
        this.codCliente = codCliente;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.afeciones = afeciones;
        this.estado = estado;
    }
  

    public Cliente() {
    }
    
    //GETTERS AND SETTERS
    public int getCodCli() {
        return codCliente;
    }

    public void setCodCli(int codCli) {
        this.codCliente = codCli;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
