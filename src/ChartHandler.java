import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.HashMap;

public class ChartHandler {

    public void displayAttributePieChart(HashMap<String, Integer> attributeCount) {

        PieDataset dataset = createDataset(attributeCount);

        JFreeChart chart = ChartFactory.createPieChart(
                "Распределение героев по атрибутам",
                dataset,
                true,
                true,
                false
        );

        customizeChart(chart, attributeCount);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Круговая диаграмма");
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private PieDataset createDataset(HashMap<String, Integer> attributeCount) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        for (String attribute : attributeCount.keySet()) {
            dataset.setValue(attribute, attributeCount.get(attribute));
        }

        return dataset;
    }

    private void customizeChart(JFreeChart chart, HashMap<String, Integer> attributeCount) {
        PiePlot plot = (PiePlot) chart.getPlot();

        plot.setSectionPaint("Сила", new Color(255, 0, 52));
        plot.setSectionPaint("Ловкость", new Color(17, 255, 0));
        plot.setSectionPaint("Интеллект", new Color(0, 72, 255));
        plot.setSectionPaint("Универсальный", new Color(255, 181, 0));

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})",
                new DecimalFormat("0"),
                new DecimalFormat("0%")
        );
        plot.setLabelGenerator(labelGenerator);

        plot.setLabelFont(new Font("Arial", Font.PLAIN, 16));
    }
}
