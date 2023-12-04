/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class Validaciones
{

    public static void va(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                    && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != ' '
                    && ke.getKeyChar() != 'ñ' && ke.getKeyChar() != 'Ñ'
                    && ke.getKeyChar() != 'á' && ke.getKeyChar() != 'Á'
                    && ke.getKeyChar() != 'é' && ke.getKeyChar() != 'É'
                    && ke.getKeyChar() != 'í' && ke.getKeyChar() != 'Í'
                    && ke.getKeyChar() != 'ó' && ke.getKeyChar() != 'Ó'
                    && ke.getKeyChar() != 'ú' && ke.getKeyChar() != 'Ú')
            {
                ke.setKeyChar((char) 8);
            } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
            {
                ke.setKeyChar((char) (ke.getKeyChar() - 32));
            } else if (ke.getKeyChar() == 'ñ')
            {
                ke.setKeyChar('Ñ');
            } else if (ke.getKeyChar() == 'á')
            {
                ke.setKeyChar('Á');
            } else if (ke.getKeyChar() == 'é')
            {
                ke.setKeyChar('É');
            } else if (ke.getKeyChar() == 'í')
            {
                ke.setKeyChar('Í');
            } else if (ke.getKeyChar() == 'ó')
            {
                ke.setKeyChar('Ó');
            } else if (ke.getKeyChar() == 'ú')
            {
                ke.setKeyChar('Ú');
            }
        }
    }

    public static void vaP(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                    && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != '-'
                    && ke.getKeyChar() != 'ñ' && ke.getKeyChar() != 'Ñ'
                    && (ke.getKeyChar() < '0' || ke.getKeyChar() > '9'))
            {
                ke.setKeyChar((char) 8);
            } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
            {
                ke.setKeyChar((char) (ke.getKeyChar() - 32));
            } else if (ke.getKeyChar() == 'ñ')
            {
                ke.setKeyChar('Ñ');
            }
        }
    }

    public static void van(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                    && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                    && (ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != '.'
                    && ke.getKeyChar() != ' ' && ke.getKeyChar() != 'ñ'
                    && ke.getKeyChar() != 'Ñ' && ke.getKeyChar() != 'á'
                    && ke.getKeyChar() != 'Á' && ke.getKeyChar() != 'é'
                    && ke.getKeyChar() != 'É' && ke.getKeyChar() != 'í'
                    && ke.getKeyChar() != 'Í' && ke.getKeyChar() != 'ó'
                    && ke.getKeyChar() != 'Ó' && ke.getKeyChar() != 'ú'
                    && ke.getKeyChar() != 'Ú')
            {
                ke.setKeyChar((char) 8);
            } else if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
            {
                ke.setKeyChar((char) (ke.getKeyChar() - 32));
            } else if (ke.getKeyChar() == 'ñ')
            {
                ke.setKeyChar('Ñ');
            } else if (ke.getKeyChar() == 'á')
            {
                ke.setKeyChar('Á');
            } else if (ke.getKeyChar() == 'é')
            {
                ke.setKeyChar('É');
            } else if (ke.getKeyChar() == 'í')
            {
                ke.setKeyChar('Í');
            } else if (ke.getKeyChar() == 'ó')
            {
                ke.setKeyChar('Ó');
            } else if (ke.getKeyChar() == 'ú')
            {
                ke.setKeyChar('Ú');
            }
        }
    }

    public static void validaEntero(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                    && ke.getKeyCode() != 8)
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    public static boolean valPal(String s)
    {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++)
        {
            if (c[i] != ' ')
            {
                return true;
            }
        }
        return false;
    }

    public static boolean pinError(JTextField tx, JLabel lb, String m, String er, boolean b)
    {
        if (tx.getText().equals(m) || b)
        {
            tx.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
            lb.setText(er);
            return false;
        }
        return true;
    }
}
