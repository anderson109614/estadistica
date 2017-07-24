
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anderson
 */
public class Histograma extends JPanel {
    int v[];

    Histograma(int[] val) {
        v = val;

    }

// dibuja rectángulos y objetos String en distintos colores
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // llama el método paintComponent de la superclase

        this.setBackground(Color.WHITE);

// establece nuevo color de dibujo, usando valores enteros
        g.setColor(Color.BLACK);//Grafica del rectangulo
        g.drawRect(40, 40, 500, 300);
        //////Grafica de las lineas
        int x1, y1;
        y1 = 40;
        x1 = 40;
        for (int i = 0; i < 10; i++) {
            g.setColor(Color.BLACK);
            g.drawLine(x1, y1, x1 + 500, y1);

            y1 = y1 + 30;
        }
/////// numeros de las escala
        int m = mayorLis();
        int sup;
        sup = ((m / 10) + 1) * 10;
        int inci = sup;
        int incr = sup / 10;
        y1 = 40;
        x1 = 25;
        for (int i = 0; i < 10; i++) {
            g.drawString(String.valueOf(sup), x1, y1);
            sup = sup - incr;
            y1 = y1 + 30;
        }

        int x, y, l;//Variables para posicion de los valores de las pilas
        x = 50;
        y = 340;
        l = 50;

//Rectificacion de valores
        int v2[] = new int[4];
        for (int i = 0; i < 4; i++) {
            v2[i] = (300 * v[i]) / inci;
        }
/// grafita de las figuras
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.BLUE);
            g.fill3DRect(x, y - v2[i], l, v2[i],false);
            
            x = x + 123;

        }
        ///////// colocacion de valores
        y1 = 360;
        x1 = 70;
        for (int i = 0; i < 4; i++) {
            g.setColor(Color.BLACK);
            g.drawString("V"+String.valueOf(i+1),x1 ,y1);
            g.drawString(String.valueOf(v[i]),x1 ,335-v2[i]);
            x1 = x1+ 123;
        }
    } // fin del método paintComponent

    private int mayorLis() {
        int m1, m2;
        if (v[0] > v[1]) {
            m1 = v[0];
        } else {
            m1 = v[0];
        }
        if (v[2] > v[3]) {
            m2 = v[2];
        } else {
            m2 = v[3];
        }
        if (m1 > m2) {
            return m1;
        } else {
            return m2;
        }

    }
}
