
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gaby
 */
public class Histo {

    double[] x, y;
    int n;
    double fx, fy;

    public Histo(double[] x, double[] y, int nclas) {
        this.x = x;
        this.y = y;
        this.n = nclas;
        frecuensia();
        conteo();
        graficas();
        
    }

    public void frecuensia() {
        fx = (x[0] - x[x.length - 1]) / n;
        fy = (y[0] - y[y.length - 1]) / n;

    }
    int[] vectorX;
    int[] vectorY;
    String[] dx,dy;

    public void conteo() {
        vectorX = new int[n];
       vectorY = new int[n];
      dx=new String[n];
      dy=new String[n];
        double min = x[x.length - 1];//// conteo de x 
        for (int i = 0; i < n; i++) {
            int con=0;
            for (int j = 0; j < x.length; j++) {
                if (x[j] >= min && x[j] < (min + fx)) {
                   
                 con++;
                }

            }
            double max=min+fx;
            dx[i]=String.format("%.2f",min)+"-"+String.format("%.2f",max);
             vectorX[i]=con;
            min = min + fx;
        }
        
        min = y[y.length - 1];//// conteo de y
        for (int i = 0; i < n; i++) {
            int con=0;
            for (int j = 0; j < y.length; j++) {
                if (y[j] >= min && y[j] < (min + fy)) {
                   
                 con++;
                }

            }
            double max=min+fy;
            dy[i]=String.format("%.2f",min)+"-"+String.format("%.2f",max);
             vectorY[i]=con;
            min = min + fy;
        }


    }

    public void graficas(){
        
        JFrame frame = new JFrame("Histograma X");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Histograma jPanelColor = new Histograma(vectorX,dx); // create JPanelColor
        frame.add(jPanelColor); // agrega jPanelColor a marco
        frame.setSize(600, 400); // establece el tamaño del marco
        frame.setVisible(true);
        
        
         JFrame frameY = new JFrame("Histograma Y");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Histograma jPanelColorY = new Histograma(vectorY,dy); // create JPanelColor
        frameY.add(jPanelColorY); // agrega jPanelColor a marco
        frameY.setSize(600, 400); // establece el tamaño del marco
        frameY.setVisible(true);
        frameY.setLocation(500, 100);
    }
    
    
}
