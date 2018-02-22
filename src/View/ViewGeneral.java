package View;

import GUI.GUIForecastWeather;
import GUI.GUIMainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;


public abstract class ViewGeneral 
{
    protected ArrayList<JComponent> _components;
    protected JFrame _parentFrame;
    
    public ViewGeneral(ArrayList<JComponent> components, JFrame parentFrame)
    {
	_components = components;
	_parentFrame = parentFrame;
    }
    
    protected void manageListeners()					//συνάρτηση η οποία διαχειρίζεται τους ακροατές του κάθε component
    {
	for (JComponent comp:_components)
	{
	    assingListener(comp);
	}
    }
    
    protected abstract void assingListener(JComponent comp);		//αφηρημένη συνάρτηση που θα υλοποιηθεί σε κάθε προβολή (View) με τον δικό της κώδικα
    
    class ListenerBtnReturn implements ActionListener			//ο ακροατής του πλήκτρου επιστροφής
    {
	@Override
	public void actionPerformed(ActionEvent e)
	{
	    new GUIMainMenu(_parentFrame);
	}
    }
}
