/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author HERNANFA
 */
public class JPanelColor extends JPanel {

    double[] x, y, xp, yp;

    JPanelColor(double[] x, double[] y, double[] xp, double[] yp) {
        this.x = x;
        this.y = y;
        this.xp = xp;
        this.yp = yp;

    }

// dibuja rectángulos y objetos String en distintos colores
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // llama el método paintComponent de la superclase

        this.setBackground(Color.WHITE);

        int l = this.getWidth();//largo
        int a = this.getHeight();//ancho
        //  grafica de los ejes
        g.setColor(Color.BLACK);
        g.drawLine(0, a / 2, l, a / 2);
        g.drawLine(l / 2, 0, l / 2, a);
/////////////////////////////7 escala
        int auxL = l / 2;
        int auxA = a / 2;
        int xL = auxL, yA = auxA - 3;
        int rep = auxL / 20;
        int ac=1;
        for (int i = 0; i < rep; i++) {//escala x negativa
           
           if(i==0){
               g.setColor(Color.BLACK);
            g.drawLine(xL, 0, xL, a);

           }else{
            g.setColor(Color.GRAY);
            g.drawLine(xL, 0, xL, a);
            if(ac==2){
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf("-"+i), xL-5, yA+18);
            ac=1;
            }else{
            ac++;    
            }
           }
            g.setColor(Color.BLACK);
            g.drawLine(xL, yA, xL, yA + 6);
            xL -= 20;
        }
        xL = auxL;
        yA = auxA - 3;
        ac=1;
        for (int i = 0; i < rep; i++) {//escala x positiva
           
            if(i==0){
               g.setColor(Color.BLACK);
            g.drawLine(xL, 0, xL, a);
           }else{
            g.setColor(Color.GRAY);
            g.drawLine(xL, 0, xL, a);
            if(ac==2){
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(i), xL-5, yA+18);
            ac=1;
            }else{
            ac++;    
            }
           }
             g.setColor(Color.BLACK);
            g.drawLine(xL, yA, xL, yA + 6);
            xL += 20;
        }
        xL = auxL - 3;
        yA = auxA;
        rep = auxA / 20;
        ac=1;
        for (int i = 0; i < rep; i++) {//escala y positiva
            if(i==0){
               g.setColor(Color.BLACK);
               
            g.drawLine(0, yA, l, yA);
           }else{
            g.setColor(Color.GRAY);
            g.drawLine(0, yA, l, yA);
            if(ac==2){
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf("-"+i), xL+18, yA);
            ac=1;
            }else{
            ac++;    
            }
            
           }
            g.setColor(Color.BLACK);
            g.drawLine(xL, yA, xL + 6, yA);
            yA += 20;
        }
        yA = auxA;
        ac=1;
        for (int i = 0; i < rep; i++) {//escala y positiva
            if(i==0){
               g.setColor(Color.BLACK);
            g.drawLine(0, yA, l, yA);
           }else{
            g.setColor(Color.GRAY);
            g.drawLine(0, yA, l, yA);
            if(ac==2){
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(i), xL+18, yA);
            ac=1;
            }else{
            ac++;    
            }
           }
            g.setColor(Color.BLACK);
            g.drawLine(xL, yA, xL + 6, yA);
            yA -= 20;
        }
//////////////rectificacion de valores para la funcion
   g.setColor(Color.BLACK);
        int[] xv = new int[x.length];
        int[] yv = new int[x.length];
        int[] xvp = new int[xp.length];
        int[] yvp = new int[yp.length];
        for (int i = 0; i < 30; i++) {
            if (x[i] == 0) {//// rectificacion x
                xv[i] = auxL;
            } else if (x[i] > 0) {
                xv[i] = (int) ((20 * x[i]) + auxL);
            } else {
                xv[i] = (int) (auxL + (x[i] * 20));
            }
            ////////////////////////77rectificacion y   
            if (y[i] == 0) {
                yv[i] = auxA;
            } else if (y[i] > 0) {
                yv[i] = (int) (auxA - (y[i] * 20));
            } else {
                yv[i] = (int) (auxA + Math.abs(y[i] * 20));
            }

        }

        for (int i = 0; i < xp.length; i++) {

            /////////////////////////////////////777
            if (xp[i] == 0) {
                xvp[i] = auxL;
            } else if (xp[i] > 0) {
                xvp[i] = (int) ((20 * xp[i]) + auxL);
//                double au = ((20 * xp[i]) + auxL);
//                double aux = au - xvp[i];
//                if (aux != 0) {
//
//                    xvp[i] = xvp[i] + (int) (20 * aux);
//                }
            } else {
                xvp[i] = (int) (auxL + (xp[i] * 20));
                double au = (auxL + (xp[i] * 20));
//                double aux = au - xvp[i];
//                if (aux != 0) {
//
//                    xvp[i] = xvp[i] - (int) (20 * aux);
//                }
            }
            //////////////////////////////77
            if (yp[i] == 0) {
                yvp[i] = auxA;
            } else if (yp[i] > 0) {
                yvp[i] = (int) (auxA - (yp[i] * 20));
//                double au = (auxA - (yp[i] * 20));
//                double aux = au - yvp[i];
//                if (aux != 0) {
//
//                    yvp[i] = yvp[i] - (int) (20 * aux);
//                }
            } else {
                yvp[i] = (int) (auxA + Math.abs(yp[i] * 20));
//                double au = (auxA + Math.abs(yp[i] * 20));
//                double aux = au - yvp[i];
//                if (aux != 0) {
//
//                    yvp[i] = yvp[i] + (int) (20 * aux);
//                }
            }

           

        }

        /////graica
        g.setColor(Color.red);
        for (int i = 0; i < x.length-2; i++) {

            g.drawLine(xv[i], yv[i], xv[i + 1], yv[i + 1]);
        }
        g.setColor(Color.BLACK);
        for (int i = 0; i < yp.length; i++) {
            g.drawOval(xvp[i]-1, yvp[i]-1, 3, 3);
        }
        this.setBackground(new Color(162,249,220));

    } // fin del método paintComponent

} // fin de la clase JPanelColor
