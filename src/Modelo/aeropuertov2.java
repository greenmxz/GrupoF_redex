/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Nowa
 */
public class aeropuertov2 {
    private String codigo;
    private String nombre;
    private String continente;
    private String pais;
    private String ciudad;
    private int capMax;
    private int capActual;
    private String estado;

    public aeropuertov2(String codigo, String nombre, String continente, 
            String pais, String ciudad, int capMax, int capActual,
            String estado){
        this.codigo = codigo;
        this.nombre = nombre;
        this.continente = continente;
        this.pais = pais;
        this.ciudad = ciudad;
        this.capMax = capMax;
        this.capActual = capActual;
        this.estado = estado;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCapMax() {
        return capMax;
    }

    public void setCapMax(int capMax) {
        this.capMax = capMax;
    }

    public int getCapActual() {
        return capActual;
    }

    public void setCapActual(int capActual) {
        this.capActual = capActual;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}