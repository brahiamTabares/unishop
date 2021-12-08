package co.edu.uniquindio.proyecto.bean.reportes;

import co.edu.uniquindio.proyecto.dto.DatoDTO;
import co.edu.uniquindio.proyecto.servicios.ReporteServicio;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.animation.Animation;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
@Setter
public class ReporteBean {

    protected ReporteServicio reporteServicio;
    protected BarChartModel model;
    protected String label;
    protected List<DatoDTO> datos;
    protected String titulo;

    public ReporteBean(ReporteServicio reporteServicio) {
        this.reporteServicio = reporteServicio;
    }

    public void createBarModel() {
        model = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel(label);

        List<Number> values = datos.stream().map(DatoDTO::getValor).collect(Collectors.toList());
        barDataSet.setData(values);

        Random random = new Random();

        List<String> bgColor = new ArrayList<>();
        List<String> borderColor = new ArrayList<>();

        datos.forEach(d -> {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            bgColor.add(String.format("rgba(%d, %d, %d, 0.2)", r, g, b));
            borderColor.add(String.format("rgb(%d, %d, %d)", r, g, b));
        });

        barDataSet.setBackgroundColor(bgColor);
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);

        data.addChartDataSet(barDataSet);

        List<String> labels = datos.stream().map(DatoDTO::getTexto).collect(Collectors.toList());
        data.setLabels(labels);
        model.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText(titulo);
        options.setTitle(title);

        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        // disable animation
        Animation animation = new Animation();
        animation.setDuration(0);
        options.setAnimation(animation);

        model.setOptions(options);
    }
}
