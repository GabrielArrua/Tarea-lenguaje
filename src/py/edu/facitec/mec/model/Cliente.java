/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.model;

/**
 *
 * @author user
 */
public class Cliente {
    private int codigo;
    private String nombre;
    private String apellido;
    private String direccion;
    private Ciudad ciudad;
    private double credito;

    public Cliente() {
        this.apellido="";
        this.ciudad = new Ciudad();
        this.nombre="";
        this.codigo=0;
        this.direccion="";
        this.credito=0d;
        
    }

    public Cliente(int codigo, String nombre, String apellido, String direccion, Ciudad ciudad, double credito) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.credito = credito;
    }
  public Cliente(int codigo, String nombre ,String apellido,String direccion){
       this.codigo =codigo;
      this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
      
  }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }
    
    
    
}
