package View;

import GUI.GUIMainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class ViewMainMenu extends ViewGeneral
{
    public ViewMainMenu(ArrayList<JComponent> components)
    {
	super(components);
	manageListeners();
    }
    
    @Override
    protected void assingListener(JComponent comp)
    {
	if (comp instanceof JButton)
	{
	    JButton btn = (JButton)comp;
	    switch (btn.getText())
	    {
		case GUIMainMenu.textBtnWeatherNow:
		    btn.addActionListener(new ListenerBtnWeatherNow());
		    break;
		case GUIMainMenu.textBtnForecastWeather:
		    btn.addActionListener(new ListenerBtnForecastWeather());
		    break;
		case GUIMainMenu.textBtnStats:
		    btn.addActionListener(new ListenerBtnStats());
		    break;
		case GUIMainMenu.textBtnExit:
		    btn.addActionListener(new ListenerBtnExit());
		    break;
	    }
	}
    }
    
    //Κλάση ακροατή για το κουμπί Ο ΚΑΙΡΟΣ ΤΩΡΑ
    class ListenerBtnWeatherNow implements ActionListener	
    {
	@Override
	public void actionPerformed(ActionEvent e)
	{
	    JOptionPane.showMessageDialog(null, "Feeder");
	}
    }
    
    //Κλάση ακροατή για το κουμπί ΠΡΟΒΛΕΨΗ ΚΑΙΡΟΥ
    class ListenerBtnForecastWeather implements ActionListener	
    {
	@Override
	public void actionPerformed(ActionEvent e)
	{
	    JOptionPane.showMessageDialog(null, "Sejuani jungle");
	}
    }
    
    //Κλάση ακροατή για το κουμπί ΣΤΑΤΙΣΤΙΚΑ
    class ListenerBtnStats implements ActionListener	
    {
	@Override
	public void actionPerformed(ActionEvent e)
	{
	    JOptionPane.showMessageDialog(null, "AFK");
	}
    }
    
    //Κλάση ακροατή για το κουμπί ΕΞΟΔΟΣ
    class ListenerBtnExit implements ActionListener	
    {
	@Override
	public void actionPerformed(ActionEvent e)
	{
	    JOptionPane.showMessageDialog(null, "Report ziggs mid!");
	}
    }
}
