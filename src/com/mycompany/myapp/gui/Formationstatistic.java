/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.formation;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.serviceformation;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ghassen
 */
public class Formationstatistic extends SideMenuBaseForm{
    ArrayList<String> datahh = new ArrayList<>();
    public Formationstatistic(Resources res) {
        
         Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        tb.addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e->new Formationclient(res).show() );
        double[] valuer = new double[17] ;
         ArrayList<Integer> datahhemail = new ArrayList<>();
        ArrayList<formation> array=serviceformation.getInstance().getAllTasks("no");
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        
        ArrayList<String> datahhdesc = new ArrayList<>();
        ArrayList<String> datahhdate = new ArrayList<>();
        ArrayList<Integer> datahhid = new ArrayList<>();
        
        for(formation t:array){
           datahh.add(t.getSujet());
          datahhid.add(t.getId());
          
        }
        
        System.out.println(datahhid);
        for(int i=0 ;i<datahhid.size();i++){  
            int idfor=datahhid.get(i);
            //System.out.println(idfor);
        
        ArrayList<User> array2=serviceformation.getInstance().getlistparticipants(idfor);
        ArrayList<Map<String, Object>> data2 = new ArrayList<>();
        ArrayList<String> datahhnom = new ArrayList<>();
        ArrayList<String> datahhprenom = new ArrayList<>();
       
        
        for(User t:array2){
           datahhnom.add(t.getNom());
           
           
        }
        datahhemail.add(datahhnom.size());
        valuer[i]=datahhnom.size();
           
        }
        
        System.out.println("heyyyyyyyyyyyyy"+valuer);
         
        Label titr=new Label("Visualisation de l'effectif des formations");
        titr.getAllStyles().setBgColor(0x0000FF);
        
    // Generate the values
    //double[] values = new double[]{12, 14, 11, 10, 19};
    double[] values = valuer;
        //System.out.println(values);
    // Set up the renderer
    int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN, ColorUtil.MAGENTA, ColorUtil.GRAY, ColorUtil.LTGRAY, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN, ColorUtil.MAGENTA, ColorUtil.GRAY, ColorUtil.GREEN, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN, ColorUtil.MAGENTA, ColorUtil.GRAY, ColorUtil.GREEN,ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN, ColorUtil.MAGENTA, ColorUtil.GRAY, ColorUtil.GREEN, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN, ColorUtil.MAGENTA, ColorUtil.GRAY, ColorUtil.GREEN, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN, ColorUtil.MAGENTA, ColorUtil.GRAY, ColorUtil.GREEN};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextSize(20);
    renderer.setDisplayValues(true);
    
    renderer.setShowLabels(true);
    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setGradientEnabled(true);
    r.setGradientStart(0, ColorUtil.BLUE);
    r.setGradientStop(0, ColorUtil.GREEN);
    r.setHighlighted(true);

    // Create the chart ... pass the values and renderer to the chart object.
    PieChart chart = new PieChart(buildCategoryDataset("Project budget", values), renderer);
     
    // Wrap the chart in a Component so we can add it to a form
    ChartComponent c = new ChartComponent(chart);

    // Create a form and show it.
    Form f = new Form("Statistique", new BorderLayout());
    f.add(BorderLayout.CENTER, c);
    
        add(f);
       

}
    
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(50);
    renderer.setLabelsColor(0xFF0000);
   renderer.setLegendTextSize(0);
    
    renderer.setMargins(new int[]{20, 30, 15, 0});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}

/**
 * Builds a category series using the provided values.
 *
 * @param titles the series titles
 * @param values the values
 * @return the category series
 */
protected CategorySeries buildCategoryDataset(String title, double[] values) {
    CategorySeries series = new CategorySeries(title);
    
    int k = 0;
    String b="";
    for (double value : values ) {
        
        
        if(k>datahh.size()-2)
        {
       // k=1;
        b="ffrgh";
        }
        else {k++;
        b=datahh.get(k);
    }
        System.out.println("vvv"+k);
         series.add(b, value);//mochkleeeeeee
       
    }
    
    return series;
}

    @Override
    protected void showOtherForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
