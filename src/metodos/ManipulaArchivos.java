
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author LS
 */
public class ManipulaArchivos
{
    public static String guardo(Object [] obj,String trayectoria)
    {
        try
        {
            FileOutputStream fos=new FileOutputStream(trayectoria);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(obj);arch.close();
        } catch (FileNotFoundException ex)
        {
            return "No encontre el archivo";
        }catch (Exception ex)
        {
            return "Error..."+ex.toString();
        }
        return "Se guardo el archivo";
    }
    
    public static Object [] carga(JFrame jf,String trayectoria)
    {
        Object obj[]=null;
        try
        {
            FileInputStream fos=new FileInputStream(trayectoria);
            ObjectInputStream arch = new ObjectInputStream(fos);
            //Mensaje.exito(jf,"Se cargo el archivo");
            obj= (Object []) arch.readObject();
        } catch (FileNotFoundException ex)
        {
            //Mensaje.error(jf,"No encontre el archivo");
        }catch (Exception ex)
        {
            //Mensaje.error(jf,"Error..."+ex.toString());
        }
        return obj;
    }
    public static String guardo(Object obj, String trayectoria)
    {
        try
        {
            FileOutputStream fos=new FileOutputStream(trayectoria);
            ObjectOutputStream arch = new ObjectOutputStream(fos);
            arch.writeObject(obj);arch.close();
            return "Se guardo el archivo";
        } catch (FileNotFoundException ex)
        {
            return "No encontre el archivo";
        }catch (Exception ex)
        {
            return "Error..."+ex.toString();
        }
    }
    
    public static Object carga(boolean n, JFrame jf, String trayectoria)
    {
        Object obj=null;
        try
        {
            FileInputStream fos=new FileInputStream(trayectoria);
            ObjectInputStream arch = new ObjectInputStream(fos);
            obj= (Object ) arch.readObject();
            //Mensaje.exito(jf,"Se cargo el archivo");
        } catch (FileNotFoundException ex)
        {
           // Mensaje.error(jf,"No encontre el archivo");
        }catch (Exception ex)
        {
            //Mensaje.error(jf,"Error..."+ex.toString());
        }
        return obj;
    }
}
