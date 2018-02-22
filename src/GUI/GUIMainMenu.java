package GUI;

import View.ViewMainMenu;
import java.util.ArrayList;
import javax.swing.*;

public class GUIMainMenu extends GUIGeneral
{

    //ετικέτες πλήκτρων
    public static final String textBtnWeatherNow = "Ο Καιρός τώρα";
    public static final String textBtnForecastWeather = "Πρόβλεψη Καιρού";
    public static final String textBtnStats = "Στατιστικά";
    public static final String textBtnExit = "Έξοδος";
    
    public GUIMainMenu(JFrame parentFrame)
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
	createButton(textBtnWeatherNow);
	createButton(textBtnForecastWeather);
	createButton(textBtnStats);
	createButton(textBtnExit);

	new ViewMainMenu(componentList, _parentFrame);
	reDrawFrame();
    }
}
