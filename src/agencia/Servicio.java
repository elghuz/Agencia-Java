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
public class Servicio extends Auto implements Serializable
{
    private String tipoServicio;
    private int presupuesto;
    private char[] pagado;

    public Servicio(String tipoServicio, int presupuesto, char[] pagado, String modelo, int anio, String placas, Sucursal sucursal)
    {
        super(modelo, anio, placas, sucursal);
        this.tipoServicio = tipoServicio;
        this.presupuesto = presupuesto;
        this.pagado = pagado;
    }

    public Servicio()
    {
    }

    /**
     * @return the tipoServicio
     */
    public String getTipoServicio()
    {
        return tipoServicio;
    }

    /**
     * @param tipoServicio the tipoServicio to set
     */
    public void setTipoServicio(String tipoServicio)
    {
        this.tipoServicio = tipoServicio;
    }

    /**
     * @return the presupuesto
     */
    public int getPresupuesto()
    {
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(int presupuesto)
    {
        this.presupuesto = presupuesto;
    }

    /**
     * @return the pagado
     */
    public char[] getPagado()
    {
        return pagado;
    }

    /**
     * @param pagado the pagado to set
     */
    public void setPagado(char[] pagado)
    {
        this.pagado = pagado;
    }
}
