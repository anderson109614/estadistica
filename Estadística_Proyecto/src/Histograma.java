
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
    String[] d;

    Histograma(int[] val,String[] datos) {
        v = val;
        d=datos;
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
        int v2[] = new int[v.length];
        for (int i = 0; i < v.length; i++) {
            v2[i] = (300 * v[i]) / inci;
        }
/// grafita de las figuras
int inter=500/v.length;
        for (int i = 0; i < v.length; i++) {
            g.setColor(Color.BLUE);
            g.fill3DRect(x, y - v2[i], l, v2[i],false);
            
            x = x + inter;

        }
        ///////// colocacion de valores
        y1 = 360;
        x1 = 70;
        for (int i = 0; i < v.length; i++) {
            g.setColor(Color.BLACK);
            g.drawString(d[i],x1-15 ,y1);
            g.drawString(String.valueOf(v[i]),x1 ,335-v2[i]);
            x1 = x1+ inter;
        }
    } // fin del método paintComponent

    private int mayorLis() {
        int m=v[0];
        for (int i = 0; i < v.length; i++) {
            if(m>v[i]){
                
            }else{
                m=v[i];
            }
        }
      return m;
    }
}
