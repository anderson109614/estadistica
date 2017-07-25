
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
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
public class Histo extends ApplicationFrame {

    int v[];

    public Histo(String tittle) {
        super(tittle);
        JPanel chartPanel = crearPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 475));
        setContentPane(chartPanel);
    }

    private static IntervalXYDataset crearDataset() {
        HistogramDataset dataset = new HistogramDataset();
//vecto almacena los ingresos quincenales de 45 personas
        double vector[] = {63, 89, 36, 49, 56, 64, 59, 35, 78,
            43, 53, 70, 57, 62, 43, 68, 62, 26,
            64, 72, 52, 51, 62, 60, 71, 61, 55,
            59, 60, 67, 57, 67, 61, 67, 51, 81,
            53, 64, 76, 44, 73, 56, 62, 63, 60};
//En el ejercicio nos piden construir una distribución de frecuencias de 8 intervalos
//Por eso ponemos 8 en el tercer parámetro del addSeries
        dataset.addSeries(" ", vector, 8);
        return dataset;
    }

    private static JFreeChart crearChart(IntervalXYDataset dataset) {
        JFreeChart chart = ChartFactory.createHistogram(
                "Histograma",
                null,
                null,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        XYBarRenderer renderer = (XYBarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        return chart;
    }

    public static JPanel crearPanel() {
        JFreeChart chart = crearChart(crearDataset());
        return new ChartPanel(chart);
    }

}
