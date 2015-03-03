package evote.model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class Grafica_Resultado implements Serializable{
	private PieChartModel livePieModel;
	 
    public PieChartModel getLivePieModel() {
        int random1 = (int)(Math.random() * 1000);
        int random2 = (int)(Math.random() * 1000);
        int random3 = (int)(Math.random() * 1000);
        int random4 = (int)(Math.random() * 1000);
        
        livePieModel = new PieChartModel();
        
        livePieModel.getData().put("Candidate 1", random1);
        livePieModel.getData().put("Candidate 2", random2);
        livePieModel.getData().put("Candidate 3", random3);
        livePieModel.getData().put("Candidate 4", random4);
        
        livePieModel.setLegendPosition("e");
        livePieModel.setFill(false);
        livePieModel.setShowDataLabels(true);
         
        return livePieModel;
    }
}