package View;

import GUI.GUIForecastWeather;
import GUI.GUIGeneral;
import GUI.GUIMainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class ViewForecastWeather extends ViewGeneral
{
    public ViewForecastWeather(ArrayList<JComponent> components, JFrame parentFrame)
    {
	super(components, parentFrame);
	init();
    }
    
    private void init()
    {
	manageListeners();
    }
    
    @Override
    protected void assingListener(JComponent comp)
    {
	if (comp instanceof JButton)
	{
	    JButton btn = (JButton)comp;
	    switch (btn.getName())
	    {
		case GUIForecastWeather.textBtnForecast24Hours:
		    btn.addActionListener(new ListenerBtnForecast24Hours());
		    break;
		case GUIForecastWeather.textBtnForecast5Days:
		    btn.addActionListener(new ListenerBtnForecast5Days());
		    break;
		case GUIForecastWeather.textBtnForecastRefresh:
		    btn.addActionListener(new ListenerBtnForecastRefresh());
		    break;
		case GUIGeneral.textBtnReturn:
		    btn.addActionListener(new ListenerBtnReturn());
		    break;
	    }
	}
    }
    
    //Κλάση ακροατή για το πλήκτρο Πρόβλεψη Καιρού 1ας ημέρας
    class ListenerBtnForecast24Hours implements ActionListener	
    {
	@Override
	public void actionPerformed(ActionEvent e)
	{
	    JOptionPane.showMessageDialog(null, "Feeder");
	}
    }
    
    //Κλάση ακροατή για το πλήκτρο Πρόβλεψη Καιρού 5 ημερών
    class ListenerBtnForecast5Days implements ActionListener	
    {
	@Override
	public void actionPerformed(ActionEvent e)
	{
	    JOptionPane.showMessageDialog(null, "Sejuani jungle");
	}
    }
    
    //Κλάση ακροατή για το πλήκτρο Ανανέωση Πρόβλεψης Καιρού
    class ListenerBtnForecastRefresh implements ActionListener	
    {
	@Override
	public void actionPerformed(ActionEvent e)
	{
	    JOptionPane.showMessageDialog(null, "Noob");
	}
    }
}