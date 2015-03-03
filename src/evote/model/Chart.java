package evote.model;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class Chart {
	private PieChartModel model;
	
	public Chart()
	{
		model= new PieChartModel();
		model.set("Opcion 1", 300);
		model.set("Opcion 2", 250);
		model.set("Opcion 3", 100);
		model.setTitle("Votacion X");
		model.setLegendPosition("s");
	}
	
	public PieChartModel getModel()
	{
		return this.model;
	}
}
