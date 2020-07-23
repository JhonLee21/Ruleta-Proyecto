/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentación;

import Pilas.Pila;
import Cola.Cola;
import Lista.clsListaSimple;
import Lista.clsListaCircular;
import negocio.nodo;
import negocio.nodoLD;
import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class vista extends javax.swing.JFrame {

    /**
     * Creates new form vista
     */
    private Pila objePila;
    private Cola objCola;
    private clsListaSimple objListaS;
    private clsListaCircular objListaC;
    private int px, py;
    public String[] mColors = {
        "#39add1", // light blue
        "#3079ab", // dark blue
        "#c25975", // mauve
        "#e15258", // red
        "#f9845b", // orange
        "#838cc7", // lavender
        "#7d669e", // purple
        "#53bbb4", // aqua
        "#51b46d", // green
        "#e0ab18", // mustard
        "#637a91", // dark gray
        "#f092b0", // pink
        "#b7c0c7" // light gray
    };

    public vista() {
        initComponents();
        this.objePila = new Pila();
        this.objCola = new Cola();
        this.objListaS = new clsListaSimple();
        this.objListaC = new clsListaCircular();
        px = 80;
        py = 120;
    }

    public void graficarPila() {
        Graphics dibujar = this.getGraphics();
        dibujar.clearRect(px, py, 300, 400);
        nodo nn = this.objePila.getCima();
        int i = 0;
        dibujar.drawString("Cima->", px - 45, py + 25);
        while (nn != null) {
            String dd = nn.getDato();
            dibujar.setColor(Color.RED);
            dibujar.drawRect(px, py + i * 35, 80, 30);
            dibujar.setColor(Color.BLACK);
            dibujar.drawString(dd, px, py + i * 35 + 25);
            i++;
            nn = nn.getRefNodo();
        }
    }

    public void graficarRuleta() {
        Graphics pintar = this.getGraphics();
        nodoLD aux = this.objListaC.getPLC();
        int line = 105;
        int rect = 120;
        int total = 500;
        int porcion = total / objListaC.cantidadNodos();
        int grados = porcion * 360 / total;
        int grados_parciales = 0;
        pintar.setColor(new Color(255, 255, 255));
        pintar.fillRect(250, 120, 100, 300);

        for (int i = 0; i < objListaC.cantidadNodos(); i++) {
            aux.setColor(mColors[i]);
            pintar.setColor(Color.decode(mColors[i]));
            pintar.fillArc(25, 80, 200, 200, grados_parciales, grados);
            grados_parciales = grados_parciales + grados;
            pintar.fillRect(250, rect, 20, 20);
            line = line + 30;
            rect = rect + 30;
            pintar.setColor(Color.decode(mColors[i]));
            pintar.drawString(aux.getDato() + "-" + aux.getObjeto(), 275, line);
            aux = aux.getRefDer();
        }
    }

    public void girarRuleta() throws InterruptedException {
        Graphics pintar = this.getGraphics();
        nodoLD aux = objListaC.getPLC();
        String color_anterior = "";
        int line = 105;
        int rect = 120;
        int total = 500;
        int porcion = total / objListaC.cantidadNodos();
        int grados = porcion * 360 / total;
        int grados_parciales = 0;
        int grados_parciales_ant = 0;
        for (int i = 0; i < 9; i++) {
            if (i != 0) {
                pintar.setColor(Color.decode(color_anterior));
                pintar.fillArc(25, 80, 200, 200, grados_parciales_ant, grados);
            }
            color_anterior = aux.getColor();
            pintar.setColor(new Color(255, 255, 255));
            pintar.fillArc(25, 80, 200, 200, grados_parciales, grados);
            grados_parciales_ant = grados_parciales;
            grados_parciales = grados_parciales + grados;
            aux = aux.getRefDer();
            Thread.sleep(500);
        }
        JOptionPane.showMessageDialog(null, "Te ganaste... " + aux.getRefIzq().getObjeto());

    }

    public void graficarCola() {
        Graphics pintar = this.getGraphics();

        int total = 500;
        int porcion = total / objListaC.cantidadNodos();
        int grados = porcion * 360 / total;
        int grados_parciales = 0;
        for (int i = 0; i < total; i++) {
            pintar.setColor(new Color(255, 0, 0));
            pintar.fillArc(25, 80, 200, 200, grados_parciales, grados);
            grados_parciales = grados_parciales + grados;
            pintar.fillRect(250, 120, 20, 20);
            pintar.drawString("Color Rojo", 275, 135);
        }

    }

    public void graficarListaS() {
        Graphics ff = this.getGraphics();
        ff.clearRect(px, py, 1200, 300);
        nodo objL = this.objListaS.getRefPri();
        ff.setColor(Color.red);
        int i = 0, w = 80, h = 30, r = 10;
        while (objL != null) {
            String bb = objL.getDato();
            ff.drawRect(px + i * w, py, w - r, h);
            ff.fillRect(px + (i + 1) * w - 2 * r, py, r, h);
            ff.drawLine(px + (i + 1) * w - r, py + h / 2, px + (i + 1) * w, py + h / 2);
            ff.drawString(bb, px + i * w + 5, py + h - 5);
            i++;
            objL = objL.getRefNodo();
            ff.setColor(Color.BLACK);
        }
    }

    public void graficarListaBusqueda(int codigo) {
        Graphics ff = this.getGraphics();
        ff.clearRect(px, py, 1200, 300);
        nodo objL = this.objListaS.getRefPri();
        if (objL.getCod() == codigo) {
            ff.setColor(Color.yellow);
        } else {
            ff.setColor(Color.red);
        }
        int i = 0, w = 80, h = 30, r = 10;
        while (objL != null) {
            String bb = objL.getDato();
            ff.drawRect(px + i * w, py, w - r, h);
            ff.fillRect(px + (i + 1) * w - 2 * r, py, r, h);
            ff.drawLine(px + (i + 1) * w - r, py + h / 2, px + (i + 1) * w, py + h / 2);
            ff.drawString(bb, px + i * w + 5, py + h - 5);
            i++;
            objL = objL.getRefNodo();
            if (objL != null && objL.getCod() == codigo) {
                ff.setColor(Color.yellow);
            } else {
                ff.setColor(Color.BLACK);
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setToolTipText("");

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Girar Ruleta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField3.setToolTipText("");

        jLabel1.setText("Código:");

        jLabel2.setText("Detalle:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton3)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jButton4)
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(232, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* int dato = Integer.parseInt(jTextField1.getText());
        String de = jTextField2.getText();
        this.objListaS.insertarOrdenado(dato, de);
        graficarListaS();        // TODO add your handling code here:
         */
        int dato = Integer.parseInt(jTextField1.getText());
        String objeto = jTextField2.getText();
        this.objListaC.insertarDerecha(dato, objeto);
        graficarRuleta();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //  int pro = 0;
        //pro = this.objListaS.cantidadPrimos();
        // jTextField1.setText(pro + "");
        int dato = Integer.parseInt(jTextField3.getText());
        this.objListaC.eliminarBusqueda(dato);
        graficarRuleta();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            girarRuleta();
        } catch (InterruptedException ex) {
            Logger.getLogger(vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
