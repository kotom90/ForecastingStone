package GUI;

import View.ViewMainMenu;
import java.util.ArrayList;
import javax.swing.*;

public class GUIMainMenu extends GUIGeneral
{
    //τίτλος βασικού παραθύρου
    public static final String textMainFrame = "eWeather";

    //ετικέτες πλήκτρων
    public static final String textBtnWeatherNow = "Ο Καιρός τώρα";
    public static final String textBtnForecastWeather = "Πρόβλεψη Καιρού";
    public static final String textBtnStats = "Στατιστικά";
    public static final String textBtnExit = "Έξοδος";
    
    public GUIMainMenu()
    {
	super(null);
	createGUI();
    }
    
    protected void createGUI()
    {
	JFrame mainFrame = new JFrame();
	mainFrame.setSize(800, 500);
	mainFrame.setTitle(textMainFrame);
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	createButton(textBtnWeatherNow);
	createButton(textBtnForecastWeather);
	createButton(textBtnStats);
	createButton(textBtnExit);

	mainFrame.getContentPane().add(panel);
	new ViewMainMenu(componentList, mainFrame);
	mainFrame.setVisible(true);
    }
}
