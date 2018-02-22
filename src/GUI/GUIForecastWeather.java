package GUI;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUIForecastWeather extends GUIGeneral
{
    public static String textBtnForecast24Hours = "Πρόβλεψη Καιρού 1ας ημέρας";
    public static String textBtnForecast5Days = "Πρόβλεψη Καιρού 5 ημερών";
    public static String textBtnForecastRefresh = "Ανανέωση Πρόβλεψης Καιρού";
    
    public GUIForecastWeather(JFrame parentFrame)
    {
	super(parentFrame);
	createGUI();
    }
    
    @Override
    protected void createGUI()
    {
	createButton(textBtnForecast24Hours);
	createButton(textBtnForecast5Days);
	createButton(textBtnForecastRefresh);
	createButton(GUIGeneral.textBtnReturn);
	
	_parentFrame.getContentPane().removeAll();
	_parentFrame.getContentPane().add(panel);
	_parentFrame.validate();
	
    }
}
