/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class Auto implements Serializable
{
    private String modelo;
    private int anio;
    private String placas;
    private Sucursal sucursal;

    public Auto()
    {
    }
    
    public Auto(String modelo, int anio, String placas, Sucursal sucursal)
    {
        this.modelo = modelo;
        this.anio = anio;
        this.placas = placas;
        this.sucursal = sucursal;
    }

    /**
     * @return the modelo
     */
    public String getModelo()
    {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    /**
     * @return the anio
     */
    public int getAnio()
    {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio)
    {
        this.anio = anio;
    }

    /**
     * @return the placas
     */
    public String getPlacas()
    {
        return placas;
    }

    /**
     * @param placas the placas to set
     */
    public void setPlacas(String placas)
    {
        this.placas = placas;
    }
    
    /**
     * @return the sucursal
     */
    public Sucursal getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}
