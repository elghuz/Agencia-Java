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
public class Pintura extends Auto implements Serializable
{
    private String fechaIngreso;
    private String color;
    private String fechaSalida;
    

    public Pintura()
    {
    }

    public Pintura(String fechaIngreso, String color, String fechaSalida, String modelo, int anio, String placas, Sucursal sucursal)
    {
        super(modelo, anio, placas,sucursal);
        this.fechaIngreso = fechaIngreso;
        this.color = color;
        this.fechaSalida = fechaSalida;
        
    }

    /**
     * @return the fechaIngreso
     */
    public String getFechaIngreso()
    {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(String fechaIngreso)
    {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * @return the fechaSalida
     */
    public String getFechaSalida()
    {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(String fechaSalida)
    {
        this.fechaSalida = fechaSalida;
    }
}
