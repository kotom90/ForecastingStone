package GUI;

import View.ViewMainMenu;
import java.util.ArrayList;
import javax.swing.*;

public class GUIMainMenu extends JFrame
{
    private ArrayList<JComponent> componentList = new ArrayList<JComponent>();
    public static final String textBtnWeatherNow = "Ο Καιρός τώρα";
    public static final String textBtnForecastWeather = "Πρόβλεψη Καιρού";
    public static final String textBtnStats = "Στατιστικά";
    public static final String textBtnExit = "Έξοδος";
    
    public GUIMainMenu()
    {
	this.setSize(500, 300);
	this.setTitle("De windoov");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel panel = new JPanel();
	
	componentList.add(new JButton(textBtnWeatherNow));
	componentList.add(new JButton(textBtnForecastWeather));
	componentList.add(new JButton(textBtnStats));
	componentList.add(new JButton(textBtnExit));
	
	for(JComponent comp:componentList)
	{
	    panel.add(comp);
	}

	getContentPane().add(panel);
	
	new ViewMainMenu(componentList);
	
	this.setVisible(true);
    }
}
