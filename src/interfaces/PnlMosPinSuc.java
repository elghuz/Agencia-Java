/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import BDagencia.SucursalDAO;
import BDagencia.ServicioDAO;
import BDagencia.PinturaDAO;
import BDagencia.AutoDAO;
import agencia.Auto;
import agencia.Sucursal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author PC
 */
public class PnlMosPinSuc extends javax.swing.JPanel
{

    /**
     * Creates new form PnlMosPin
     */
    private boolean b;

    public PnlMosPinSuc(boolean b)
    {
        this.b = b;
        initComponents();
        moscom();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        mostContSuc = new javax.swing.JPanel();
        mosSuc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(78, 82, 85));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        mostContSuc.setBackground(new java.awt.Color(78, 82, 85));
        mostContSuc.setLayout(new java.awt.GridLayout(0, 4, 5, 10));
        jScrollPane1.setViewportView(mostContSuc);

        mosSuc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mosSuc.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mosSucActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Mapa.png"))); // NOI18N
        jLabel1.setText("Seleccione una sucursal:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mosSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mosSuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mosSucActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mosSucActionPerformed
    {//GEN-HEADEREND:event_mosSucActionPerformed
        mostContSuc.removeAll();
        List<Sucursal> sucursalesDisponibles = SucursalDAO.desplegarTodasLasSucursales();
        if (sucursalesDisponibles.size()>0)
        {
            most();
        }
        mostContSuc.revalidate();
        mostContSuc.repaint();
    }//GEN-LAST:event_mosSucActionPerformed

    private void moscom()
    {
        List<Sucursal> sucursalesDisponibles = SucursalDAO.desplegarTodasLasSucursales();
        for (int i = 0; i < sucursalesDisponibles.size(); i++)
        {
            mosSuc.addItem(sucursalesDisponibles.get(i).getNombre());
        }
    }

    private void most()
    {
        List<Auto> autos = new ArrayList<>();
        autos = AutoDAO.obtenerAutosPorSucursal(mosSuc.getSelectedItem().toString());
        for(int j = 0; j < autos.size(); j++){
            if(PinturaDAO.verificarExistenciaAuto(autos.get(j).getPlacas().toString()) && b){
                JLabel lab = new JLabel("<html>Placas: <p>" + autos.get(j).getPlacas().toString()
                        + "<p>Modelo: <p>" + autos.get(j).getModelo().toString()
                        + "<p>Año:<p>" + autos.get(j).getAnio()
                        + "<p>Color:<p>" + PinturaDAO.obtenerPintura(autos.get(j).getPlacas().toString())
                        + "<p>Fecha de ingreso:<p>" + PinturaDAO.obtenerFechaEntrada(autos.get(j).getPlacas().toString())
                        + "<p>Fecha de salida:<p>" + PinturaDAO.obtenerFechaSalida(autos.get(j).getPlacas().toString())
                        + "<html>", new javax.swing.ImageIcon(getClass().getResource("/imagenes/icnPin.png")),
                        javax.swing.SwingConstants.CENTER);
                //lab.setSize(200, 200);
                lab.setBackground(new java.awt.Color(226, 222, 219));
                lab.setOpaque(true);
                lab.setFont(new java.awt.Font("Tahoma", 1, 12));
                mostContSuc.add(lab);
            }
            if(ServicioDAO.verificarExistenciaAuto(autos.get(j).getPlacas().toString()) && !b){
                String pagadito = (ServicioDAO.isPagado(autos.get(j).getPlacas())) ? "SI" : "NO";
                JLabel lab = new JLabel("<html>Sucursal:<p>" + mosSuc.getSelectedItem().toString()
                        + "<p>Placas:<p>" + autos.get(j).getPlacas().toString()
                        + "<p>Modelo:<p>" + autos.get(j).getModelo().toString()
                        + "<p>Año:<p>" + autos.get(j).getAnio()
                        + "<p>Presupuesto:<p>" + ServicioDAO.getPresupuesto(autos.get(j).getPlacas().toString())
                        + "<p>Tip. de servicio:<p>" + ServicioDAO.obtenerTipo(autos.get(j).getPlacas().toString())
                        + "<p>Pagado:<p>" + pagadito + "<html>",
                        new javax.swing.ImageIcon(getClass().getResource("/imagenes/icnRep.png")),
                        javax.swing.SwingConstants.CENTER);
                //lab.setSize(200, 200);
                lab.setBackground(new java.awt.Color(226, 222, 219));
                lab.setFont(new java.awt.Font("Tahoma", 1, 12));
                lab.setOpaque(true);
                mostContSuc.add(lab);
            }
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> mosSuc;
    private javax.swing.JPanel mostContSuc;
    // End of variables declaration//GEN-END:variables
}
