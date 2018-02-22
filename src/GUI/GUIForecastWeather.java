package GUI;

import View.ViewForecastWeather;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUIForecastWeather extends GUIGeneral
{
    public static final String textBtnForecast24Hours = "Πρόβλεψη Καιρού 1ας ημέρας";
    public static final String textBtnForecast5Days = "Πρόβλεψη Καιρού 5 ημερών";
    public static final String textBtnForecastRefresh = "Ανανέωση Πρόβλεψης Καιρού";
    
    public GUIForecastWeather(JFrame parentFrame)
    {
	super(parentFrame);
	init();
    }
    
    private void init()
    {
	createGUI();
    }
    
    @Override
    protected void createGUI()
    {
	createButton(textBtnForecast24Hours);
	createButton(textBtnForecast5Days);
	createButton(textBtnForecastRefresh);
	createButton(GUIGeneral.textBtnReturn);
	
	new ViewForecastWeather(componentList, _parentFrame);
	reDrawFrame();
    }
}
